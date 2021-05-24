package com.example.all_chores;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.text.SimpleDateFormat;
import java.util.Date;


public class CalendarActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "date";
    private  static CalendarView myCalendarView;
    private Button seeEvents;
    private Button back;
    private Button addTask;
    private String date;
    private Date currentDate;
    static DataBase myDataBase;
    private final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendar_page);
        myDataBase = new DataBase(this);
        myCalendarView = (CalendarView) findViewById(R.id.calendarView);
        seeEvents = (Button) findViewById(R.id.showeventsbutton1);
        back = (Button) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CalendarActivity.this, MainPage.class);
                startActivity(intent);
            }
        });
        FloatingActionButton fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "You can select a day in the calendar and view or add tasks " +
                        "to that day with the buttons.", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        addTask = (Button) findViewById(R.id.addTaskButton1);

        String selectedDate = sdf.format(new Date(myCalendarView.getDate()));
        date = selectedDate;
        seeEvents.setText("chores of day: "+selectedDate);
        addTask.setText("add chore on day: "+selectedDate);
        myCalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {

                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                String selectedDate = sdf.format(new Date(year-1900,month,dayOfMonth));
                date = selectedDate;
                seeEvents.setText("chores of day: " + selectedDate);
                addTask.setText("add chore on day: " + selectedDate);
            }
        });
    }

    public void goToCreateTask(View view){
        Intent i = new Intent(this, AddTaskView.class);
        i.putExtra(EXTRA_MESSAGE,date);
        startActivity(i);
    }

   public void goToShowEvent(View view){
        Intent i = new Intent(this, ShowEvents.class);
        i.putExtra(EXTRA_MESSAGE,date);
        startActivity(i);
    }

    public static CalendarView getMyCalendarView() {
        return myCalendarView;
    }

    public static DataBase getMyDataBase() {
        return myDataBase;
    }
}