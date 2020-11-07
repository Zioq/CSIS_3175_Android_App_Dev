package com.s300299315.newsevenwondersoftheworld;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements  ImageAdapter.ItemClickListener{

    Integer[] wonders =  {
            R.drawable.wonder1,
            R.drawable.wonder2,
            R.drawable.wonder3,
            R.drawable.wonder4,
            R.drawable.wonder5,
            R.drawable.wonder6,
            R.drawable.wonder7,
    };

    ImageView pic;
    ImageAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        pic = (ImageView) findViewById(R.id.imgLarge);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        int numberOfColumns = 4;
        recyclerView.setLayoutManager(new GridLayoutManager(this, numberOfColumns));
        adapter = new ImageAdapter(this, wonders);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(getBaseContext(), "Monument: #"+ (position +1), Toast.LENGTH_LONG).show();

        pic.setImageResource(adapter.getItem(position));
    }
}