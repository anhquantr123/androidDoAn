package com.example.safe.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.safe.R;

public class login_taikhoan extends AppCompatActivity {

    private TextView txt_email , txt_password , txt_create_account;
    private EditText txt_input_email , txt_input_password;
    ImageButton btn_login;
    private  int check  =0 ; 

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_taikhoan);

        // ánh xạ các thành phần
        txt_input_email = (EditText) findViewById(R.id.txt_input_email_login);
        txt_email = (TextView) findViewById(R.id.txt_login_email_textview);
        txt_create_account = (TextView) findViewById(R.id.txt_create_account);
        txt_password = (TextView) findViewById(R.id.txt_login_password_textview);
        txt_input_password = (EditText) findViewById(R.id.txt_input_password_login);
        btn_login = findViewById(R.id.btn_login);



        // bắt sự kiện*********************
        btn_login.setBackground(this.getResources().getDrawable(R.drawable.ic_color_red));
        txt_email.setText(""); // text view email
        txt_input_email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                txt_email.setText("");

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                txt_email.setText("Email");
                check_input();
            }

            @Override
            public void afterTextChanged(Editable s) {
                if(!txt_input_email.getText().toString().isEmpty()){

                }else{
                    txt_email.setText("");

                }
            }
        });


        txt_password.setText(""); // textview password
        txt_input_password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                txt_password.setText("");

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                txt_password.setText("Password");
                check_input();
            }

            @Override
            public void afterTextChanged(Editable s) {
                if(!txt_input_password.getText().toString().isEmpty()){
                }else{
                    txt_password.setText("");
                }
            }
        });
        
        // sự kiện khi nhấn login 
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(check == 0 ){
                    Toast.makeText(login_taikhoan.this, "Vui lòng nhập email hoặc password", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(login_taikhoan.this, "Nhập Thành Công", Toast.LENGTH_SHORT).show();
                }
            }
        });
        // create new account user
        txt_create_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(login_taikhoan.this , setup_profile_user.class));
                //finish();
            }
        });


    }

    private void check_input() {
        if(!txt_input_password.getText().toString().isEmpty() && !txt_input_email.getText().toString().isEmpty()){
            btn_login.setBackground(this.getResources().getDrawable(R.drawable.ic_color_login));
            check = 1; 
        }else{

        }
    }
}