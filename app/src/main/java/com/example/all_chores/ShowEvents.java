package com.example.all_chores;



import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.Nullable;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;


public class ShowEvents extends AppCompatActivity {
    private String date;
    private Button dateTextView;
    public static TableLayout table;
    private static ArrayList<Event> events;
    private final int[] margins = {14,4,14,4};
    public static Event event;
    private Hashtable<Button, Integer> numbers;
    private int c;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_events_page);
        Intent intent = getIntent();
        dateTextView = (Button) findViewById(R.id.titleShowEvents);
        date = intent.getStringExtra(CalendarActivity.EXTRA_MESSAGE);
        dateTextView.setText(date);
        table = (TableLayout)findViewById(R.id.tabletask);
        table.setColumnStretchable(0,true);
        events = CalendarActivity.getMyDataBase().getEventsOnDate(date);
        Collections.sort(events);
        c=0;
        numbers = new Hashtable<Button,Integer>();
        for(Event event:events){
            TableRow tr= new TableRow(this);
            TableLayout.LayoutParams tableRowParams= new TableLayout.LayoutParams
                    (TableLayout.LayoutParams.FILL_PARENT,TableLayout.LayoutParams.WRAP_CONTENT);
            tableRowParams.setMargins(margins[0],margins[1],margins[2],margins[3]);
            tr.setLayoutParams(tableRowParams);
            Button bt = new Button(this);
            numbers.put(bt,c);
            bt.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, 100));
            bt.setTextColor(Color.BLACK);
            bt.setBackgroundColor(Color.RED);
            bt.setText(event.getTitle());
            bt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v)
                {
                    changeActivity(event,bt);
                }
            });
            tr.addView(bt);
            table.addView(tr);
            c++;
        }
        Button back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                Intent intent = new Intent(ShowEvents.this, CalendarActivity.class);
                startActivity(intent);
                */
                 finish();
            }

        });
        FloatingActionButton fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "You can modify a scheduled chore " +
                        "by clicking on it.", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private void changeActivity(Event event,Button button){
        Intent i = new Intent(this,ModifyEvent.class);
        this.event=event;
        i.putExtra("int",numbers.get(button));
        startActivity(i);
    }

    public static void deleteButton(int c){
        table.removeViewAt(c);
    }
}
