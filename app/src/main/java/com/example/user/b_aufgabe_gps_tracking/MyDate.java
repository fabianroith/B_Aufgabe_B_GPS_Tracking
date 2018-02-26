package com.example.user.b_aufgabe_gps_tracking;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by User on 12.02.2018.
 */

public class MyDate {
    private final static DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy", Locale.GERMAN);
    private final static DateFormat timeFormat = new SimpleDateFormat("hh:mm");
    private String formatted_date;
    private String formatted_time;

    public MyDate(long milliseconds) {
        Date date = new Date(milliseconds);
        formatted_date = dateFormat.format(date);
        formatted_time = timeFormat.format(date);
    }

    public String getFormatted_date() {
        return formatted_date;
    }

    public void setFormatted_date(String formatted_date) {
        this.formatted_date = formatted_date;
    }

    public String getFormatted_time() {
        return formatted_time;
    }

    public void setFormatted_time(String formatted_time) {
        this.formatted_time = formatted_time;
    }
}
