package com.example.all_chores;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;

public class Page6ExtractorHood extends Fragment {
    private FloatingActionButton floatingActionButton1;

    public Page6ExtractorHood() {
        // required empty public constructor.
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment6, container, false);

        Button one = (Button) view.findViewById(R.id.Button1);
        Button two = (Button) view.findViewById(R.id.Button2);
        Button three = (Button) view.findViewById(R.id.Button3);
        Button four = (Button) view.findViewById(R.id.Button4);
        Button five = (Button) view.findViewById(R.id.Button5);
        Button tips = (Button) view.findViewById(R.id.Tips);

        one.setOnClickListener(getListener(inflater.inflate(R.layout.fragment6a, container, false)));
        two.setOnClickListener(getListener(inflater.inflate(R.layout.fragment6b, container, false)));
        three.setOnClickListener(getListener(inflater.inflate(R.layout.fragment6c, container, false)));
        four.setOnClickListener(getListener(inflater.inflate(R.layout.fragment6d, container, false)));
        five.setOnClickListener(getListener(inflater.inflate(R.layout.fragment6e, container, false)));
        tips.setOnClickListener(getListener(inflater.inflate(R.layout.fragment6tips, container, false)));
        floatingActionButton1 = (FloatingActionButton) view.findViewById(R.id.floatingActionButton1);
        floatingActionButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Page6ExtractorHood.this.getActivity(),CalendarActivity.class);
                intent.putExtra(CalendarActivity.EXTRA_MESSAGE_TITLE,"Extractor Hood");
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