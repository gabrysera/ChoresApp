package com.example.all_chores;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Event implements Comparable<Event> {
    private String description;
    private String title;
    private String date;
    private String time;
    public Event(String title, String description, String date, String time) {
        this.title=title;
        this.description = description;
        this.date = date;
        this.time = time;
    }

    @Override
    public int compareTo(Event o) {
        String[] parts1 = this.time.split(":");
        int h1 = Integer.parseInt(parts1[0]);
        int m1 = Integer.parseInt(parts1[1]);
        String[] parts2 = o.getTime().split(":");
        int h2 = Integer.parseInt(parts2[0]);
        int m2 = Integer.parseInt(parts2[1]);
        if(h1 == h2)
            return (m1-m2);
        else
            return (h1-h2);
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
