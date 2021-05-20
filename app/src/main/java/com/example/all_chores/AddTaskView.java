package com.example.all_chores;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class AddTaskView extends AppCompatActivity {
    private Button dateTextView;
    private EditText descriptionText;
    private String date;
    private EditText getTitle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_task_layout);
        Intent intent = getIntent();
        date = intent.getStringExtra(CalendarActivity.EXTRA_MESSAGE);
        dateTextView = (Button) findViewById(R.id.buttonTitleAddTask);
        dateTextView.setText(date);
        getTitle = (EditText) findViewById(R.id.Title);
        descriptionText = (EditText) findViewById(R.id.TaskDescription);
        setDateTextView(date);
    }
    public void setDateTextView(String s){
        dateTextView.setText(s);
    }

    public void addEvent(View view){
        CalendarActivity.getMyDataBase().addEventToDataBase(getTitle.getText().toString(),descriptionText.getText().toString(),date);
        finish();
    }
}
