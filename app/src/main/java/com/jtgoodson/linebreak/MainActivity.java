package com.jtgoodson.linebreak;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goToSell1(View view) {
        Intent intent = new Intent(this, SellActivity1.class);
        startActivity(intent);
    }

    public void goToBuy1(View view) {
        Intent intent = new Intent(this, BuyActivity1.class);
        startActivity(intent);
    }
}
