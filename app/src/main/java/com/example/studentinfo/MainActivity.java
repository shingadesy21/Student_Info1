package com.example.studentinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText roll_edt,pass_edt;
Button login_btn;
Helper helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        roll_edt=findViewById(R.id.roll_edt);
        pass_edt=findViewById(R.id.pass_edt);
        login_btn=findViewById(R.id.login);
        helper=new Helper(this);
        LogIn();
    }

    private void LogIn() {
    login_btn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {


            String id=roll_edt.getText().toString();
            String ps=pass_edt.getText().toString();


        }
    });
    }
}
