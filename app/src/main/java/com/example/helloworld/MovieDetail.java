package com.example.helloworld;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import Adapter.Movie;

public class MovieDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_detail);
        getSupportActionBar().hide();

        Movie movie = getIntent().getParcelableExtra("movie");

        TextView title = findViewById(R.id.movie_title);
        title.setText(movie.getTitle());

        TextView date = findViewById(R.id.movie_release_date);
        date.setText(movie.getReleaseDate());

        TextView txt = findViewById(R.id.summary);
        txt.setText(movie.getResume());

        TextView rating = findViewById(R.id.movie_rating);
        rating.setText(movie.getRating());

        ImageView poster = findViewById(R.id.movie_img);
        Glide.with(getApplicationContext()).load(movie.getImgPATH()).into(poster);
    }

    
}
