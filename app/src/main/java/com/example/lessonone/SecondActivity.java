package com.example.lessonone;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    private EditText name;
    private EditText password;
    private EditText numberPassword;
    private EditText email;
    private EditText phoneNumber;
    private Button getInfoBtn;
    private TextView resultView;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        name = (EditText) findViewById(R.id.edit_text_person_name);
        password = (EditText) findViewById(R.id.edit_text_password);
        numberPassword = (EditText) findViewById(R.id.edit_text_number_password);
        email = (EditText) findViewById(R.id.edit_text_email);
        phoneNumber = (EditText) findViewById(R.id.edit_text_phone);
        getInfoBtn = (Button) findViewById(R.id.button_result);
        resultView = (TextView) findViewById(R.id.result);
        getInfoBtn.setOnClickListener(v -> {
            String getName = name.getText().toString();
            String getPassword = password.getText().toString();
            String getNumbPassword = numberPassword.getText().toString();
            String getEmail = email.getText().toString();
            String getPhone = phoneNumber.getText().toString();
            String result = String.format(" Имя: %s\n Пароль: %s\n Числовой пароль: %s\n Email: %s\n Телефон: %s\n", getName, getPassword, getNumbPassword, getEmail, getPhone);
            resultView.setText(result);
        });

    }
}