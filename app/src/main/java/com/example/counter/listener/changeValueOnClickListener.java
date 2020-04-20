package com.example.counter.listener;

import android.view.View;

import com.example.counter.CounterEntry;

public class changeValueOnClickListener implements View.OnClickListener {

    int operation;
    int value;
    CounterEntry entry;

    /**
     * Decide wether the counter should be increased or decreased and by which amount. If no value is specified it will be altered by 1.
     * <ul>
     *     <li>0 = add</li>
     *     <li>1 = subtract</li>
     * </ul>
     * @param operation
     *
     */
    public changeValueOnClickListener(CounterEntry entry, int operation){
        new changeValueOnClickListener(entry, operation,1);
    }

    /**
     * Decide wether the counter should be increased or decreased and by which amount.
     * <ul>
     *     <li>0 = add</li>
     *     <li>1 = subtract</li>
     * </ul>
     * @param operation
     * @param value Amount by which the counter shall be altered
     */
    public changeValueOnClickListener(CounterEntry entry, int operation, int value){
        this.operation = operation;
        this.value = value;
        this.entry = entry;
    }

    @Override
    public void onClick(View v) {
        entry.alterValue(operation,value);
    }
}
