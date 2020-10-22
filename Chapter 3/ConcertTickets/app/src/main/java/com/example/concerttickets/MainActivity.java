package com.example.concerttickets;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    double constPerTicket = 79.99;
    int numberOfTicket;
    double totalCost;
    String groupChoice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText ticket = (EditText) findViewById(R.id.txtTickets);
        final Spinner group = (Spinner) findViewById(R.id.txtGroup);
        final TextView result = (TextView) findViewById(R.id.txtResult);
        Button cost = (Button) findViewById(R.id.btnCost);


        cost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberOfTicket = Integer.parseInt(ticket.getText().toString());
                groupChoice = group.getSelectedItem().toString();
                totalCost = constPerTicket * numberOfTicket;

                DecimalFormat currency = new DecimalFormat("$###,###.##");
                result.setText("Cost for  " + groupChoice + " is " +currency.format(totalCost));
            }
        });

    }
}