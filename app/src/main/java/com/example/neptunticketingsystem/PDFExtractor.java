package com.example.neptunticketingsystem;

import android.text.TextUtils;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.util.Arrays;
import java.util.Scanner;

public class PDFExtractor {

    private File pdffile = new File("/storage/emulated/0/Download/", "NKW4DC.pdf");
    private String parsedtext;
    private PdfReader reader;
    private String[] trimmed;


    public String[] extractPDFData(){

        try {
            reader = new PdfReader(String.valueOf(pdffile));
            parsedtext   = PdfTextExtractor.getTextFromPage(reader, 1);
            String[] lines = parsedtext.split(System.getProperty("line.separator"));
            for (int i = 1; i < lines.length; i++) {
                if(lines[i].contains("Powered by TCPDF (www.tcpdf.org)")){
                    trimmed = new String[i-3];
                    for (int j = 0; j < trimmed.length; j++){
                        trimmed[j] = lines[j+1];
                    }
                }
            }
            reader.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
        return trimmed;
    }
}
