package com.example.all_chores;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ShowEvents extends AppCompatActivity {
    private String date;
    private Button dateTextView;
    private TableLayout table;
    private static ArrayList<Event> events;
    private final int[] margins = {10,2,10,2};
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_events);
        Intent intent = getIntent();
        dateTextView = (Button) findViewById(R.id.titleShowEvents);
        date = intent.getStringExtra(CalendarActivity.EXTRA_MESSAGE);
        dateTextView.setText(date);
        table = (TableLayout)findViewById(R.id.tabletask);
        table.setColumnStretchable(0,true);
        events = CalendarActivity.getMyDataBase().getEventsOnDate(date);
        for(Event event:events){
            TableRow tr= new TableRow(this);
            TableLayout.LayoutParams tableRowParams= new TableLayout.LayoutParams
                    (TableLayout.LayoutParams.FILL_PARENT,TableLayout.LayoutParams.WRAP_CONTENT);
            tableRowParams.setMargins(margins[0],margins[1],margins[2],margins[3]);
            tr.setLayoutParams(tableRowParams);
            Button bt = new Button(this);
            bt.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, 120));
            bt.setTextColor(Color.BLACK);
            bt.setBackgroundColor(Color.RED);
            bt.setText(event.getDescription());
            tr.addView(bt);
            table.addView(tr);
        }
    }
}
