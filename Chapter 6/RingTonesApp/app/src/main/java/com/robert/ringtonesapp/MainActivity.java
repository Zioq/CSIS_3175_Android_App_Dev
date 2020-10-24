package com.robert.ringtonesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    //Button button1, button2;
    MediaPlayer mp1, mp2, mp3;
    int playing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //button1 = (Button) findViewById(R.id.btnPlay);
        //button2 = (Button) findViewById(R.id.btnStop);

        //button1.setOnClickListener(Play);
        //button2.setOnClickListener(Stop);

        playing = 0;

        // Media Plyer
        mp1 = MediaPlayer.create(this, R.raw.music1);
        mp2 = MediaPlayer.create(this, R.raw.music2);
        mp3 = MediaPlayer.create(this, R.raw.music3);

        final RadioButton music1 = (RadioButton) findViewById(R.id.rdMusic1);
        final RadioButton music2 = (RadioButton) findViewById(R.id.rdMusic2);
        final RadioButton music3 = (RadioButton) findViewById(R.id.rdMusic3);

        final TextView title = (TextView) findViewById(R.id.txtTitle);
        final TextView description = (TextView) findViewById(R.id.txtMusicDesc);

        final Button play = (Button) findViewById(R.id.btnPlay);
        final Button stop = (Button) findViewById(R.id.btnStop);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(music1.isChecked()) {
                    if(mp2.isPlaying() && mp3.isPlaying()) {
                        mp2.pause();
                        mp3.pause();
                    }
                    mp1.start();
                    play.setVisibility(View.INVISIBLE);
                    title.setText("Title: Music 1");
                    description.setText("This is Music1 by Artist 1");

                } else if(music2.isChecked()) {
                    if(mp1.isPlaying() && mp3.isPlaying()) {
                        mp1.pause();
                        mp3.pause();
                    }
                    mp2.start();
                    play.setVisibility(View.INVISIBLE);
                    title.setText("Title: Music 2");
                    description.setText("This is Music1 by Artist 2");
                } else if(music3.isChecked()) {
                    if(mp1.isPlaying() && mp2.isPlaying()) {
                        mp1.pause();
                        mp2.pause();
                    }
                    mp3.start();
                    play.setVisibility(View.INVISIBLE);
                    title.setText("Title: Music 3");
                    description.setText("This is Music1 by Artist 3");
                }
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(music1.isChecked()) {
                    mp1.stop();
                    play.setVisibility(View.VISIBLE);
                    title.setText("");
                    description.setText("");
                } else if (music2.isChecked()) {
                    mp2.stop();
                    play.setVisibility(View.VISIBLE);
                    title.setText("");
                    description.setText("");
                } else if (music3.isChecked()) {
                    mp3.stop();
                    play.setVisibility(View.VISIBLE);
                    title.setText("");
                    description.setText("");
                }
            }
        });

    }
}

