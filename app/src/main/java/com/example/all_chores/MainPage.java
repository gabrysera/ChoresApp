package com.example.all_chores;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;
/*
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.viewpager.widget.ViewPager;
*/
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Hashtable;

public class MainPage extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.main_page);

            //ViewPager viewPager = findViewById(R.id.view_pager);

            //viewPager.setAdapter(R.id.main_content);

            Button exit = findViewById(R.id.nav_drawer);
            exit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    DrawerLayout drawer = findViewById(R.id.drawer_layout);
                       drawer.openDrawer(Gravity.NO_GRAVITY);
                }
            });

            Button calendar = findViewById(R.id.btn_calender);
            calendar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainPage.this, CalendarActivity.class);
                    startActivity(intent);
                }
            });

            Button info = findViewById(R.id.btn_information);
            info.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainPage.this, ChoresInformation.class);
                    startActivity(intent);
                }
            });

            FloatingActionButton fab = findViewById(R.id.fab);

            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Snackbar.make(view, "You can view the calendar or information about house chores " +
                            "by clicking on the buttons.", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            });
            eventsOfDay();
        }

        public void eventsOfDay() {
            String date_today = CalendarActivity.sdf.format(new Date());

            ArrayList<Event> events = CalendarActivity.getMyDataBase().getEventsOnDate(date_today);
            //CalendarActivity.getMyDataBase() returns null, and I therefore get a NullPointerException.
            //I tested it with putting random Events in the arraylist and that worked, so if we solve
            //the problem of the nullpointerException, then it's ready to go.
            TableLayout table = (TableLayout)findViewById(R.id.tabletask);
            table.setColumnStretchable(0,true);
            Collections.sort(events);
            int c=0;
            Hashtable<Button, Integer> numbers = new Hashtable<Button,Integer>();
            for(Event event:events){
                TableRow tr= new TableRow(this);
                TableLayout.LayoutParams tableRowParams= new TableLayout.LayoutParams
                        (TableLayout.LayoutParams.FILL_PARENT,TableLayout.LayoutParams.WRAP_CONTENT);
                tableRowParams.setMargins(10,10,10,10);
                tr.setLayoutParams(tableRowParams);
                Button bt = new Button(this);
                numbers.put(bt,c);
                bt.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, 100));
                bt.setTextColor(Color.BLACK);
                bt.setBackgroundColor(Color.RED);
                bt.setText(event.getTitle());
                tr.addView(bt);
                table.addView(tr);
                c++;
            }
        }
}
