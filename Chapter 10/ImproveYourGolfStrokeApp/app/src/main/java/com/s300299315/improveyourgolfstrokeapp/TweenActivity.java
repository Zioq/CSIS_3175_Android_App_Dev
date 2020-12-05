package com.s300299315.improveyourgolfstrokeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class TweenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tween);
        ImageView ImgRotate = (ImageView) findViewById(R.id.imgTwin);
        ImgRotate.startAnimation(AnimationUtils.loadAnimation(this, R.anim.rotation));
    }
}