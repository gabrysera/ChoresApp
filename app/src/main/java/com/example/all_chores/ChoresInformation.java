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

//import javax.swing.text.View;

public class ChoresInformation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chores_information);

        ViewPager viewPager = findViewById(R.id.view_pager);

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        sectionsPagerAdapter.addFrag(new Page1Laundry(), "Laundry");
        sectionsPagerAdapter.addFrag(new Page2Dishes(), "Dishes");
        sectionsPagerAdapter.addFrag(new Page3Bathroom(), "Bathroom");
        sectionsPagerAdapter.addFrag(new Page4Windows(), "Windows");
        sectionsPagerAdapter.addFrag(new Page5GasStove(), "Gas Stove");
        sectionsPagerAdapter.addFrag(new Page6ExtractorHood(), "Extractor Hood");

        viewPager.setAdapter(sectionsPagerAdapter);

        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);

        Button back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChoresInformation.this, MainActivity.class);
                startActivity(intent);
            }
        });

        FloatingActionButton fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "House chores can be selected at the top." +
                        "Steps or tips are shown when clicked on.", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
}