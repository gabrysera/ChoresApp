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

public class ShowEvents extends AppCompatActivity {
    private String date;
    private Button dateTextView;
    private TableLayout table;

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
        for(Event event:CalendarActivity.events){
            if(event.getDate().equals(this.date)){
                TableRow tr= table.findViewById(R.id.taskRow);
                ((TextView)tr.findViewById(R.id.textTask)).setText(event.getDescription());
            }
        }
    }
}
