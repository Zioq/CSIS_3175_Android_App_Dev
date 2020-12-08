package com.s300299315.homemortgageinterestapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;

public class InterestAcivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interest_acivity);

        TextView interestPayment = (TextView) findViewById(R.id.txtResult);
        ImageView img = (ImageView) findViewById(R.id.imgResult);
        SharedPreferences sharePref  = PreferenceManager.getDefaultSharedPreferences(this);

        float payment = sharePref.getFloat("Key1",0);
        int year = sharePref.getInt("Key2",0);
        float initial = sharePref.getFloat("Key3",0);

        float result = (payment * year * 12) - initial;
        DecimalFormat currency = new DecimalFormat("###,###.##");

        interestPayment.setText("Monthly Interest: " + currency.format(result));

        if(year==10) {
            img.setImageResource(R.drawable.ten);
        } else if(year==20) {
            img.setImageResource(R.drawable.twenty);
        } else if(year==30) {
            img.setImageResource(R.drawable.thirty);
        } else {
            img.setImageResource(R.drawable.mortgage);
        }


    }
}