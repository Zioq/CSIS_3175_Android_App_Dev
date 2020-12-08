package com.s300299315.relocationmovingtruckrentalapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import javax.xml.transform.Result;

public class MainActivity extends AppCompatActivity {

    int mile;
    String truck1_price =  "19.95";
    String truck2_price = "29.95";
    String truck3_price = "39.95";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText inputMile = (EditText) findViewById(R.id.InputMile);
        final RadioButton truck1 = (RadioButton) findViewById(R.id.truck1);
        final RadioButton truck2 = (RadioButton) findViewById(R.id.truck2);
        final RadioButton truck3 = (RadioButton) findViewById(R.id.truck3);
        final SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);

        Button button = (Button) findViewById(R.id.btnCalculate);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mile = Integer.parseInt(inputMile.getText().toString());
                SharedPreferences.Editor editor = sharedPref.edit();

                if(truck1.isChecked()) {
                    editor.putString("Key1",truck1_price);
                    editor.putInt("Key2",mile);
                    editor.commit();
                    startActivity(new Intent(MainActivity.this, ResultActivity.class));
                } else if(truck2.isChecked()) {
                    editor.putString("Key1",truck2_price);
                    editor.putInt("Key2",mile);
                    editor.commit();
                    startActivity(new Intent(MainActivity.this, ResultActivity.class));
                } else if(truck3.isChecked()) {
                    editor.putString("Key1",truck3_price);
                    editor.putInt("Key2",mile);
                    editor.commit();
                    startActivity(new Intent(MainActivity.this, ResultActivity.class));
                }
            }
        });
    }
}