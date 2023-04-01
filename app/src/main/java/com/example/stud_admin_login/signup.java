package com.example.stud_admin_login;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class signup extends AppCompatActivity {
TextView txt1,txt2,txt3,txt4,txt5,txt6,txt7;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        txt1 = findViewById(R.id.txtname);
        txt2 = findViewById(R.id.txtpass);
        txt3 = findViewById(R.id.txtmail);
        txt4 = findViewById(R.id.txtmobile);
        txt5 = findViewById(R.id.txtdate);
        txt6 = findViewById(R.id.txtGender);
        txt7 = findViewById(R.id.txtDesig);

        Intent intent1 = getIntent();
        String name1 = intent1.getStringExtra("Name:");
        String pass1 = intent1.getStringExtra("Pass:");
        String email1 = intent1.getStringExtra("Email:");
        String phno1 = intent1.getStringExtra("PhNo:");
        String date1 = intent1.getStringExtra("Date:");
        String gender1 = intent1.getStringExtra("Gender:");
        String Desig1 = intent1.getStringExtra("Designation:");

        txt1.setText(name1);
        txt2.setText(pass1);
        txt3.setText(email1);
        txt4.setText(phno1);
        txt5.setText(date1);
        txt6.setText(gender1);
        txt7.setText(Desig1);

    }
}