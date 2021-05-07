package com.example.all_chores;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
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
    private TableRow table;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_events);
        Intent intent = getIntent();
        dateTextView = (Button) findViewById(R.id.titleShowEvents);
        date = intent.getStringExtra(CalendarActivity.EXTRA_MESSAGE);
        dateTextView.setText(date);
        table = (TableRow)findViewById(R.id.table_layout);

        for(Event event:CalendarActivity.events){
            if(event.getDate() == date){
                Button btn = new Button(this);
                btn.setText(event.getDescription());
                btn.setBackgroundColor(Color.BLACK);
                btn.setTextColor(Color.WHITE);
                table.addView(btn);
            }
        }
    }
}
