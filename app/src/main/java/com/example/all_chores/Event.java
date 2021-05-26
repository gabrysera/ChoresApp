package com.example.all_chores;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Event implements Comparable<Event> {
    private String description;
    private String title;
    private String date;
    private String time;
    private static final SimpleDateFormat simpleDateFormat
            = new SimpleDateFormat("HH:mm:ss");
    private int year;
    private int month;
    private int day;

    public Event(String title, String description, String date, String time) {
        this.title=title;
        this.description = description;
        this.date = date;
        this.year = findYear(date);
        this.month = findMonth(date);
        this.day = findDay(date);
        this.time = time;
    }

    @Override
    public int compareTo(Event o) {
        StringBuilder t1 = new StringBuilder(this.time);
        t1.append (":00");
        StringBuilder t2 = new StringBuilder(o.time);
        t1.append (":00");
        try {
            Date time1 = simpleDateFormat.parse(t1.toString());
            Date time2 = simpleDateFormat.parse(t2.toString());
            long differenceInMilliSeconds
                    = Math.abs(time2.getTime() - time1.getTime());
            long differenceInHours
                    = (differenceInMilliSeconds / (60 * 60 * 1000))
                    % 24;
            long differenceInMinutes
                    = (differenceInMilliSeconds / (60 * 1000)) % 60;

            if(differenceInHours != 0)
                return (int)-differenceInHours;
            else if (differenceInMinutes != 0)
                return (int) -differenceInMinutes;
            else
                return 1;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 1;
    }

    private int findYear(String date){
        String lastFourDigits = "";     //substring containing last 4 characters

        if (date.length() > 4)
        {
            lastFourDigits = date.substring(date.length() - 4);
        }
        return Integer.parseInt(lastFourDigits);
    }
    // 3/5/2021   12/6/2021 12/12/2021
    private int findMonth(String date){
        char c1;
        char c2;
        if(date.charAt(3) != '/')
            c1 = date.charAt(3);
        else
            c1 = ' ';
        if(date.charAt(4) != '/')
            c2 = date.charAt(4);
        else
            c2=' ';
        String intMonth = (String.valueOf(c1) + String.valueOf(c2));
        return Integer.parseInt(intMonth);
    }
    private int findDay(String date){
        char c1;
        char c2;
        if(date.charAt(0) != '/')
            c1 = date.charAt(3);
        else
            c1 = ' ';
        if(date.charAt(1) != '/')
            c2 = date.charAt(4);
        else
            c2=' ';
        String intDay = (String.valueOf(c1) + String.valueOf(c2));
        return Integer.parseInt(intDay);
    }

    public String getTime() {
        return time;
    }

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
