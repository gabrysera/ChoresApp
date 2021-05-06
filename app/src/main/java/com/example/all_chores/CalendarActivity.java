package com.example.all_chores;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
/*
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;

import java.util.Calendar;
import java.util.Date;
*/






public class CalendarActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "date";
    private CalendarView myCalendarView;
    private Button seeEvents;
    private Button back;
    private Button addTask;
    private String date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendar_layout);
        myCalendarView = (CalendarView) findViewById(R.id.calendarView);
        seeEvents = (Button) findViewById(R.id.button3);
        back = (Button) findViewById(R.id.button);
        addTask = (Button) findViewById(R.id.button2);
        Calendar c = Calendar.getInstance();
        StringBuilder s = new StringBuilder();
        date = setTextEventsButton(Calendar.getInstance().getTime());
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String selectedDate = sdf.format(new Date(myCalendarView.getDate()));
        seeEvents.setText("events of day: "+selectedDate);

        addTask.setText("add task on day: "+selectedDate);
        myCalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                month++;
                seeEvents.setText("events of day: " + dayOfMonth + "/"  + month + "/" +  year);
                addTask.setText("add task on day: " + dayOfMonth + "/"  + month + "/" +  year);
                date = dayOfMonth + "/"  + month + "/" +  year;
            }
        });
    }
    public void goToCreateTask(View view){

        Intent i = new Intent(this, AddTaskView.class);
        i.putExtra(EXTRA_MESSAGE,date);
        startActivity(i);
    }


    private String setTextEventsButton(Date today) {
        String s = new String(today.toString());
        StringBuilder finalString = new StringBuilder();
        finalString.append("events of day: ");
        String[] split = s.split("\\s+");
        for (String s1 : split) {
            finalString.append(s1+" ");
            if (isANumber(s1))
                return finalString.toString();
        }
        return "error";
    }
    private String setTextAddTaskButton(Date today) {
        String s = new String(today.toString());
        StringBuilder finalString = new StringBuilder();
        finalString.append("Add task on day: ");
        String[] split = s.split("\\s+");
        for (String s1 : split) {
            finalString.append(s1+" ");
            if (isANumber(s1))
                return finalString.toString();
        }
        return "error";
    }
    public static boolean isANumber(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false;
        } catch (NullPointerException e) {
            return false;
        }
        // only got here if we didn't return false
        return true;
    }

}