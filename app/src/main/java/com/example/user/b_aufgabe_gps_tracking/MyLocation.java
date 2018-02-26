package com.example.user.b_aufgabe_gps_tracking;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by User on 12.02.2018.
 */

public class MyLocation {
    private double longitude;
    private double latitude;
    private MyDate date;

    public MyLocation(double longitude, double latitude, long millisecs) {
        this.longitude = longitude;
        this.latitude = latitude;
        date = new MyDate(millisecs);
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public MyDate getDate() {
        return date;
    }

    public void setDate(MyDate date) {
        this.date = date;
    }
}
