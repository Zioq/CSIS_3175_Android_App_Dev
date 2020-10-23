package com.robert.currencyconversionapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    double euro = 0.844260;
    double pesos = 20.8919;
    double cad = 1.31136;
    double inputUSD;
    double conversionResult;
    String groupChoice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText us = (EditText) findViewById(R.id.txtInput);
        final Spinner group  = (Spinner) findViewById(R.id.txtGroup);
        final TextView result = (TextView) findViewById(R.id.txtResult);

        Button conversion = (Button) findViewById(R.id.btnConversion);

        conversion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputUSD = Double.parseDouble(us.getText().toString());
                groupChoice = group.getSelectedItem().toString();
                DecimalFormat tenth = new DecimalFormat("#.##");
                if(inputUSD>100000){
                    Toast.makeText(MainActivity.this, "Please Enter under 100000",Toast.LENGTH_LONG).show();
                    result.setText(groupChoice);
                } else {
                    if (groupChoice.equals("Euros")) {

                        conversionResult = inputUSD *euro ;
                        result.setText("The Conversion Euro is : " +tenth.format(conversionResult));
                    }

                    if (groupChoice.equals("Mexican pesos")) {
                        conversionResult = inputUSD *pesos ;
                        result.setText("The Conversion Mexican pesos is : " +tenth.format(conversionResult));
                    }
                    if (groupChoice.equals("Canadian dollars")) {
                        conversionResult = inputUSD *cad ;
                        result.setText("The Conversion Canadian dollars is : " +tenth.format(conversionResult));
                    }


                }
            }
        });
    }
}