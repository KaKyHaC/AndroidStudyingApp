package com.example.dima.studyingapplication;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends Activity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        recyclerView = initRecycleView(this);
        setContentView(recyclerView);
    }

    private static List<String> getStringList() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            list.add("text" + i);
        }
        return list;
    }

    private static RecyclerView initRecycleView (Context context) {
        RecyclerView recyclerView = new RecyclerView(context);

        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        recyclerView.setLayoutParams(layoutParams);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layoutManager);

        MyAdapter adapter = new MyAdapter();
        recyclerView.setAdapter(adapter);
        adapter.setData(getStringList());

        return recyclerView;
    }

    private static class MyAdapter extends RecyclerView.Adapter {

        class MyViewHolder extends RecyclerView.ViewHolder {

            TextView textView;

            MyViewHolder(View itemView) {
                super(itemView);
                textView = (TextView) itemView;
                textView.setBackgroundColor(Color.YELLOW);
                textView.setTextColor(Color.BLUE);
            }
        }

        List<String> data = new ArrayList<>();

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            TextView textView = new TextView(parent.getContext());
            ViewGroup.LayoutParams layoutParam = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            textView.setLayoutParams(layoutParam);

            return new MyViewHolder(textView);
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            ((MyViewHolder)holder).textView.setText(data.get(position));
        }

        @Override
        public int getItemCount() {
            return data.size();
        }

        public void setData(List<String> data) {
            this.data = data;
            notifyDataSetChanged();
        }
    }
}
