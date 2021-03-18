package com.example.safe.Activity_second;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.safe.MainActivity;
import com.example.safe.R;
import com.example.safe.fragment.about_fragment;

public class about_device extends AppCompatActivity {

    private TextView txt_noidung1 , txt_noidung2,txt_noidung3,txt_noidung4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_device);

        // class method Anhxa
        AnhXa();

        // method use by person
        txt_noidung1.setText(R.string.noidung1_about_device);
        txt_noidung2.setText(R.string.noidung2_aboutdevice);
        txt_noidung3.setText(R.string.noidung3_aboutdevice);
        txt_noidung4.setText(R.string.noidung4_aboutdevice);


    }
    // Method Anh Xa
    private void AnhXa(){
        txt_noidung1 = findViewById(R.id.txt_noiDung_aboutDevice);
        txt_noidung2 = findViewById(R.id.txt_noiDung2_aboutDevice);
        txt_noidung3 = findViewById(R.id.txt_noiDung3_aboutDevice);
        txt_noidung4 = findViewById(R.id.txt_noiDung4_aboutDevice);
    }
}