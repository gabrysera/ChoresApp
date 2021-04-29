package com.example.all_chores;

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

import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;

public class Page2 extends Fragment {

    public Page2() {
        // required empty public constructor.
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment2, container, false);

        Button one = (Button) view.findViewById(R.id.Button1);
        Button two = (Button) view.findViewById(R.id.Button2);
        Button three = (Button) view.findViewById(R.id.Button3);
        Button four = (Button) view.findViewById(R.id.Button4);
        Button five = (Button) view.findViewById(R.id.Button5);
        Button six = (Button) view.findViewById(R.id.Button6);
        Button tips = (Button) view.findViewById(R.id.Tips);

        one.setOnClickListener(getListener(inflater.inflate(R.layout.fragment2a, container, false)));
        two.setOnClickListener(getListener(inflater.inflate(R.layout.fragment2b, container, false)));
        three.setOnClickListener(getListener(inflater.inflate(R.layout.fragment2c, container, false)));
        four.setOnClickListener(getListener(inflater.inflate(R.layout.fragment2d, container, false)));
        five.setOnClickListener(getListener(inflater.inflate(R.layout.fragment2e, container, false)));
        six.setOnClickListener(getListener(inflater.inflate(R.layout.fragment2f, container, false)));
        tips.setOnClickListener(getListener(inflater.inflate(R.layout.fragment2tips, container, false)));
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
