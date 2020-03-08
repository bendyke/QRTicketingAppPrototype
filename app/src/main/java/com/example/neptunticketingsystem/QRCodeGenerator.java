package com.example.neptunticketingsystem;

import android.graphics.Bitmap;
import android.widget.ImageView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class QRCodeGenerator {

    private MultiFormatWriter multiFormatWriter;
    private BitMatrix bitMatrix;
    private BarcodeEncoder barcodeEncoder;
    private Bitmap QRCodeBitmap;

    QRCodeGenerator(){
        multiFormatWriter = new MultiFormatWriter();
        barcodeEncoder = new BarcodeEncoder();
    }

    public Bitmap getQRCodeBitmap(String textForQRCode){
        try {
            bitMatrix = multiFormatWriter.encode(textForQRCode, BarcodeFormat.QR_CODE, 200, 200);
            QRCodeBitmap = barcodeEncoder.createBitmap(bitMatrix);
        }catch (WriterException e){
            e.printStackTrace();
        }
        return QRCodeBitmap;
    }

}
