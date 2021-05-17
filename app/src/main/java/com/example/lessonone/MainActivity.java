package com.example.lessonone;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText editName;
    private EditText editSurname;
    private Switch smokingSwitch;
    private Switch alcoholSwitch;
    private CheckBox checkBoxDriverLicense;
    private Button send;
    private Button changeActivivty;
    private TextView textViewResult;
    private String sex;
    private String smokingHabit;
    private String alcoholHabit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editName = (EditText) findViewById(R.id.edit_name);
        editSurname = (EditText) findViewById(R.id.edit_surname);
        smokingSwitch = (Switch) findViewById(R.id.switch_smoking);
        alcoholSwitch = (Switch) findViewById(R.id.switch_alcohol);
        checkBoxDriverLicense = (CheckBox) findViewById(R.id.checkbox_driver_license);
        send = (Button) findViewById(R.id.btn_send);
        textViewResult = (TextView) findViewById(R.id.text_view_result);
        changeActivivty = (Button) findViewById(R.id.change_activity);

        sex = getString(R.string.male);
        smokingHabit = getString(R.string.no);
        alcoholHabit = getString(R.string.no);

        smokingSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (smokingSwitch.isChecked()) {
                smokingHabit = getString(R.string.yes);
            } else {
                smokingHabit = getString(R.string.no);
            }
        });
        alcoholSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (alcoholSwitch.isChecked()) {
                alcoholHabit = getString(R.string.yes);
            } else {
                alcoholHabit = getString(R.string.no);
            }
        });


        send.setOnClickListener(v -> {
            String name = editName.getText().toString();
            String surname = editSurname.getText().toString();
            String driverLicense = "";
            if (checkBoxDriverLicense.isChecked()) {
                driverLicense = getString(R.string.have);
            } else {
                driverLicense = getString(R.string.have_no);
            }
            String result = String.format(" Имя: %s \n Фамилия: %s \n Пол: %s\n Курение: %s\n Алкоголь: %s\n Водительское Удостоверение: %s\n ", name, surname, sex, smokingHabit, alcoholHabit, driverLicense);
            textViewResult.setText(result);

        });
        changeActivivty.setOnClickListener(v -> {
            Intent intent = new Intent(this, SecondActivity.class);
            startActivity(intent);

        });
    }

    public void changeSex(View view) {
        RadioButton button = (RadioButton) view;
        int id = button.getId();
        if (id == R.id.radio_button_male) {
            sex = getString(R.string.male);
        } else if (id == R.id.radio_button_female) {
            sex = getString(R.string.female);
        }
    }
}