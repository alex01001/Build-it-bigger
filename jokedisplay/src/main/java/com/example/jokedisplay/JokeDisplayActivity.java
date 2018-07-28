package com.example.jokedisplay;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class JokeDisplayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_display);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        String joke;

        if (bundle != null) {
            joke = bundle.getString("joke");

            if (joke == null) {
                joke = "No jokes available!";
            }
        } else {
            joke = "No jokes available!";
        }

        TextView jokeDisplayTextView = (TextView)findViewById(R.id.tv_joke);
        jokeDisplayTextView.setText(joke);
    }
}