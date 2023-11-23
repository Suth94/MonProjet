package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MovieDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_detail);

        Intent intent = getIntent();
        int movie_i = intent.getIntExtra("movie_id",1);

        TextView txt = findViewById(R.id.summary);
        txt.setText(""+movie_i);
    }

}