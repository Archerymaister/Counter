package com.example.counter;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.counter.listener.showEntryOnClickListener;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

@SuppressWarnings("serial")
public class CounterEntry extends MainActivity implements Serializable {
    private static TreeMap<Integer,CounterEntry> listOfEntries = new TreeMap<>();
    private int tileColor;
    private String title;
    private long value = 0;
    private Date creationDate;
    private Map<Date, Long> changes;
    private transient Context context;

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

    /**
     * Decide wether the counter should be increased or decreased and by which amount.
     * <ul>
     *     <li>0 = add</li>
     *     <li>1 = subtract</li>
     * </ul>
     * @param operation
     * @param value Amount by which the counter shall be altered
     */
    public void alterValue(int operation, int value){
        switch (operation){
            case 0:
                this.value += value;
                break;
            case 1:
                this.value -= value;
                break;
            default:
        }
    }

    public void showEntry(){
        Intent rtn = new Intent(context, ShowCounterActivity.class);
        rtn.putExtra("entry", CounterEntry.this);
        context.startActivity(rtn);
    }

    public static void loadEntries(LinearLayout parent){
        for(CounterEntry curEntry : listOfEntries.values()){
            parent.addView(curEntry.tile(parent));
        }
    }

    public static TreeMap<Integer, CounterEntry> getListOfEntries() {
        return listOfEntries;
    }

    public static void setListOfEntries(TreeMap<Integer, CounterEntry> listOfEntries) {
        CounterEntry.listOfEntries = listOfEntries;
    }

    public int getTileColor() {
        return tileColor;
    }

    public void setTileColor(int tileColor) {
        this.tileColor = tileColor;
    }

    public String getTitleOfEntry() {
        return title;
    }

    public void setTitleOfEntry(String title) {
        this.title = title;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Map<Date, Long> getChanges() {
        return changes;
    }

    public void setChanges(Map<Date, Long> changes) {
        this.changes = changes;
    }
}
