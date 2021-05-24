package com.example.all_chores;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.all_chores.R;

public class ModifyEvent extends AppCompatActivity {
    private String time;
    private String description;
    private String title;
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.modify_events);
        Intent intent = getIntent();
        title=intent.getStringExtra("title");
        description=intent.getStringExtra("description");
        time=intent.getStringExtra("time");

    }
}
