package com.jtgoodson.linebreak;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class BuyActivity1 extends AppCompatActivity {

    DAO dao;
    ListView listViewSpots;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy1);
        dao = new DAO(this, null, null, 1);
        listViewSpots = (ListView) findViewById(R.id.lv_spots);

        populateListView();
    }

    private void populateListView() {
        Cursor data = dao.getAllRecords();
        ArrayList<String> spotArrayList = new ArrayList<>();
        while (data.moveToNext()) {
            spotArrayList.add("item");
        }
        ListAdapter listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, spotArrayList);
        listViewSpots.setAdapter(listAdapter);
    }
}
