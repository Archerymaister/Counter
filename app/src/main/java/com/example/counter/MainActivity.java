package com.example.counter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity{
    private FloatingActionButton FABaddEntry;
    private LinearLayout content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FABaddEntry = findViewById(R.id.floatingActionButton3);
        content = (LinearLayout) findViewById(R.id.content);

        CounterEntry.loadEntries(content);

        new CounterEntry(Color.RED,"Test",this);
        new CounterEntry(Color.GREEN,"Test2",this);

        CounterEntry.loadEntries(content);

        FABaddEntry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent createCounter = new Intent(MainActivity.this, CreateCounterActivity.class);
                startActivity(createCounter);
            }
        });

    }
}
