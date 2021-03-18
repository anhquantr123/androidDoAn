package com.example.safe.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.safe.R;

public class create_new_account extends AppCompatActivity {

    private TextView txt_login , txt_email , txt_pass , txt_confirm_pass;
    private EditText input_email, input_pass, input_confirm_pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_account);

        // ánh xạ các  thành phần
        txt_login = findViewById(R.id.txt_login_create_account);
        txt_email = findViewById(R.id.txt_create_account_email_textview);
        txt_pass = findViewById(R.id.txt_create_account_pass_textview);
        txt_confirm_pass = findViewById(R.id.txt_create_account_nhaplaipass);
        input_email = findViewById(R.id.txt_input_email_create_account);
        input_pass = findViewById(R.id.txt_input_pass_create_account);
        input_confirm_pass = findViewById(R.id.txt_input_confrim_pass_create_account);



        // bắt sự kiện
        txt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(create_new_account.this , login_taikhoan.class));
                finish();
            }
        });

        // xử lý sự kiện textview
        txt_pass.setText("");
        txt_confirm_pass.setText("");
        txt_email.setText("");

        //
        input_email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                txt_email.setText("");
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                txt_email.setText("Email");
            }

            @Override
            public void afterTextChanged(Editable s) {
                if(input_email.getText().toString().isEmpty()){
                    txt_email.setText("");
                }
            }
        });
        input_pass.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                txt_pass.setText("");
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                txt_pass.setText("Password");
            }

            @Override
            public void afterTextChanged(Editable s) {
                if(input_pass.getText().toString().isEmpty()){
                    txt_pass.setText("");
                }
            }
        });

        input_confirm_pass.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                txt_confirm_pass.setText("");
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                txt_confirm_pass.setText("Confirm Password");
                String pass = input_pass.getText().toString();
                String check_pass = input_confirm_pass.getText().toString();
                if(pass.equals(check_pass)){
                    input_confirm_pass.setBackground(getApplication().getDrawable(R.drawable.btn_round_blue));
                }else{
                    input_confirm_pass.setBackground(getApplication().getDrawable(R.drawable.btn_round_red));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                if(input_confirm_pass.getText().toString().isEmpty()){
                    txt_confirm_pass.setText("");
                    input_confirm_pass.setBackground(getApplication().getDrawable(R.drawable.btn_round_blue));
                }
            }
        });




    }
}