package com.robert.yourpersonalplaylistapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button button1, button2, button3;
    MediaPlayer mp1, mp2, mp3;
    int playing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Set the button
        button1 = (Button) findViewById(R.id.singer1btn1);
        button2 = (Button) findViewById(R.id.singer2btn2);
        button3 = (Button) findViewById(R.id.singer3btn3);

        button1.setOnClickListener(bMusic1);
        button2.setOnClickListener(bMusic2);
        button3.setOnClickListener(bMusic3);

        // Media Player

        mp1 = MediaPlayer.create(this, R.raw.music1);
        mp2 = MediaPlayer.create(this, R.raw.music2);
        mp3 = MediaPlayer.create(this, R.raw.music3);
    }

    View.OnClickListener bMusic1 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (playing) {
                case 0:
                    if(mp2.isPlaying() && mp3.isPlaying()) {
                        mp2.pause();
                        mp3.pause();
                    }
                    mp1.start();
                    playing =1;
                    button1.setText("Pause Music 1");
                    button2.setVisibility(View.INVISIBLE);
                    button3.setVisibility(View.INVISIBLE);
                    break;
                case 1:
                    mp1.pause();
                    playing =0;
                    button1.setText("Play Music 1");
                    button2.setVisibility(View.VISIBLE);
                    button3.setVisibility(View.VISIBLE);
                    break;
            }
        }
    };

    View.OnClickListener bMusic2 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            switch (playing) {
                case 0:
                    if(mp1.isPlaying() && mp3.isPlaying()) {
                        mp1.pause();
                        mp3.pause();
                    }
                    mp2.start();
                    playing =1;
                    button2.setText("Pause Music 2");
                    button1.setVisibility(View.INVISIBLE);
                    button3.setVisibility(View.INVISIBLE);
                    break;
                case 1:
                    mp2.pause();
                    playing =0;
                    button2.setText("Play Music 2");
                    button1.setVisibility(View.VISIBLE);
                    button3.setVisibility(View.VISIBLE);
                    break;
            }
        }
    };

    View.OnClickListener bMusic3 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (playing) {
                case 0:
                    if(mp1.isPlaying() && mp2.isPlaying()) {
                        mp1.pause();
                        mp2.pause();
                    }
                    mp3.start();
                    playing =1;
                    button3.setText("Pause Music 3");
                    button1.setVisibility(View.INVISIBLE);
                    button2.setVisibility(View.INVISIBLE);
                    break;
                case 1:
                    mp3.pause();
                    playing =0;
                    button3.setText("Play Music 3");
                    button1.setVisibility(View.VISIBLE);
                    button2.setVisibility(View.VISIBLE);
                    break;
            }
        }
    };
}