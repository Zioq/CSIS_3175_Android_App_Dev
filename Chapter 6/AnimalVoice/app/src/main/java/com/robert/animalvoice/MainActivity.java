package com.robert.animalvoice;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button button1,button2;
    MediaPlayer mpCow,mpPig;
    int playing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        button1 = (Button) findViewById(R.id.btn_cow);
        button2 = (Button) findViewById(R.id.btn_pig);

        button1.setOnClickListener(bCow);
        button2.setOnClickListener(bPig);

        playing = 0;

        mpCow =  MediaPlayer.create(this,R.raw.cows);
        mpPig = MediaPlayer.create(this,R.raw.pigs);
    }

    View.OnClickListener bCow = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (playing) {
                case 0:
                    if(mpPig.isPlaying()){
                        mpPig.pause();
                    }
                    mpCow.start();
                    playing = 1;
                    button1.setText("Pause Cow Sound");
                    button2.setVisibility(View.INVISIBLE);
                    break;
                case 1:
                    mpCow.pause();
                    playing =0;
                    button1.setText("Play Cow Sound");
                    button2.setVisibility(View.VISIBLE);
                    break;
            }
        }
    };

    View.OnClickListener bPig = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (playing) {
                case 0:
                    if(mpCow.isPlaying()){
                        mpCow.pause();
                    }
                    mpPig.start();
                    playing = 1;
                    button2.setText("Pause Cow Sound");
                    button1.setVisibility(View.INVISIBLE);
                    break;
                case 1:
                    mpPig.pause();
                    playing =0;
                    button2.setText("Play Cow Sound");
                    button1.setVisibility(View.VISIBLE);
                    break;
            }
        }
    };

}