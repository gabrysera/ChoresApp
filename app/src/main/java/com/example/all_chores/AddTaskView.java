package com.example.all_chores;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class AddTaskView extends AppCompatActivity {
    private Button dateTextView;
    private EditText descriptionText;
    private String date;
    private EditText getTitle;
    private EditText getTime;
    private String titleFromPage;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_task_page);
        Intent intent = getIntent();
        date = intent.getStringExtra(CalendarActivity.EXTRA_MESSAGE);
        titleFromPage = intent.getStringExtra(CalendarActivity.EXTRA_MESSAGE_TITLE);
        dateTextView = (Button) findViewById(R.id.buttonTitleAddTask);
        dateTextView.setText(date);
        getTitle = (EditText) findViewById(R.id.Title);
        if(titleFromPage != null)
            getTitle.setText(titleFromPage);
        getTime = (EditText) findViewById(R.id.editTextTime);
        descriptionText = (EditText) findViewById(R.id.TaskDescription);
        setDateTextView(date);
        Button back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                Intent intent = new Intent(AddTaskView.this, CalendarActivity.class);
                startActivity(intent);
                 */
                finish();
            }
        });
        FloatingActionButton fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "You can specify the title, description and time of the chore " +
                        "and add it to your calendar with the button.", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
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
            Toast.makeText(getApplicationContext(), "The chosen format is incorrect, please type the time in this format \"HH:MM\".", Toast.LENGTH_LONG).show();
    }

    private boolean checkEventTexts(String time) {
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