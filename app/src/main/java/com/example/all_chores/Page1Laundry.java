package com.example.all_chores;
import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Layout;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import com.example.all_chores.ui.main.SectionsPagerAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.LinkedList;

import static android.view.WindowManager.*;
import static android.view.WindowManager.LayoutParams.*;

public class Page1Laundry extends Fragment {
    private FloatingActionButton floatingActionButton1;
    public Page1Laundry() {
        // required empty public constructor.
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment1, container, false);

        Button one = (Button) view.findViewById(R.id.Button1);
        Button two = (Button) view.findViewById(R.id.Button2);
        Button three = (Button) view.findViewById(R.id.Button3);
        Button four = (Button) view.findViewById(R.id.Button4);
        Button five = (Button) view.findViewById(R.id.Button5);
        Button six = (Button) view.findViewById(R.id.Button6);
        Button seven = (Button) view.findViewById(R.id.Button7);
        Button eight = (Button) view.findViewById(R.id.Button8);
        Button tips = (Button) view.findViewById(R.id.Tips);

        one.setOnClickListener(getListener(inflater.inflate(R.layout.fragment1a, container, false)));
        two.setOnClickListener(getListener(inflater.inflate(R.layout.fragment1b, container, false)));
        three.setOnClickListener(getListener(inflater.inflate(R.layout.fragment1c, container, false)));
        four.setOnClickListener(getListener(inflater.inflate(R.layout.fragment1d, container, false)));
        five.setOnClickListener(getListener(inflater.inflate(R.layout.fragment1e, container, false)));
        six.setOnClickListener(getListener(inflater.inflate(R.layout.fragment1f, container, false)));
        seven.setOnClickListener(getListener(inflater.inflate(R.layout.fragment1g, container, false)));
        eight.setOnClickListener(getListener(inflater.inflate(R.layout.fragment1h, container, false)));
        tips.setOnClickListener(getListener(inflater.inflate(R.layout.fragment1tips, container, false)));
        floatingActionButton1 = (FloatingActionButton) view.findViewById(R.id.floatingActionButton1);
        floatingActionButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Page1Laundry.this.getActivity(),CalendarActivity.class);
                intent.putExtra(CalendarActivity.EXTRA_MESSAGE_TITLE,"Laundry");
                startActivity(intent);
            }
        });
        return view;
    }

    public View.OnClickListener getListener (View view) {
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupWindow pw = new PopupWindow(view, WRAP_CONTENT, WRAP_CONTENT);
                pw.showAtLocation(view, Gravity.CENTER, 0, 0);

                Button close = (Button) view.findViewById(R.id.closeButton);
                close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        pw.dismiss();
                    }
                });
            }
        };
        return listener;
    }
}

