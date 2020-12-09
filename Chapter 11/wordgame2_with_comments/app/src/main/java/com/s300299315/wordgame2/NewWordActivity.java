package com.s300299315.wordgame2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewWordActivity extends AppCompatActivity {

    //34) set the variables
    public static final String EXTRA_REPLY = "com.example.wordgame2.REPLY";
    private EditText inputWord;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_word);

        //35) process the input text data
        inputWord = (EditText) findViewById(R.id.edit_word);
        final Button button = findViewById(R.id.button_save);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent replyIntent = new Intent();

                if(TextUtils.isEmpty(inputWord.getText())) {
                    setResult(RESULT_CANCELED,replyIntent); // back to the first activity
                } else {
                    String word = inputWord.getText().toString(); // get the string what input by user
                    replyIntent.putExtra(EXTRA_REPLY,word); // save the `word` with the key `EXTRA_REPLY`
                    setResult(RESULT_OK, replyIntent); // send the result with `RESULT_OK` to the first activity
                }
                finish();
            }
        });
    }
}