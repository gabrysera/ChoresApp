package com.example.all_chores;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;

import com.example.all_chores.ui.main.SectionsPagerAdapter;

public class ChoresInformation extends AppCompatActivity {
    private ViewPager viewPager;
    private SectionsPagerAdapter sectionsPagerAdapter;
    private Button back;
    private FloatingActionButton help;
    private TabLayout tabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chores_information);
        viewPager = findViewById(R.id.view_pager);

        sectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        sectionsPagerAdapter.addFrag(new Page1Laundry(), "Laundry");
        sectionsPagerAdapter.addFrag(new Page2Dishes(), "Dishes");
        sectionsPagerAdapter.addFrag(new Page3Bathroom(), "Bathroom");
        sectionsPagerAdapter.addFrag(new Page4Windows(), "Windows");
        sectionsPagerAdapter.addFrag(new Page5GasStove(), "Gas Stove");
        sectionsPagerAdapter.addFrag(new Page6ExtractorHood(), "Extractor Hood");

        viewPager.setAdapter(sectionsPagerAdapter);

        tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);

        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChoresInformation.this, MainPage.class);
                startActivity(intent);
                finish();
            }
        });

        help = findViewById(R.id.fab);
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "View detailed steps and tips by clicking the purple buttons or " +
                        "add it to the calendar with the plus.", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
}