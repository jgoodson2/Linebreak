package com.jtgoodson.linebreak;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class BuyActivity1 extends AppCompatActivity {

    DAO dao;
    ListView listViewSpots;
    String itemFormatTemplate = "{LISTINGDETAIL} ID: {ID}";
    String itemIdString = "ID: ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy1);
        dao = new DAO(this, null, null, 1);
        listViewSpots = (ListView) findViewById(R.id.lv_spots);

        populateListView();
    }

    private void populateListView() {
        System.out.println("populating list view");
        Cursor data = dao.getAllRecords();
        ArrayList<String> spotArrayList = new ArrayList<>();
        while (data.moveToNext()) {
            String item = itemFormatTemplate;
            item = item.replace("{LISTINGDETAIL}", data.getString(2));
            item = item.replace("{ID}", data.getString(0));
            spotArrayList.add(item);
        }
        ListAdapter listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, spotArrayList);
        listViewSpots.setAdapter(listAdapter);

        listViewSpots.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String selection = adapterView.getItemAtPosition(i).toString();
                String id = selection.substring(selection.indexOf(itemIdString) + itemIdString.length()).trim();
                System.out.println("onItemClick: You Clicked on " + id);

                Intent goToViewSpot = new Intent(BuyActivity1.this, BuyActivity2.class);
                goToViewSpot.putExtra("id", Integer.parseInt(id));
                startActivity(goToViewSpot);

            }
        });
    }
}
