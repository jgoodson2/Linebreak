package com.jtgoodson.linebreak;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class BuyActivity2 extends AppCompatActivity {

    private DAO dao;
    private int selectedID;
    Cursor recordData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy2);

        Intent receivedIntent = getIntent();
        selectedID = receivedIntent.getIntExtra("id", -1);
        System.out.println("selectedID = " + selectedID);
        dao = new DAO(this, null, null, 1);
        Long latitude, longitude;
        recordData = dao.getRecordById(selectedID);
        while (recordData.moveToNext()) {
//            lbl_viewEntry_subject.setText(recordData.getString(2));
//            lbl_viewEntry_info.setText("Date created: " + recordData.getString(1) +
//                    "\nLatitude: " + recordData.getString(4) +
//                    "\nLongitude: " + recordData.getString(5)
//            );
//            latitude = recordData.getLong(4);
//            longitude = recordData.getLong(5);
//            lbl_viewEntry_content.setText(recordData.getString(3));
//            System.out.println("recordData.getString(0) = " + recordData.getString(0));
            System.out.println("recordData.getString(1) = " + recordData.getString(1));
            System.out.println("recordData.getString(2) = " + recordData.getString(2));
            System.out.println("recordData.getString(3) = " + recordData.getString(3));
            System.out.println("recordData.getLong(4) = " + recordData.getLong(4));
            System.out.println("recordData.getLong(5) = " + recordData.getLong(5));
//            System.out.println("recordData.getString(6) = " + recordData.getInt(6));
        }

    }
}
