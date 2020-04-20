package com.example.counter;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.counter.listener.changeValueOnClickListener;

public class ShowCounterActivity extends AppCompatActivity {
    TextView tVValue;
    ActionBar bar;
    ImageButton btnIncrease, btnDecrease;
    CounterEntry entry;
    long value = 0;
    int color;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_counter);

        btnIncrease = findViewById(R.id.btnIncrease);
        btnDecrease = findViewById(R.id.btnDecrease);
        tVValue = findViewById(R.id.tVValue);

        Intent i = getIntent();
        entry = (CounterEntry) i.getSerializableExtra("entry");
        String title = entry.getTitleOfEntry();
        value = entry.getValue();
        color = entry.getTileColor();


        tVValue.setText(value+"");

        bar = getSupportActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(color));
        bar.setTitle(title);

        btnIncrease.setOnClickListener(new changeValueOnClickListener(entry, 0,1));
        btnIncrease.setOnClickListener(new changeValueOnClickListener(entry, 1,1));
    }
}
