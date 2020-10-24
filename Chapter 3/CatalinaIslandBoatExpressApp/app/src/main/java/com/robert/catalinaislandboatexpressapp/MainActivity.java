package com.robert.catalinaislandboatexpressapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String groupChoice;
    int Price =34;
    int Input;
    int TotalPrice;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Spinner group = (Spinner) findViewById(R.id.txtGroup);
        final Button calculate = (Button) findViewById(R.id.btn);
        final EditText numOfTicket = (EditText) findViewById(R.id.txtInput);
        final TextView result = (TextView) findViewById(R.id.txtResult);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                groupChoice = group.getSelectedItem().toString();
                Input = Integer.parseInt(numOfTicket.getText().toString());
                TotalPrice = Input* Price;

                result.setText("One Wya Trip To " + groupChoice + "- $" +TotalPrice);



            }
        });

    }
}