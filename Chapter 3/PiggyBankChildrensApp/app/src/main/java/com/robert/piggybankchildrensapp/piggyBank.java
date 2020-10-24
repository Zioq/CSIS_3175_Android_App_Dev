package com.robert.piggybankchildrensapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.Format;

public class piggyBank extends AppCompatActivity {

    double quarter = 0.25;
    double dime = 0.10;
    double nickel = 0.05;
    double penny = 0.01;
    String groupChoice;

    double InputQuarters;
    double InputDimes;
    double InputNickels;
    double InputPennies;
    double total;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_piggy_bank);

        final EditText inputQuarter = (EditText) findViewById(R.id.txtQuarterInput);
        final EditText inputDime = (EditText)findViewById(R.id.txtDimeInput);
        final EditText inputNickel = (EditText)findViewById(R.id.txtNickelInput);
        final EditText inputPenny = (EditText) findViewById(R.id.txtPenniesInput);

        final TextView result = (TextView) findViewById(R.id.txtResult);

        final Spinner group = (Spinner) findViewById(R.id.txtGroup);

        Button calculate = (Button) findViewById(R.id.btnCalculate);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                InputQuarters = Double.parseDouble(inputQuarter.getText().toString());
                InputDimes = Double.parseDouble(inputDime.getText().toString());
                InputNickels = Double.parseDouble(inputNickel.getText().toString());
                InputPennies = Double.parseDouble(inputPenny.getText().toString());

                total = (InputQuarters*quarter) + (InputDimes * dime) + (InputNickels * nickel) + (InputPennies * penny);

                DecimalFormat currency = new DecimalFormat("#.###");

                groupChoice = group.getSelectedItem().toString();

                result.setText("Total Value is " + currency.format(total) + "and you choose to "+groupChoice);

            }
        });

    }
}