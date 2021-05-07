package com.example.all_chores;

public class Event implements Comparable<Event> {
    private String description;
    private String date;
    private int year;
    private int month;
    private int day;
    public Event(String description, String date) {
        this.description = description;
        this.date = date;
        this.year = findYear(date);
        this.month = findMonth(date);
        this.day = findDay(date);
    }

    @Override
    public int compareTo(Event o) {
        if(this.year != o.getYear())
            return this.year - o.getYear();
        else if (this.month != o.getMonth())
            return this.month - o.getMonth();
        else if (this.day != o.getDay())
            return this.day - o.getDay();
        return 0;
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

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
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
}
