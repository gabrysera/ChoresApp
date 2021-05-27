package com.example.all_chores;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
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
import java.util.Date;

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
            int no_tasks = 0;
            //Now date is set to the current date, so that we can use that to search for instances
            //in the database where this is equal to.
            //I'm not sure though how the date is saved in the database, so I'm not sure whether this
            //can be used this way.
            Date today = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/YYYY");
            String date_today = formatter.format(today);

            //count nr of tasks where date is equal to date_today and set no_tasks equal to that amount.

            TextView left = findViewById(R.id.events1);
            TextView right = findViewById(R.id.events2);
            left.setText("You have\nplanned");
            right.setText(no_tasks+" tasks\nfor today.");
        }
}
