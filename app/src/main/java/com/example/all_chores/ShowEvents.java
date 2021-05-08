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
                TableRow tr= new TableRow(this);
                tr.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT,TableRow.LayoutParams.WRAP_CONTENT));
                TextView tv = new TextView(this);
                tv.setText(event.getDescription());
                tv.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT,TableRow.LayoutParams.WRAP_CONTENT));
                tv.setTextColor(Color.WHITE);
                tv.setBackgroundColor(Color.BLACK);
                tr.addView(tv);
                table.addView(tr);
            }
        }
    }
}
