package com.CS360.LetsRace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class addTrack extends AppCompatActivity {

    EditText trackName, trackDate, trackAddress, trackDescription;
    Button submitTrack;
    TrackDBHelper TrackDB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_track);

        trackName = (EditText) findViewById(R.id.trackTitle);
        trackDate = (EditText) findViewById(R.id.trackDate);
        trackAddress = (EditText) findViewById(R.id.trackAddress);
        trackDescription = (EditText) findViewById(R.id.trackSummary);

        submitTrack = (Button) findViewById(R.id.submitTrack);

        TrackDB = new TrackDBHelper(this);


        submitTrack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = trackName.getText().toString();
                String date = trackDate.getText().toString();
                String address = trackAddress.getText().toString();
                String description = trackDescription.getText().toString();

                if(name.equals("") || date.equals("") || address.equals("") || description.equals(""))
                    Toast.makeText(addTrack.this, "Please enter all the fields",Toast.LENGTH_SHORT).show();
                else {
                    Boolean insert = TrackDB.insertData(name, date, address, description);
                    if(insert == true) {
                        Toast.makeText(addTrack.this, "Track Added", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(getApplicationContext(), TrackList.class);
                        startActivity(intent);
                    }
                    else {
                        if(insert == false) {
                            Toast.makeText(addTrack.this, "insert failed", Toast.LENGTH_LONG).show();
                        }
                    }

                }





            }
        });


    }
}