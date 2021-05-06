package com.example.all_chores;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.all_chores.CalendarActivity;
import com.example.all_chores.R;

public class AddTaskView extends AppCompatActivity {
    private Button dateTextView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_task_layout);
        Intent intent = getIntent();
        String date = intent.getStringExtra(CalendarActivity.EXTRA_MESSAGE);
        dateTextView = (Button) findViewById(R.id.button4);
        dateTextView.setText(date);
        setDateTextView(date);
    }

    public void setDateTextView(String s){
        dateTextView.setText(s);
    }

    public void addEvent(View view){
        finish();
    }
}
