package com.CS360.LetsRace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TrackList extends AppCompatActivity {


    Button addTrack, editTrack, deleteTrack, settings;
    TrackDBHelper TrackDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track_list);

        addTrack = (Button) findViewById(R.id.addButton);
        editTrack = (Button) findViewById(R.id.editButton);
        deleteTrack = (Button) findViewById(R.id.deleteButton);
        settings = (Button) findViewById(R.id.settingBtn2);

        TrackDB = new TrackDBHelper(this);

        addTrack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), addTrack.class);
                startActivity(intent);
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