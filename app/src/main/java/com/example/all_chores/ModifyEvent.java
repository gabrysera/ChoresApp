package com.example.all_chores;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.example.all_chores.R;

public class ModifyEvent extends AppCompatActivity {
    private Event event;
    private Button buttonDelete;
    private Button buttonChange;
    private Boolean delete;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.modify_events);
        this.event = ShowEvents.event;
        delete = false;
        int color = ContextCompat.getColor(this, R.color.purple_500);
        buttonChange = (Button) findViewById(R.id.button_save_changes);
        buttonDelete = (Button) findViewById(R.id.button_delete);
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
    }

    public void deleteEvent(){
        CalendarActivity.getMyDataBase().deleteData(event.getTitle(),event.getDescription(),event.getDate());
    }

    public void changeTime(){
        event.setTime("i");
    }
    public void changeTitle(){
        event.setTitle("i");
    }
    public void changeDescription(){
        event.setTitle("i");
    }
}
