package com.example.all_chores;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class AddTaskView extends AppCompatActivity {
    private Button dateTextView;
    private EditText descriptionText;
    private String date;
    private EditText getTitle;
    private EditText getTime;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_task_page);
        Intent intent = getIntent();
        date = intent.getStringExtra(CalendarActivity.EXTRA_MESSAGE);
        dateTextView = (Button) findViewById(R.id.buttonTitleAddTask);
        dateTextView.setText(date);
        getTitle = (EditText) findViewById(R.id.Title);
        getTime = (EditText) findViewById(R.id.editTextTime);
        descriptionText = (EditText) findViewById(R.id.TaskDescription);
        setDateTextView(date);
        Button back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddTaskView.this, CalendarActivity.class);
                startActivity(intent);
            }
        });
    }

    public void setDateTextView(String s) {
        dateTextView.setText(s);
    }

    public void addEvent(View view) {
        if (checkEventTexts(getTime.getText().toString())) {
            CalendarActivity.getMyDataBase().addEventToDataBase(getTitle.getText().toString(), descriptionText.getText().toString(), date, getTime.getText().toString());
            finish();
        } else
            Toast.makeText(getApplicationContext(), "the chosen format is incorrect, please type the time in this format \"HH:MM\".", Toast.LENGTH_SHORT).show();
    }

    public boolean checkEventTexts(String time) {
        if (time.length() >= 4 || time.length() <= 5) {
            Pattern p = Pattern.compile("([01]?[0-9]|2[0-3]):[0-5][0-9]");
            Matcher m = p.matcher(time);
            if (m.matches()) {
                if (time.length() == 4) {
                    StringBuilder s = new StringBuilder("0");
                    s.append(time);
                    getTime.setText(s.toString());
                }
                return true;
            }
            return false;
        }
        return false;
    }
}