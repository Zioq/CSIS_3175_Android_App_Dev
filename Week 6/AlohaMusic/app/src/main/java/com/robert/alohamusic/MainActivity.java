package com.robert.alohamusic;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button button1, button2;
    MediaPlayer mpUkulele, mpDrums;
    int playing; // play the music 1/0 => T/F

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Setting the button by id name
        button1 = (Button) findViewById(R.id.btnUkulele);
        button2 = (Button) findViewById(R.id.btnDrums);


        //onclick Listener for the another tasks (Different way what we did for a while)
        button1.setOnClickListener(bUkulele);
        button2.setOnClickListener(bDrums);

        // Set the 0 for no music at first
        playing =0;

        // Create Media players
        mpUkulele = MediaPlayer.create(this, R.raw.ukulele);
        mpDrums = MediaPlayer.create(this,R.raw.drums);

        //start(); pause(); stop();
    }
    //Event Handler
    View.OnClickListener bUkulele = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (playing) {
                case 0:
                    if(mpDrums.isPlaying()) {
                        mpDrums.pause();
                    }
                    mpUkulele.start();
                    playing =1 ;
                    button1.setText("Pause Ukulele Song");
                    button2.setVisibility(View.INVISIBLE);
                    break;
                case 1:
                    mpUkulele.pause();
                    playing =0;
                    button1.setText("Play Ukulele Song");
                    button2.setVisibility(View.VISIBLE);
                    break;
            }
        }
    };

    View.OnClickListener bDrums = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (playing) {
                case 0:
                    if(mpUkulele.isPlaying()) {
                        mpUkulele.pause();
                    }
                    mpDrums.start();
                    playing =1 ;
                    button2.setText("Pause Drums Song");
                    button1.setVisibility(View.INVISIBLE);
                    break;
                case 1:
                    mpDrums.pause();
                    playing =0;
                    button2.setText("Pause Drums Song");
                    button1.setVisibility(View.VISIBLE);
                    break;
            }
        }
    };
}