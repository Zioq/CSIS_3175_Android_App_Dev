package com.robert.alohamusic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //create timer task
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                finish(); // shutdown first activity
                startActivity(new Intent(SplashActivity.this, MainActivity.class)); // then start second activity
            }
        };

        // create Timer object
        Timer opening = new Timer ();
        opening.schedule(task, 3000); // after 3 second, opening TimerTask called 'task'
    }
}