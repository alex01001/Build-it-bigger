package com.example.jokedisplay;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class JokeDisplayActivity extends AppCompatActivity {

    public static String JOKE_KEY = "joke";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_display);

        Intent intent = getIntent();
        String joke = "No jokes available!";

        if(intent.hasExtra(JOKE_KEY)) {
            Bundle bundle = intent.getExtras();
            if (bundle != null) {
                joke = bundle.getString(JOKE_KEY);

                if (joke == null) {
                    joke = "No jokes available!";
                }
            } else {
                joke = "No jokes available!";
            }
        }
        TextView jokeDisplayTextView = (TextView)findViewById(R.id.tv_joke);
        jokeDisplayTextView.setText(joke);
    }
}