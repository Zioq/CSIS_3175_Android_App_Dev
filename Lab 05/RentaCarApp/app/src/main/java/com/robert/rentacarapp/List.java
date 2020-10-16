package com.robert.rentacarapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class List extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_list);

        String [] company = {"Vancity Car Rentals", "Alamo Rent A Car", "Access Rent A Car", "Enterprise Rent-A-Car", "Expo Rent A Car", "Avis Car Rental"};

        setListAdapter(new ArrayAdapter<String>(this,
                R.layout.activity_list,
                R.id.company,
                company));

    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        switch(position) {
            case 0:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.vancitycars.com/?gclid=CjwKCAjwiaX8BRBZEiwAQQxGx87WBVMmv3JNFS3J_DaxQECkGgT1urg_nvdx1-zMCQLY7qo0PLzjIRoCfnUQAvD_BwE")));
                break;
            case 1:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.alamo.ca/en_US/car-rental/home.html?gclid=CjwKCAjwiaX8BRBZEiwAQQxGxzHARlwZ12Gttrf7BOHlXtqtolegdVr4myX3jB833wb0XenhUMIRmxoCmL4QAvD_BwE&mcid=paidsearch:144669&ef_id=CjwKCAjwiaX8BRBZEiwAQQxGxzHARlwZ12Gttrf7BOHlXtqtolegdVr4myX3jB833wb0XenhUMIRmxoCmL4QAvD_BwE:G:s&s_kwcid=AL!4824!3!462901929825!e!!g!!rental%20car&campaignid=886208082&gclsrc=aw.ds")));
                break;
            case 2:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.accessrac.com/")));
                break;
            case 3:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.enterprise.ca/fr/location-voiture/emplacements/canada/bc/vancouver-centre-ville-granville-st-c411.html?mcid=yext:245709")));
                break;
            case 4:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://exporentacar.com/")));
                break;
            case 5:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.avis.ca/en/locations/ca/bc/vancouver/s73")));
                break;
        }
    }


}