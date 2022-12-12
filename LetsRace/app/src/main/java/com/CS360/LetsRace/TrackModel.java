package com.CS360.LetsRace;

public class TrackModel {

    private String trackName;
    private String Date;
    private String Address;
    private String Description;
    private int id;

    // creating getter and setter methods
    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // constructor
    public TrackModel(String trackName, String Date, String Address, String Description) {
        this.trackName = trackName;
        this.Date = Date;
        this.Address = Address;
        this.Description = Description;
    }



}
