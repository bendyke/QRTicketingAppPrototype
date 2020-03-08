package com.example.neptunticketingsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.neptunticketingsystem.QRText";
    // EditText nameEditText = findViewById(R.id.nameEditText);
    // EditText neptuncodeEditText = findViewById(R.id.neptuncodeEditText);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button gen_btn = (Button) findViewById(R.id.button);


       gen_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                toQRActivityIntent();
                }
            });

        }


    public String prepString(EditText text1, EditText text2){
        String complete = text1.getText().toString().trim() + "\n" + text2.getText().toString().trim();
        return complete;
    }
    public void toQRActivityIntent(){
        EditText nameEditText = findViewById(R.id.nameEditText);
        EditText neptuncodeEditText = findViewById(R.id.neptuncodeEditText);

        Intent ToQRIntent = new Intent(this, QRCodeActivity.class);
        String forIntent = prepString(nameEditText, neptuncodeEditText);
        ToQRIntent.putExtra(EXTRA_MESSAGE, forIntent);
        startActivity(ToQRIntent);
    }

}


