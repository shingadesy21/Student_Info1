package com.example.studentinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.IntArrayEvaluator;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Introscreen extends AppCompatActivity {
EditText name,roll,pass;
Button go_btn;
Helper helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(RestorePrefData())
        {
            Intent mainActivity=new Intent(getApplicationContext(),SplashScreen.class);
            startActivity(mainActivity);
            finish();
        }
        setContentView(R.layout.activity_introscreen_1);
        name=findViewById(R.id.name_txt);
        roll=findViewById(R.id.roll_txt);
        pass=findViewById(R.id.pass_txt);
        go_btn=findViewById(R.id.go);
        helper =new Helper(this);
        Adddata();


    }

    private void Adddata() {
        go_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean isInserted=helper.insert(name.getText().toString(),roll.getText().toString(),pass.getText().toString());
                if (isInserted=true)
                    Toast.makeText(getApplicationContext(),"Data inserted",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(getApplicationContext(),"Data not inserted",Toast.LENGTH_LONG).show();

                Intent main=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(main);

                SavePrefData();

                finish();
            }

            private void SavePrefData() {
                SharedPreferences pref=getApplicationContext().getSharedPreferences("mypref",MODE_PRIVATE);
                SharedPreferences.Editor editor=pref.edit();
                editor.putBoolean("isIntroOpened",true);
                editor.commit();

            }
        });
    }

    private boolean RestorePrefData() {
        SharedPreferences pref=getApplicationContext().getSharedPreferences("mypref",MODE_PRIVATE);
        Boolean isIntroActivityOpenedBefore=pref.getBoolean("isIntroOpened",false);
        return isIntroActivityOpenedBefore;
    }
}
