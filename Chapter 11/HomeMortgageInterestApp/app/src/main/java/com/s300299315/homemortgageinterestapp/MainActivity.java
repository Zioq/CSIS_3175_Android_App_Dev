package com.s300299315.homemortgageinterestapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    float payment;
    int year;
    float init;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText inputPayment = (EditText) findViewById(R.id.inputPayment);
        final EditText inputYear = (EditText) findViewById(R.id.inputYear);
        final EditText inputInitial = (EditText) findViewById(R.id.inputInitial);
        Button button = (Button) findViewById(R.id.btnCalculate);
        final SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                year = Integer.parseInt(inputYear.getText().toString());
                payment = Float.parseFloat(inputPayment.getText().toString());
                init = Float.parseFloat(inputInitial.getText().toString());

                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putFloat("Key1",payment);
                editor.putInt("Key2",year);
                editor.putFloat("Key3",init);
                editor.commit();

                startActivity(new Intent(MainActivity.this, InterestAcivity.class));


            }
        });




    }
}