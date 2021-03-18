package com.example.safe.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.safe.MainActivity;
import com.example.safe.R;

public class Start_screen extends AppCompatActivity {

    ImageView image_logo;
    TextView textView_one;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);

        // goi ham anh xa
        anhxa();

       Runnable runnable  = new Runnable() {
           @Override
           public void run() {
               Intent intent =   new Intent(Start_screen.this, dieukhoan.class);
                startActivity(intent);
                finish();
           }
       };

       Handler handler = new Handler();
       handler.postDelayed(runnable , 2000);
    }

    private void anhxa() {
        image_logo = findViewById(R.id.image_logo_safe);
        textView_one = findViewById(R.id.id_khau_lenh_logo);

    }
}