package com.example.paintcalculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    double totalFeet ;
    double heightFeet ;
    double distanceFeet ;
    double gallons;
    String color;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final EditText height = (EditText)findViewById(R.id.txtHeight);
        final EditText distance = (EditText)findViewById(R.id.txtDistance);
        final Spinner colors  = (Spinner)findViewById(R.id.spnColors);

        Button btnCompute = (Button)findViewById(R.id.btnCompute);
        final TextView result = ((TextView)findViewById(R.id.txtResult));

        btnCompute.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                heightFeet = Double.parseDouble(height.getText().toString());
                distanceFeet = Double.parseDouble(distance.getText().toString());
                totalFeet = heightFeet + distanceFeet;
                gallons = totalFeet/250;
                DecimalFormat gallon = new DecimalFormat("##.##");
                color = colors.getSelectedItem().toString();
                result.setText(String.format("The Color you Choose: " + color + " and Gallon: " +gallon.format(gallons)));
            }
        });

    }
}