package com.robert.techgadgetsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeAudio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_audio);

        Button button = (Button) findViewById(R.id.btn_homeaudio);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openURL = new Intent(Intent.ACTION_VIEW);
                openURL.setData(Uri.parse("https://www.bestbuy.ca/en-ca/collection/home-audio-clearout/323111?icmp=HEB_20201016_Clearout_Sale_SBC_HA"));
                startActivity(openURL);
            }
        });
    }
}