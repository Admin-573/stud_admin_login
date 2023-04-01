package com.example.stud_admin_login;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
EditText edt1,edt2,edt3,edt4,edt5;
RadioGroup r1;
RadioButton rdb1,rdb2;
Spinner sp1;
String[] items={"BCA","BBA","BSC"};
Button btn1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt1 = findViewById(R.id.EditName);
        edt2 = findViewById(R.id.EditPass);
        edt3 = findViewById(R.id.EditEmail);
        edt4 = findViewById(R.id.EditPhone);
        edt5 = findViewById(R.id.EditDate);
        r1 =  findViewById(R.id.RgGender);
        rdb1 = findViewById(R.id.RbMale);
        rdb2 = findViewById(R.id.RbFemale);

        sp1 = findViewById(R.id.spinner);

        btn1 = findViewById(R.id.BtnSignUP);

        //Spinner
        ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_spinner_item,items);
        sp1.setAdapter(arrayAdapter);
        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        //Date
        edt5.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Calendar calendar = Calendar.getInstance();
                int year = Calendar.YEAR;
                int month = Calendar.MONTH;
                int day = Calendar.DAY_OF_MONTH;

                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        edt5.setText(day+"/"+(month+1)+"/"+year);
                    }
                },
                        year,month,day);
                datePickerDialog.show();
                return true;
            }
        });

        //Sign_Up Button
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(valid())
                {
                    String name = edt1.getText().toString();
                    String pass = edt2.getText().toString();
                    String email = edt3.getText().toString();
                    String phno = edt4.getText().toString();
                    String dt = edt5.getText().toString();
                    String selectvalue1 = ((RadioButton)findViewById(r1.getCheckedRadioButtonId())).getText().toString();
                    String selectvalue2 = sp1.getSelectedItem().toString();

                    Intent intent = new Intent(getApplicationContext(),signup.class);
                    intent.putExtra("Name:",name);
                    intent.putExtra("Pass:",pass);
                    intent.putExtra("Email:",email);
                    intent.putExtra("PhNo:",phno);
                    intent.putExtra("Date:",dt);
                    intent.putExtra("Gender:",selectvalue1);
                    intent.putExtra("Designation:",selectvalue2);

                    startActivity(intent);
                }
            }
        });
    }
    private boolean valid()
    {
        if(edt1.getText().toString().isEmpty())
        {
            Toast.makeText(this, "Name Cannot Be Empty.", Toast.LENGTH_SHORT).show();
            return false;
        } else if (edt2.getText().toString().isEmpty()) {
            Toast.makeText(this, "Password Cannot Be Empty.", Toast.LENGTH_SHORT).show();
            return false;
        } else if (edt3.getText().toString().isEmpty()) {
            Toast.makeText(this, "Email Cannot Be Empty.", Toast.LENGTH_SHORT).show();
            return false;
        } else if (edt4.getText().toString().isEmpty()){
            Toast.makeText(this, "MobileNo Cannot Be Empty.", Toast.LENGTH_SHORT).show();
            return false;
        } else if (edt5.getText().toString().isEmpty()) {
            Toast.makeText(this, "Date Cannot Be Empty.", Toast.LENGTH_SHORT).show();
            return false;
        } else if (!rdb1.isChecked() && !rdb2.isChecked()){
            Toast.makeText(this, "Please Select Gender.", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}