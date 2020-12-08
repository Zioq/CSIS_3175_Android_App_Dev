package com.s300299315.relocationmovingtruckrentalapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import android.content.SharedPreferences;
import android.graphics.Paint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;

public class ResultActivity extends AppCompatActivity {

    double price_per_mile = 0.99;
    double result_price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView txtResult = (TextView) findViewById(R.id.txtResult);
        ImageView image = (ImageView) findViewById(R.id.imgResult);

        SharedPreferences sharePref = PreferenceManager.getDefaultSharedPreferences(this);
        int mile = sharePref.getInt("Key2",0);
        String price = sharePref.getString("Key1", "");

        Double setPrice = Double.parseDouble(price);

        result_price = (mile * price_per_mile) + setPrice;
        DecimalFormat currency = new DecimalFormat("$###,###.##");
        txtResult.setText("Total Payment: " + currency.format(result_price));

        if(price.equals("19.95")) {
            image.setImageResource(R.drawable.truck1);
        } else if(price.equals("29.95")) {
            image.setImageResource(R.drawable.truck2);
        } else if (price.equals("39.95")) {
            image.setImageResource(R.drawable.truck3);
        } else {
            image.setImageResource(R.drawable.movingtruck);
        }
    }
}