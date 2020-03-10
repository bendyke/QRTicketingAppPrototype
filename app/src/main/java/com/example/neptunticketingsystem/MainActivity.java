package com.example.neptunticketingsystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.neptunticketingsystem.QRText";
    public final int STORAGE_READ_CODE = 1;
    public final int STORAGE_WRITE_CODE = 2;
    public boolean hasExtra;
    public String[] data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        requestPermissions();


        Button gen_btn = (Button) findViewById(R.id.button);
        Button pdf_btn = (Button) findViewById(R.id.pdf_btn);
        final TextView nameText = (TextView) findViewById(R.id.nameTextView);
        final TextView courseText = (TextView) findViewById(R.id.courseTextView);
        final TextView extrasText = (TextView) findViewById(R.id.extrasTextView);
        final EditText neptunEditText = findViewById(R.id.neptunEditText);


       gen_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                toQRActivityIntent(data, hasExtra);
                }
            });

       pdf_btn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
            hasExtra = false;
            data = pdfDataExtract();
            neptunEditText.setText(data[1]);
            nameText.setText(data[0]);
            courseText.setText(data[2]);
            if(data[3] != null){
                extrasText.setText(data[3]);
                hasExtra = true;
            }
           }
       });

        }


    public void toQRActivityIntent(String[] data, Boolean hasExtra){

        Intent ToQRIntent = new Intent(this, QRCodeActivity.class);
        String forIntent = data[0] + data[1] + data[2];
        if(hasExtra = true){
            forIntent = forIntent + data[3];
        }

        ToQRIntent.putExtra(EXTRA_MESSAGE, forIntent);
        startActivity(ToQRIntent);
    }
    public void requestPermissions(){
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, STORAGE_READ_CODE);
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, STORAGE_WRITE_CODE);
    }
    public String[] pdfDataExtract(){
        PDFExtractor extractor = new PDFExtractor();
        return extractor.extractPDFData();
    }



}


