package com.example.counter;

import android.content.Context;
import android.graphics.Color;
import android.text.Layout;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

public class CounterEntry {
    private static TreeMap<Integer,CounterEntry> listOfEntries = new TreeMap<>();
    private Color tileColor;
    private String title;
    private long value = 0;
    private Date creationDate;
    private Map<Date, Long> changes;
    private Context context;

    public CounterEntry(Color color, String title, Context context){
        new CounterEntry(color,title,0, context);
    }

    public CounterEntry(Color color, String title, long value, Context context){
        this.tileColor = color;
        this.title = title;
        this.value = value;
        this.context = context;
        listOfEntries.put(listOfEntries.size(),this);
    }

    private View tile(){
        return new Button(context);
    }



    public static void loadEntries(LinearLayout parent){
        for(CounterEntry curEntry : listOfEntries.values()){
            parent.addView(curEntry.tile());
        }
    }
}
