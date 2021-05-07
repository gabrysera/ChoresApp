package com.example.all_chores;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ShowEvents extends AppCompatActivity {
    private String date;
    private Button dateTextView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_events);
        Intent intent = getIntent();
        dateTextView = (Button) findViewById(R.id.titleShowEvents);
        date = intent.getStringExtra(CalendarActivity.EXTRA_MESSAGE);
        dateTextView.setText(date);
    }
}
