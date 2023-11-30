package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import java.util.List;

import Adapter.Movie;
import Adapter.MovieAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tmdb_api.*;


public class MainActivity extends AppCompatActivity {

    private ImageButton btn;
    private ImageButton btnAccount;
    private List<Movie> pop_movies;
    private List<Movie> new_movies;
    private RecyclerView new_films;
    private RecyclerView pop_films;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        btn = findViewById(R.id.btnMenu) ;
        btnAccount = findViewById(R.id.btnAccount);

        new_films = findViewById(R.id.new_film);
        new_films.setHasFixedSize(true);
        new_films.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        pop_films = findViewById(R.id.pop_film);
        pop_films.setHasFixedSize(true);
        pop_films.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));


    //Appel API pour les films popuplaires
        TMDbApiInterface tmdbApi = TMDbApiClient.getClient();
        Call<MovieResponse> call = tmdbApi.getPopularMovies(TMDbApiClient.getApiKey());
        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                if (response.isSuccessful()) {
                    MovieResponse movieResponse = response.body();
                    pop_movies = movieResponse.getResults();
                    MovieAdapter adapter = new MovieAdapter(MainActivity.this , pop_movies);
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

        //Appel API pour les films nouveaux
        call = tmdbApi.getNewMovies(TMDbApiClient.getApiKey());
        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                if (response.isSuccessful()) {
                    MovieResponse movieResponse = response.body();
                    new_movies = movieResponse.getResults();
                    MovieAdapter adapter = new MovieAdapter(MainActivity.this , new_movies);
                    new_films.setAdapter(adapter);
                } else {
                    Log.e("Error", "Response not successful");
                }
            }


            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                Log.e("Error", "Network error: " + t.getMessage());
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, BoutonMenuActivity.class));
            }
        });

        btnAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent( MainActivity.this, MeConnecter.class));
            }
        });
    }



}