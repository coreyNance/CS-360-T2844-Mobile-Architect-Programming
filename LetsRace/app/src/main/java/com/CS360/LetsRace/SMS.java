package com.CS360.LetsRace;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class SMS extends AppCompatActivity {

    private static final int MY_PERMISSIONS_REQUEST_RECIEVE_SMS = 1;
    Switch smsSwitch;
    Button home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);



        smsSwitch = (Switch) findViewById(R.id.switch1);
        home = (Button) findViewById(R.id.homeBtn);

        smsSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {

                if(isChecked == true) {
                    Toast.makeText(getBaseContext(), "On", Toast.LENGTH_SHORT).show();
                    checkPermission(Manifest.permission.RECEIVE_SMS,
                            MY_PERMISSIONS_REQUEST_RECIEVE_SMS);
                }
                else {
                    Toast.makeText(getBaseContext(), "OFF", Toast.LENGTH_SHORT).show();
                }

            }
        });


        }


    // Function to check and request permission
    public void checkPermission(String permission, int requestCode)
    {
        // Checking if permission is not granted
        if (ContextCompat.checkSelfPermission(SMS.this, permission) == PackageManager.PERMISSION_DENIED) {
            ActivityCompat.requestPermissions(SMS.this, new String[] { permission }, requestCode);
        }
        else {
            Toast.makeText(SMS.this, "Permission already granted", Toast.LENGTH_SHORT).show();
        }
    }



    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantResults)
    {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == MY_PERMISSIONS_REQUEST_RECIEVE_SMS) {

            // Checking whether user granted the permission or not.
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                // Showing the toast message
                Toast.makeText(SMS.this, "SMS Permission Granted", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(SMS.this, "SMS Permission Denied", Toast.LENGTH_SHORT).show();
            }
        }

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), TrackList.class);
                startActivity(intent);
            }
        });

    }






    }



    /*protected void sendSMSMessage() {

        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.SEND_SMS)
                != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.SEND_SMS)) {
            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.SEND_SMS},
                        MY_PERMISSIONS_REQUEST_SEND_SMS);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_SEND_SMS: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    SmsManager smsManager = SmsManager.getDefault();
                    Toast.makeText(getApplicationContext(), "Text notifications granted.",
                            Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(),
                            "SMS faild, please try again.", Toast.LENGTH_LONG).show();
                    return;
                }
            }
        }

    }*/



