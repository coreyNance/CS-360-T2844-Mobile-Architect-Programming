package com.CS360.LetsRace;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import androidx.annotation.Nullable;

import java.util.ArrayList;

public class TrackDBHelper extends SQLiteOpenHelper {

    public static final String DBNAME = "RaceTracks.db";

    public TrackDBHelper(Context context) {
        super(context,"RaceTracks.db", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase TrackDB) {
       TrackDB.execSQL("create Table tracks(TrackName TEXT primary key, Date TEXT, Address TEXT, Description TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase TrackDB, int i, int i1) {
        TrackDB.execSQL("drop Table if exists tracks");

    }

    public Boolean insertData(String TrackName, String Date, String Address, String Description) {
        SQLiteDatabase TrackDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("TrackName", TrackName);
        contentValues.put("Date", Date);
        contentValues.put("Address", Address);
        contentValues.put("Description", Description);
        long result = TrackDB.insert("tracks", null, contentValues);

        if(result == -1) return false;
        else
            return true;
    }

    // we have created a new method for reading all the courses.
    public ArrayList<TrackModel> readTracks() {
        // on below line we are creating a
        // database for reading our database.
        SQLiteDatabase TrackDB = this.getReadableDatabase();

        // on below line we are creating a cursor with query to read data from database.
        Cursor cursorTracks = TrackDB.rawQuery("SELECT * FROM " + "tracks", null);

        // on below line we are creating a new array list.
        ArrayList<TrackModel> trackModelArrayList = new ArrayList<>();

        // moving our cursor to first position.
        if (cursorTracks.moveToFirst()) {
            do {
                // on below line we are adding the data from cursor to our array list.
                trackModelArrayList.add(new TrackModel(cursorTracks.getString(1),
                        cursorTracks.getString(4),
                        cursorTracks.getString(2),
                        cursorTracks.getString(3)));
            } while (cursorTracks.moveToNext());
            // moving our cursor to next.
        }
        // at last closing our cursor
        // and returning our array list.
        cursorTracks.close();
        return trackModelArrayList;
    }





}
