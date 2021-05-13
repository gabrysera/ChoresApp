package com.example.all_chores;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class DataBase extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "DataBaseEvents";
    public static final String EVENTS_TABLE_NAME = "events";
    public static final String EVENTS_DESCRIPTION_COLUMN = "description";
    public static final String EVENTS_DATE_COLUMN = "date";

    public DataBase(Context context){
        super(context, DATABASE_NAME , null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "create table " +EVENTS_TABLE_NAME +
                        " (_uID " + "INTEGER PRIMARY KEY AUTOINCREMENT, "+ EVENTS_DESCRIPTION_COLUMN +" text, "+EVENTS_DATE_COLUMN+ " text)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS events");
        onCreate(db);
    }

    public long addEventToDataBase(String description,String date){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(EVENTS_DESCRIPTION_COLUMN, description);
        contentValues.put(EVENTS_DATE_COLUMN, date);
        long bb = db.insert(EVENTS_TABLE_NAME, null, contentValues);
        return bb;
    }
    public ArrayList<Event> getEventsOnDate (String date){
        ArrayList<Event> eventsOnDay = new ArrayList<>();
        Cursor r = getData(date);
        r.moveToFirst();
        while(!r.isAfterLast()){
            Log.d("Tag",r.getString(r.getColumnIndex(EVENTS_DATE_COLUMN))+ date);
            if (r.getString(r.getColumnIndex(EVENTS_DATE_COLUMN)).equals(date)){
                eventsOnDay.add(new Event(r.getString(r.getColumnIndex(EVENTS_DESCRIPTION_COLUMN)),date));
            }
            r.moveToNext();
        }
        return eventsOnDay;
    }

    public Cursor getData(String date) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from events", null );
        return res;
    }

}
