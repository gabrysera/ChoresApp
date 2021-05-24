package com.example.all_chores;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class AddTaskView extends AppCompatActivity {
    private Button dateTextView;
    private EditText descriptionText;
    private String date;
    private EditText getTitle;
    private EditText getTime;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_task_layout);
        Intent intent = getIntent();
        date = intent.getStringExtra(CalendarActivity.EXTRA_MESSAGE);
        dateTextView = (Button) findViewById(R.id.Modifytask);
        dateTextView.setText(date);
        getTitle = (EditText) findViewById(R.id.Titlemodify);
        getTime = (EditText) findViewById(R.id.editTextTimemodify);
        descriptionText = (EditText) findViewById(R.id.DescriptionModify);
        setDateTextView(date);
    }
    public void setDateTextView(String s){
        dateTextView.setText(s);
    }

    public void addEvent(View view){
        if(checkEventTexts(getTime.getText().toString())){
            CalendarActivity.getMyDataBase().addEventToDataBase(getTitle.getText().toString(),descriptionText.getText().toString(),date,getTime.getText().toString());
            finish();
        }
        else
            Toast.makeText(getApplicationContext(),"the chosen hour is incorrect, please change your input.", Toast.LENGTH_SHORT).show();
    }

    public boolean checkEventTexts (String time){
        return true;
    }
}
