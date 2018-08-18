package com.jtgoodson.linebreak;

import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SellActivity1 extends AppCompatActivity {


    private EditText txt_sell1_location_desc;
    private EditText txt_sell1_extra_details;
    private DAO dao;
    private LocationManager locationManager;
    private LocationListener locationListener;
    private double currentLatitude;
    private double currentLongitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell1);

        txt_sell1_location_desc = (EditText) findViewById(R.id.txt_location_desc);
        txt_sell1_extra_details = (EditText) findViewById(R.id.txt_extra_details);
        dao = new DAO(this, null, null, 1);
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
//                lbl_newEntry_location.setText(String.format("Location: %s,%s", location.getLatitude(), location.getLongitude()));
                currentLatitude = location.getLatitude();
                currentLongitude = location.getLongitude();
            }

            @Override
            public void onStatusChanged(String s, int i, Bundle bundle) {

            }

            @Override
            public void onProviderEnabled(String s) {

            }

            @Override
            public void onProviderDisabled(String s) {
                Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivity(intent);
            }
        };
    }

    public void insertRecord(View view) {

        boolean successfullyAdded = false;

        if (txt_sell1_location_desc.length() < 1) {
            Toast.makeText(this, "Location must be entered!", Toast.LENGTH_SHORT).show();
        } else {

            Spot spot = new Spot(txt_sell1_location_desc.getText().toString(), txt_sell1_extra_details.getText().toString(), currentLatitude, currentLongitude);
            successfullyAdded = dao.addNewRecord(spot);

            if (!successfullyAdded) {
                Toast.makeText(this, "error saving", Toast.LENGTH_LONG).show();
            } else {
                Intent i = new Intent(this, SellActivity2.class);
                startActivity(i);
            }


        }
    }
}
