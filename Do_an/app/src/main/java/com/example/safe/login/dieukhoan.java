package com.example.safe.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.safe.MainActivity;
import com.example.safe.R;

public class dieukhoan extends AppCompatActivity {


    // phần này khai báo các thành phần layout
    private TextView txt_nddk1 , txt_tieptuc , txt_nddk2 , txt_nddk3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dieukhoan);

        // thực hiện ánh xạ các view id trên activity điều khoản
        txt_nddk1 = findViewById(R.id.txt_nddk1);
        txt_tieptuc = findViewById(R.id.txt_tieptuc_dk);
        txt_nddk2 = findViewById(R.id.txt_nddk2);
        txt_nddk3 = findViewById(R.id.txt_nddk3);




        // thực hiện thành phần
        txt_nddk1.setText(R.string.noidung_dieukhoan1);
        txt_nddk2.setText(R.string.noidung_dieukhoan1);
        txt_nddk3.setText("Việt Nam Sẽ Chiến Thắng Covid-19!");
        txt_tieptuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( new Intent(dieukhoan.this , login_taikhoan.class));
                finish();
            }
        });

    }
}