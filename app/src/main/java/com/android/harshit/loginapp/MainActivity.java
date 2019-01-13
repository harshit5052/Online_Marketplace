package com.android.harshit.loginapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText Name;
    private EditText Password;
    private TextView Info;
    private Button login;
    private Button signup;
    private int counter=10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name=(EditText)findViewById(R.id.entername);
        Password=(EditText)findViewById(R.id.enterpasword);
        Info=(TextView) findViewById(R.id.tvinfo);
        login=(Button) findViewById(R.id.loginbutton);
        signup=(Button)findViewById(R.id.btsignup);
        Info.setText("No. of attempts remaining: 10");

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Signup.class));
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(Name.getText().toString(),Password.getText().toString());
            }
        });

    }

    private void validate(String userName,String userPassword){
        if ((userName.equals("Harshit") )&&( userPassword.equals("12345"))){
            Intent intent= new Intent(MainActivity.this,SecondAcyivity.class);
            startActivity(intent);
        }else {
                counter--;

            Info.setText("No. of attempts remaining: " + String.valueOf(counter));
            if (counter==0){
                login.setEnabled(false);
            }

        }
    }
}
