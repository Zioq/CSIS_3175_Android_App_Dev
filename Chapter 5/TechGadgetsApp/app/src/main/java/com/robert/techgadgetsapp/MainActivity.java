package com.robert.techgadgetsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String [] electronics = {"Laptop", "Monitors", "Television", "Home Audio", "Headphone"};

        setListAdapter(new ArrayAdapter<String>(this,
                R.layout.activity_main,
                R.id.electronics,
                electronics));


    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        switch (position) {
            case 0:
                startActivity(new Intent(MainActivity.this, Laptop.class));
                break;
            case 1:
                startActivity(new Intent(MainActivity.this, Monitors.class));
                break;
            case 2:
                startActivity(new Intent(MainActivity.this, Television.class));
                break;
            case 3:
                startActivity(new Intent(MainActivity.this, HomeAudio.class));
                break;
            case 4:
                startActivity(new Intent(MainActivity.this, Headphone.class));
                break;

        }
    }
}