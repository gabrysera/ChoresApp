package com.example.all_chores;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class AddTaskView extends AppCompatActivity {
    private Button dateTextView;
    private EditText descriptionText;
    private String date;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_task_layout);
        Intent intent = getIntent();
        date = intent.getStringExtra(CalendarActivity.EXTRA_MESSAGE);
        dateTextView = (Button) findViewById(R.id.buttonTitleAddTask);
        dateTextView.setText(date);
        descriptionText = (EditText) findViewById(R.id.TaskDescription);
        setDateTextView(date);

    }
    public void setDateTextView(String s){
        dateTextView.setText(s);
    }

    public void addEvent(View view){

        CalendarActivity.getMyDataBase().addEventToDataBase(descriptionText.getText().toString(),date);
        //CalendarActivity.getEvents().add(new Event(descriptionText.getText().toString(),date));
        finish();
    }
}
