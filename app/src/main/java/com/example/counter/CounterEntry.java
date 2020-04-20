package com.example.counter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.counter.listener.showEntryOnClickListener;

import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

import static com.example.counter.R.id.tVTitle;

public class CounterEntry extends MainActivity{
    private static TreeMap<Integer,CounterEntry> listOfEntries = new TreeMap<>();
    private int tileColor;
    private String title;
    private long value = 0;
    private Date creationDate;
    private Map<Date, Long> changes;
    private Context context;

    public CounterEntry(int color, String title, Context context){
        new CounterEntry(color,title,0, context);
    }

    public CounterEntry(int color, String title, long value, Context context){
        this.tileColor = color;
        this.title = title;
        this.value = value;
        this.context = context;
        listOfEntries.put(listOfEntries.size(),this);
    }

    private View tile(LinearLayout parent){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rtn = inflater.inflate(R.layout.entry_tile, parent,false);
        rtn.findViewById(R.id.tile_background).setBackgroundColor(tileColor);

        TextView tVTitle = rtn.findViewById(R.id.textView);
        tVTitle.setText(this.title);
        tVTitle.setOnClickListener(new showEntryOnClickListener(this));
        return rtn;
    }

    public void showEntry(){
        Intent rtn = new Intent(context, ShowCounterActivity.class);
        rtn.putExtra("color", this.tileColor);
        rtn.putExtra("title", this.title);
        rtn.putExtra("value", this.value);
        context.startActivity(rtn);
    }

    public static void loadEntries(LinearLayout parent){
        for(CounterEntry curEntry : listOfEntries.values()){
            parent.addView(curEntry.tile(parent));
        }
    }

}
