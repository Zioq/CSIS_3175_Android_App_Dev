package com.robert.phonephotoprintsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    int printEntered;
    double calcualte_price;
    double price_4_6_print = 0.19;
    double price_5_7_print = 0.49;
    double price_8_10_print = 0.79;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText numPrint = (EditText) findViewById(R.id.txtPrints);
        final TextView result = (TextView) findViewById(R.id.txtResult);

        // Radio btn
        final RadioButton rad19 =  (RadioButton) findViewById(R.id.rad19);
        final RadioButton rad49 =  (RadioButton) findViewById(R.id.rad49);
        final RadioButton rad79 =  (RadioButton) findViewById(R.id.rad79);

        //Submit Button
        final Button order = (Button) findViewById(R.id.btnOrder);

        //Button click listener
        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                printEntered = Integer.parseInt((numPrint.getText().toString()));
                DecimalFormat tenth = new DecimalFormat("#.##");
                // When rad19 is clicked
                if(rad19.isChecked()) {
                    if(printEntered<=50) {
                        calcualte_price = printEntered * price_4_6_print ;
                        result.setText(("The order cost is: "+tenth.format(calcualte_price)));
                    } else {
                        Toast.makeText(MainActivity.this,"The maximum number of print you can buy is less than 51",
                                Toast.LENGTH_LONG).show();
                    }
                }

                // When rad49 is clicked
                if(rad49.isChecked()) {
                    if(printEntered<=50) {
                        calcualte_price = printEntered * price_5_7_print ;
                        result.setText(("The order cost is: "+tenth.format(calcualte_price)));
                    } else {
                        Toast.makeText(MainActivity.this,"The maximum number of print you can buy is less than 51",
                                Toast.LENGTH_LONG).show();
                    }
                }

                // When rad79 is clicked
                if(rad79.isChecked()) {
                    if(printEntered<=50) {
                        calcualte_price = printEntered * price_8_10_print ;
                        result.setText(("The order cost is: "+tenth.format(calcualte_price)));
                    } else {
                        Toast.makeText(MainActivity.this,"The maximum number of print you can buy is less than 51",
                                Toast.LENGTH_LONG).show();
                    }
                }

            }
        });
    }
}