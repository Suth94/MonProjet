package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import tmdb_api.Movie;

public class MovieDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_detail);
        getSupportActionBar().hide();

        Movie movie = getIntent().getParcelableExtra("movie");

        TextView txt = findViewById(R.id.summary);
        txt.setText(movie.getResume());

        TextView title = findViewById(R.id.movie_title);
        title.setText(movie.getTitle());

        ImageView poster = findViewById(R.id.movie_img);
        Glide.with(getApplicationContext()).load(movie.getImgPATH()).into(poster);
    }

}
