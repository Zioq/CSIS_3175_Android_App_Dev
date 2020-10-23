package com.robert.carwashapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    double costExtraOnly;
    double costExtraWith;
    int numOfWash;
    double price;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText input = (EditText) findViewById(R.id.editTextNumber);
        final RadioButton extraOnly = (RadioButton) findViewById(R.id.rdbtn1);
        final RadioButton extraWith = (RadioButton)findViewById(R.id.rdbtn2);

        final TextView result = (TextView) findViewById(R.id.txtResult);

        final Button calculate = (Button) findViewById(R.id.btnCalculate);


        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numOfWash = Integer.parseInt(input.getText().toString());
                DecimalFormat tenth = new DecimalFormat("#.##");

                if(extraOnly.isChecked()) {
                    if(numOfWash >12) {
                        costExtraOnly = 8.99;
                        price = costExtraOnly * numOfWash;
                        result.setText( "$"+tenth.format(price)+ " for " + numOfWash+ " Washes");

                    } else {
                        costExtraOnly = 10.99;
                        price = costExtraOnly * numOfWash;
                        result.setText( "$"+tenth.format(price)+ " for " + numOfWash+ " Washes");
                        Toast.makeText(MainActivity.this,"Buy more than 12 and get the discount!",Toast.LENGTH_LONG).show();
                    }
                }
                if(extraWith.isChecked()) {
                    if(numOfWash > 12 ) {
                        costExtraWith = 12.99;
                        price = costExtraWith * numOfWash;
                        result.setText( "$"+tenth.format(price)+ " for " + numOfWash+ " Washes");
                    } else {
                        costExtraWith = 15.99;
                        price = costExtraWith * numOfWash;
                        result.setText( "$"+tenth.format(price)+ " for " + numOfWash+ " Washes");
                        Toast.makeText(MainActivity.this,"Buy more than 12 and get the discount!",Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}