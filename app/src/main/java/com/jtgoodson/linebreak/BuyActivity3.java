package com.jtgoodson.linebreak;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class BuyActivity3 extends AppCompatActivity {

    TextView txt_buy3_message;
    Integer selectedId;
    String messageTemplate = "Success!  You've agreed to purchase spot #{ID}. Please proceed to the " +
            "location of the spot to pay the seller and claim his or her spot in line.";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy3);

        Intent receivedIntent = getIntent();
        selectedId = receivedIntent.getIntExtra("id", -1);

        txt_buy3_message = (TextView) findViewById(R.id.txt_buy3_message);
        String message = messageTemplate.replace("{ID}", String.valueOf(selectedId));
        txt_buy3_message.setText(message);

    }

    public void goToMain(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
