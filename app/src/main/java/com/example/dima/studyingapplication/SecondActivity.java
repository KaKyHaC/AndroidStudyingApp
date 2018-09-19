package com.example.dima.studyingapplication;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

public class SecondActivity extends Activity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        recyclerView = initRecycleView(this);
        setContentView(recyclerView);
    }

    private static RecyclerView initRecycleView (Context context) {
        RecyclerView recyclerView = new RecyclerView(context);

        recyclerView.setBackgroundColor(Color.CYAN);

        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        recyclerView.setLayoutParams(layoutParams);


        return recyclerView;
    }
}
