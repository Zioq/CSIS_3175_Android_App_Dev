package com.s300299315.electroniccarfinancing;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;

public class PaymentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        TextView monthlyPayment = (TextView) findViewById(R.id.txtMonthlyPayment);
        ImageView image = (ImageView) findViewById(R.id.imgYears);
        SharedPreferences sharePref = PreferenceManager.getDefaultSharedPreferences(this);
        int intYears = sharePref.getInt("Key1",0);
        int intLoan = sharePref.getInt ("Key2",0);
        float decInterest = sharePref.getFloat("Key3", 0);

        float decMonthlyPayment = (intLoan * (1 * (decInterest* intYears))) / (12 * intYears);
        DecimalFormat currency = new DecimalFormat("$###,###.##");
        monthlyPayment.setText ("Monthly Payment: " + currency.format(decMonthlyPayment));

        if(intYears ==3) {
            image.setImageResource(R.drawable.three);
        } else if(intYears ==4) {
            image.setImageResource(R.drawable.four);
        } else if(intYears ==5) {
            image.setImageResource(R.drawable.five);
        } else {
            monthlyPayment.setText("Enter 3, 4, or 5 in Year");
        }

    }
}