package com.s300299315.improveyourgolfstrokeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    AnimationDrawable golfAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView imgFrame = (ImageView) findViewById(R.id.imgGolf);
        imgFrame.setBackgroundResource(R.drawable.animtaion);
        golfAnimation = (AnimationDrawable) imgFrame.getBackground();

        Button btn1  = (Button)findViewById(R.id.btnStart);
        Button btn2  = (Button)findViewById(R.id.btnStop);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                golfAnimation.start();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                golfAnimation.stop();
                startActivity(new Intent(MainActivity.this, TweenActivity.class));
            }
        });

    }
}