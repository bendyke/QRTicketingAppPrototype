package com.example.neptunticketingsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;

public class QRCodeActivity extends AppCompatActivity {
    private Bitmap QRBitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qr_code_layout);

        ImageView QRCode = findViewById(R.id.qr_code_img);

        Intent intent = getIntent();
        String QRData = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        QRCodeGenerator qrCodeGenerator = new QRCodeGenerator();
        QRBitmap = qrCodeGenerator.getQRCodeBitmap(QRData);
        QRCode.setImageBitmap(QRBitmap);

    }
}
