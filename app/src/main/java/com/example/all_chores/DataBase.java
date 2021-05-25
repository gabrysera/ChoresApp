package com.example.all_chores;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;


public class DataBase extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "DataBaseEvents";
    public static final String EVENTS_TABLE_NAME = "events";
    public static final String EVENTS_DESCRIPTION_COLUMN = "description";
    public static final String EVENTS_DATE_COLUMN = "date";
    public static final String EVENTS_TITLE_COLUMN = "title";
    public static final String EVENTS_TIME_COLUMN = "time";

    public DataBase(Context context){
        super(context, DATABASE_NAME , null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "create table " +EVENTS_TABLE_NAME +
                        " (_uID " + "INTEGER PRIMARY KEY AUTOINCREMENT, "
                        + EVENTS_TITLE_COLUMN +" text, "
                        + EVENTS_DESCRIPTION_COLUMN +" text, "
                        + EVENTS_TIME_COLUMN +" text, "
                        + EVENTS_DATE_COLUMN+ " text)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ EVENTS_TABLE_NAME);
        onCreate(db);
    }

    public long addEventToDataBase(String title,String description,String date,String time){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(EVENTS_TIME_COLUMN,time);
        contentValues.put(EVENTS_TITLE_COLUMN, title);
        contentValues.put(EVENTS_DESCRIPTION_COLUMN, description);
        contentValues.put(EVENTS_DATE_COLUMN, date);
        long bb = db.insert(EVENTS_TABLE_NAME, null, contentValues);
        return bb;
    }
//
    public ArrayList<Event> getEventsOnDate (String date){
        ArrayList<Event> eventsOnDay = new ArrayList<>();
        Cursor r = getData(date);
        r.moveToFirst();
        while(!r.isAfterLast()){
            eventsOnDay.add(new Event(r.getString(r.getColumnIndex(EVENTS_TITLE_COLUMN)),r.getString(r.getColumnIndex(EVENTS_DESCRIPTION_COLUMN)),date,r.getString(r.getColumnIndex(EVENTS_TIME_COLUMN))));
            r.moveToNext();
        }
        return eventsOnDay;
    }

    public Cursor getData(String date) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from events where date =" + "'"+date+"'", null );
        return res;
    }

    public void deleteData(String title, String description, String date){
        SQLiteDatabase db = getWritableDatabase();
        StringBuilder s = new StringBuilder();
        s.append("DELETE FROM "+EVENTS_TABLE_NAME+" where "+EVENTS_TITLE_COLUMN+ " = "+title+
        " and "+ EVENTS_DESCRIPTION_COLUMN+" = "+description+ " and "+ EVENTS_DATE_COLUMN+" = "+ date);
        db.execSQL(s.toString());
    }
}
//DELETE FROM events where title = '1' and description = '11' and date = '01/05/2021'