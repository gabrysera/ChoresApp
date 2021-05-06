package com.example.all_chores;

public class Event implements Comparable<Event> {
    private StringBuilder description;
    private StringBuilder date;
    private int year;
    private int month;
    private int day;
    public Event(String description, String date) {
        this.description = new StringBuilder(description);
        this.date = new StringBuilder(date);
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

    private int findMonth(String date){
        String intMonth = (String.valueOf(date.charAt(3)) + String.valueOf(date.charAt(4)));     //substring containing last 4 characters
        return Integer.parseInt(intMonth);
    }
    private int findDay(String date){
        String intMonth = (String.valueOf(date.charAt(0)) + String.valueOf(date.charAt(1)));     //substring containing last 4 characters
        return Integer.parseInt(intMonth);
    }
    public void setDescription(StringBuilder description) {
        this.description = description;
    }

    public void setDate(StringBuilder date) {
        this.date = date;
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
