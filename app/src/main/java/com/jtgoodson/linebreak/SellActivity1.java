package com.jtgoodson.linebreak;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
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
        System.out.println("here");
        locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
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

        // first check for permissions
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(new String[]{Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.INTERNET}
                        , 10);
            }
            return;
        }
        locationManager.requestLocationUpdates("gps", 1000, 0, locationListener);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        System.out.println("entering onRequestPermissionsResult");
        switch (requestCode) {
            case 10:
                System.out.println("Build.VERSION.SDK_INT = " + Build.VERSION.SDK_INT);
                System.out.println("Build.VERSION_CODES.M = " + Build.VERSION_CODES.M);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                        System.out.println("requesting permission");
                        requestPermissions(new String[]{
                                Manifest.permission.ACCESS_FINE_LOCATION
                                , Manifest.permission.ACCESS_COARSE_LOCATION
                                , Manifest.permission.INTERNET
                        }, 10);
                        return;
                    }
                }
            default:
                break;
        }
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
