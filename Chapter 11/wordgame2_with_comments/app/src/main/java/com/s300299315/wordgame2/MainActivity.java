package com.s300299315.wordgame2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    //36) set this variable
    public static final int NEW_WORD_ACTIVITY_REQUEST_CODE = 1;

    //26) set the variable
    private DBOpenHelper mDb;
    WordListAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //27) ready to connect database with create object(mDb)
        mDb = new DBOpenHelper(this);

        //28) Create RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recyclerview);

        //29) Create Adapter and pass database (the second parameter object is to define how to compare the list)
        adapter = new WordListAdapter(mDb, new WordListAdapter.WordDiff());

        //30) Set up the list
        recyclerView.setAdapter(adapter);
        //31) set the recyclerView with LinearLayout with setLayoutManager
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //37) set the Plus button on the corner
        FloatingActionButton plus = findViewById(R.id.fab);

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NewWordActivity.class);
                //38) set the second activity reply the result and get back in first activity
                startActivityForResult(intent, NEW_WORD_ACTIVITY_REQUEST_CODE);
            }
        });

    }

    //39) Create Callback method using a ctrl+o to get the onActivityResult
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == NEW_WORD_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK){
            //40) Create a Word
            Word word = new Word(data.getStringExtra(NewWordActivity.EXTRA_REPLY));
            mDb.insert(word);
            //41) set the adpater know the change with input new data
            adapter.notifyDataSetChanged();
        } else {
            Toast.makeText(
                    getApplicationContext(),
                    R.string.empty_not_saved,
                    Toast.LENGTH_LONG).show();
        }
    }
}