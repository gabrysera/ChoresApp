package com.example.all_chores;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.example.all_chores.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ModifyEvent extends AppCompatActivity {
    private Event event;
    private Button buttonDelete;
    private Button buttonChange;
    private Boolean delete;
    private EditText changeTitleText;
    private EditText changeDescriptionText;
    private EditText changeDateText;
    private EditText changeTimeText;
    public int color;
    private int but;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.modify_events);
        this.event = ShowEvents.event;
        delete = false;
        Intent intent = getIntent();
        but = intent.getIntExtra("int",0);
        color = ContextCompat.getColor(this, R.color.purple_500);
        buttonChange = (Button) findViewById(R.id.button_save_changes);
        buttonDelete = (Button) findViewById(R.id.button_delete);
        changeTitleText = (EditText)findViewById(R.id.changeTitle);
        changeTitleText.setText(event.getTitle());
        changeDescriptionText = (EditText)findViewById(R.id.change_description);
        changeDescriptionText.setText(event.getDescription());
        changeDateText = (EditText)findViewById(R.id.ChangeDate);
        changeDateText.setText(event.getDate());
        changeTimeText = (EditText)findViewById(R.id.changeTime);
        changeTimeText.setText(event.getTime());
        setListeners();
    }

    private void setListeners(){
        buttonDelete.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(delete == false){
                    delete=true;
                    buttonDelete.setBackgroundColor(Color.DKGRAY);
                }
                else{
                    delete=false;
                    buttonDelete.setBackgroundColor(color);
                }
            }
        });

        buttonChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(delete){
                    ShowEvents.deleteButton(but);
                   deleteEvent();
                } else if (!checkTime(changeTimeText.getText().toString()) || !checkDate(changeDateText.getText().toString())) {
                    if(!checkTime(changeTimeText.getText().toString())){
                        Toast.makeText(getApplicationContext(), "The chosen time format is incorrect, please type the time in this format \"HH:MM\".", Toast.LENGTH_SHORT).show();
                    } else if (!checkDate(changeDateText.getText().toString())){
                        Toast.makeText(getApplicationContext(), "The chosen date format is incorrect, please type the date in this format \"DD/MM/YYYY\".", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    changeEventPar(changeTitleText.getText().toString(),
                            changeDescriptionText.getText().toString(),
                            changeDateText.getText().toString(),
                            changeTimeText.getText().toString());
                    ShowEvents.changeButton(but,changeTitleText.getText().toString());
                    event.setDate(changeDateText.getText().toString());
                    event.setTime(changeTimeText.getText().toString());
                    event.setDescription(changeDescriptionText.getText().toString());
                    finish();
                }
                /*
                else{

                    if(checkTimeAndDate(changeTimeText.getText().toString(),changeDateText.getText().toString())){
                        changeEventPar(changeTitleText.getText().toString(),
                                changeDescriptionText.getText().toString(),
                                changeDateText.getText().toString(),
                                changeTimeText.getText().toString());
                        ShowEvents.changeButton(but,changeTitleText.getText().toString());
                        event.setDate(changeDateText.getText().toString());
                        event.setTime(changeTimeText.getText().toString());
                        event.setDescription(changeDescriptionText.getText().toString());
                        event.setTitle(changeTitleText.getText().toString());
                    }
                    else
                        Toast.makeText(getApplicationContext(), "The chosen format is incorrect, please type the time in this format \"HH:MM\".", Toast.LENGTH_LONG).show();

                }*/
                //finish();
            }
        });
        FloatingActionButton fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Modify the chore and save changes, " +
                        "or delete it by clicking the left button and then save changes.", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
    public void deleteEvent(){
        CalendarActivity.getMyDataBase().deleteData(event.getTitle(),event.getDescription(),event.getDate());
    }

    public void changeEventPar(String title,String des, String date, String time){
        CalendarActivity.getMyDataBase().changeData(event.getTitle(),event.getDescription(),event.getDate(),title,des,date,time);
    }
/*
    private boolean checkTimeAndDate(String time,String Date){
        if (time.length() >= 4 || time.length() <= 5) {
            Pattern p = Pattern.compile("([01]?[0-9]|2[0-3]):[0-5][0-9]");
            Matcher m = p.matcher(time);
            if (m.matches()) {
                if (time.length() == 4) {
                    StringBuilder s = new StringBuilder("0");
                    s.append(time);
                    changeTimeText.setText(s.toString());
                }
                return true;
            }
            return false;
        }
        return false;
    }
*/
    private boolean checkTime(String time){
        int i =0;
        if (time.length() >= 4 || time.length() <= 5) {
            Pattern p = Pattern.compile("([01]?[0-9]|2[0-3]):[0-5][0-9]");
            Matcher m = p.matcher(time);
            if (m.matches()) {
                if (time.length() == 4) {
                    StringBuilder s = new StringBuilder("0");
                    s.append(time);
                    changeTimeText.setText(s.toString());
                }
                return true;
            }
            return false;
        }
        return false;
    }

    private boolean checkDate(String date){
        if (date.matches("([1-9]{1}|[0]{1}[1-9]{1}|[1]{1}[0-9]{1}|[2]{1}[0-9]{1}|[3]{1}[0-1]{1})" +
                    "([/]{1})" +
                    "([0]{1}[1-9]{1}|[1]{1}[0-2]{1}|[1-9]{1})" +
                    "([/]{1})" +
                    "([20]{2}[0-9]{2})")) {
            return true;
        }
        return false;
    }
}
