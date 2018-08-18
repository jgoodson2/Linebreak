package com.jtgoodson.linebreak;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class BuyActivity2 extends AppCompatActivity {

    private DAO dao;
    private int selectedID;
    Cursor recordData;
    TextView txt_buy2_locationDesc;
    TextView txt_buy2_extraDetails;
    TextView txt_buy2_askingPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy2);

        txt_buy2_locationDesc = (TextView) findViewById(R.id.txt_buy2_locationDesc);
        txt_buy2_extraDetails = (TextView) findViewById(R.id.txt_buy2_extraDetails);
        txt_buy2_askingPrice = (TextView) findViewById(R.id.txt_buy2_askingPrice);

        Intent receivedIntent = getIntent();
        selectedID = receivedIntent.getIntExtra("id", -1);
        System.out.println("selectedID = " + selectedID);
        dao = new DAO(this, null, null, 1);
        Long latitude, longitude;
        recordData = dao.getRecordById(selectedID);
        while (recordData.moveToNext()) {
            System.out.println("recordData.getString(0) = " + recordData.getString(0));
            System.out.println("recordData.getString(1) = " + recordData.getString(1));
            System.out.println("recordData.getString(2) = " + recordData.getString(2));
            System.out.println("recordData.getString(3) = " + recordData.getString(3));
            System.out.println("recordData.getLong(4) = " + recordData.getFloat(4));
            System.out.println("recordData.getLong(5) = " + recordData.getFloat(5));
            System.out.println("recordData.getLong(5) = " + recordData.getInt(6));
            System.out.println("recordData.getLong(7) = " + recordData.getFloat(7));

            txt_buy2_locationDesc.setText(recordData.getString(2));
            txt_buy2_extraDetails.setText(recordData.getString(3));
            txt_buy2_askingPrice.setText(String.valueOf(recordData.getFloat(7)));

        }
    }

    public void buySpot(View view) {

        boolean recordUpdated = dao.markRecordUnavailable(selectedID);

        if (!recordUpdated) {
            Toast.makeText(this, "error: something bad happened", Toast.LENGTH_LONG);
        } else {
            Intent goToBuy3 = new Intent(this, BuyActivity3.class);
            goToBuy3.putExtra("id", selectedID);
            startActivity(goToBuy3);
        }


    }
}
