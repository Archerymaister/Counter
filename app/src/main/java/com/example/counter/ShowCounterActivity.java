package com.example.counter;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.TextView;

public class ShowCounterActivity extends AppCompatActivity {
    TextView tvTitle;
    ActionBar bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_counter);

        Intent i = getIntent();
        String title = i.getStringExtra("title");
        int color = i.getIntExtra("color",R.color.colorPrimaryDark);

        tvTitle = findViewById(R.id.tVTitle);

        tvTitle.setText(title);

        bar = getSupportActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(color));
        bar.setTitle(title);

    }
}
