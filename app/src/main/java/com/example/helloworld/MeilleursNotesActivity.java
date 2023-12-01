package com.example.helloworld;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import Adapter.Movie;
import Adapter.MovieAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tmdb_api.MovieResponse;
import tmdb_api.TMDbApiClient;
import tmdb_api.TMDbApiInterface;



public class MeilleursNotesActivity extends AppCompatActivity {
    private RecyclerView best_films;
    private List<Movie> best_movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        best_films = findViewById(R.id.best_film);
        best_films.setHasFixedSize(true);
        best_films.setLayoutManager(new GridLayoutManager(this, 4));

        getSupportActionBar().setTitle("Mieux notés");

        TMDbApiInterface tmdbApi = TMDbApiClient.getClient();
        Call<MovieResponse> call = tmdbApi.getBestMovies(TMDbApiClient.getApiKey());

        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                if (response.isSuccessful()) {
                    MovieResponse movieResponse = response.body();
                    best_movies = movieResponse.getResults();
                    MovieAdapter adapter = new MovieAdapter(MeilleursNotesActivity.this , best_movies);
                    best_films.setAdapter(adapter);
                } else {
                    Log.e("Error", "Response not successful");
                }
            }


            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                Log.e("Error", "Network error: " + t.getMessage());
            }
        });
    }
}