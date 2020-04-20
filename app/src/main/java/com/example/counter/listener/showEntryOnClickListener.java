package com.example.counter.listener;

import android.view.View;

import com.example.counter.CounterEntry;

public class showEntryOnClickListener implements View.OnClickListener {

    CounterEntry entry;
    public showEntryOnClickListener(CounterEntry entry){
        this.entry = entry;
    }

    @Override
    public void onClick(View v) {
        entry.showEntry();
    }
}
