package com.example.all_chores;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.example.all_chores.R;

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

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.modify_events);
        this.event = ShowEvents.event;
        delete = false;
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
                    CalendarActivity.getMyDataBase().deleteData(event.getTitle(),event.getDescription(),event.getDate());
                }
                else{
                    if(checkTimeAndDate(changeTimeText.getText().toString(),changeDateText.getText().toString())){
                        changeTime(changeTimeText.getText().toString());
                        changeDate(changeDateText.getText().toString());
                        changeTitle(changeTitleText.getText().toString());
                        changeDescription(changeDescriptionText.getText().toString());
                    }
                }
                finish();
            }
        });
    }
    public void deleteEvent(){
        CalendarActivity.getMyDataBase().deleteData(event.getTitle(),event.getDescription(),event.getDate());
    }

    public void changeTime(String t){
        event.setTime(t);
    }
    public void changeTitle(String t){
        event.setTitle(t);
    }
    public void changeDescription(String des){
        event.setTitle(des);
    }
    public void changeDate(String date){
        event.setDate(date);
    }
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
}
