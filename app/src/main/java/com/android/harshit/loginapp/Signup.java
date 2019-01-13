package com.android.harshit.loginapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Signup extends AppCompatActivity {
     DatabaseHelper mydb;
    private EditText username, userpassword;
    private Button signupbutton;
    private TextView userlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        mydb = new DatabaseHelper(this);
        setupUIviews();
        signupbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validate()){


                   boolean Isinserted= mydb.insertData(username.getText().toString(),userpassword.getText().toString());
                    if(Isinserted)
                        Toast.makeText(Signup.this,"SIGN UP SUCCESSFULL",Toast.LENGTH_LONG).show();
                    else
                        Toast.makeText(Signup.this,"SIGN UP UNSUCCESSFULL",Toast.LENGTH_LONG).show();


                }
            }
        });

        userlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Signup.this, MainActivity.class));
            }
        });
    }

    private void setupUIviews(){
        username=(EditText)findViewById(R.id.etusername);
        userpassword=(EditText)findViewById(R.id.etuserpassword);
        signupbutton=(Button)findViewById(R.id.btnsignup);
        userlogin=(TextView)findViewById(R.id.tvuserlogin);
    }

    private Boolean validate(){
        Boolean value= false;
        String name=username.getText().toString();
        String password=userpassword.getText().toString();

        if ((name.isEmpty()) &&(password.isEmpty())) {
            Toast.makeText(Signup.this, "Please enter all the details", Toast.LENGTH_SHORT).show();
        }
        else {
            value = true;
        }

        return value;
    }
}
