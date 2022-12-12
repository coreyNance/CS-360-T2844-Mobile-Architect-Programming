package com.CS360.LetsRace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class User_Log extends AppCompatActivity {

    EditText username, password;
    Button signup, login, settings;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_log);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);

        signup = (Button) findViewById(R.id.signUpBtn);
        login = (Button) findViewById(R.id.loginBtn);
        settings = (Button) findViewById(R.id.settingBtn);

        DB = new DBHelper(this);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();

                if(user.equals("") || pass.equals(""))
                    Toast.makeText(User_Log.this, "Please enter all the fields",Toast.LENGTH_SHORT).show();
                else {
                    Boolean checkuser = DB.checkusername(user);
                    if(checkuser==false) {
                        Boolean insert = DB.insertData(user, pass);
                        if(insert == true) {
                            Toast.makeText(User_Log.this, "Registered successfully", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(getApplicationContext(), TrackList.class);
                            startActivity(intent);
                        }
                        else {
                            Toast.makeText(User_Log.this, "Registration failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else {
                        Toast.makeText(User_Log.this, "User already exists! please sign in", Toast.LENGTH_SHORT).show();
                    }
                }


            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user = username.getText().toString();
                String pass = password.getText().toString();

                if(user.equals("") || pass.equals(""))
                    Toast.makeText(User_Log.this, "Please enter all the fields",Toast.LENGTH_SHORT).show();
                else {
                    Boolean checkuserpass = DB.checkusernamepassword(user, pass);
                    if(checkuserpass== true) {
                        Toast.makeText(User_Log.this, "Log in successful", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), TrackList.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(User_Log.this, "Invalid Credentials or New user Sign up needed",Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SMS.class);
                startActivity(intent);
            }
        });


    }
}