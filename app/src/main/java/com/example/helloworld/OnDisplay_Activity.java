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

public class OnDisplay_Activity extends AppCompatActivity {

    private RecyclerView pop_films;
    private List<Movie> pop_movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.on_display);

        getSupportActionBar().setTitle("On Display");

        pop_films = findViewById(R.id.pop_film);
        pop_films.setHasFixedSize(true);
        pop_films.setLayoutManager(new GridLayoutManager(this, 4));

        TMDbApiInterface tmdbApi = TMDbApiClient.getClient();
        Call<MovieResponse> call = tmdbApi.getNewMovies(TMDbApiClient.getApiKey());

        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                if (response.isSuccessful()) {
                    MovieResponse movieResponse = response.body();
                    pop_movies = movieResponse.getResults();
                    MovieAdapter adapter = new MovieAdapter(OnDisplay_Activity.this, pop_movies);
                    pop_films.setAdapter(adapter);
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