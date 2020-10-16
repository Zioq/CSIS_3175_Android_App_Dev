package com.robert.medicalcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    double coversionRate = 2.2;
    double weightEntered;
    double covertedWeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText weight = (EditText) findViewById(R.id.txtWeight);
        final RadioButton lbToKilo = (RadioButton) findViewById(R.id.radLbToKilo);
        final RadioButton kiloToLb = (RadioButton) findViewById(R.id.radKiloToLb);
        final TextView result = (TextView) findViewById(R.id.txtResult);

        final Button convert = (Button) findViewById(R.id.btnConvert);

        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                weightEntered = Double.parseDouble(weight.getText().toString());
                DecimalFormat tenth = new DecimalFormat("#.#");
                if(kiloToLb.isChecked()) {
                    if(weightEntered<=500) {
                        covertedWeight = weightEntered / coversionRate;
                        result.setText(tenth.format(covertedWeight)+ "kilograms");
                    } else {
                        Toast.makeText(MainActivity.this,"Pound must be less then 500",Toast.LENGTH_LONG).show();
                    }
                }
                if(kiloToLb.isChecked()) {
                    if(weightEntered<=225) {
                        covertedWeight = weightEntered * coversionRate;
                        result.setText(tenth.format(covertedWeight)+ "kilograms");

                    } else {
                        Toast.makeText(MainActivity.this,"Kilogram must be less then 225",Toast.LENGTH_LONG).show();
                    }
                }

            }
        }

        );
    }
}