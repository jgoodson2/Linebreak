package com.jtgoodson.linebreak;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class BuyActivity3 extends AppCompatActivity {

    TextView txt_buy3_message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy3);

        txt_buy3_message = (TextView) findViewById(R.id.txt_buy3_message);

    }
}
