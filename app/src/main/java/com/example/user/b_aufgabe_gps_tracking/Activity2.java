package com.example.user.b_aufgabe_gps_tracking;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Sebastian on 12.02.18.
 */

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2_layout);
        setMenu();

        setList(getData());
    }

    public void setList(ArrayList<String> data)
    {
        ListView lv = findViewById(R.id.listView_entries);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data);
        lv.setAdapter(adapter);
    }

    public ArrayList<String> getData()
    {
        ArrayList<String> data = new ArrayList<>();
        return data;
    }

    public void setMenu()
    {
        ActionBar bar = getSupportActionBar();
        bar.setTitle("Einträge");
        bar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }
}
