package com.example.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.SearchView;

import java.util.List;

import Adapter.Movie;
import Adapter.MovieAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tmdb_api.MovieResponse;
import tmdb_api.TMDbApiClient;
import tmdb_api.TMDbApiInterface;

public class Research extends AppCompatActivity {

    private RecyclerView src_films;
    private List<Movie> src_movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.research);
        getSupportActionBar().hide();

        String search = getIntent().getStringExtra("search");
        TextView text = findViewById(R.id.research);
        SearchView srch = findViewById(R.id.searchView);
        text.setText(search);
        srch.setQueryHint(search);

        RecyclerView films = findViewById(R.id.search_film);
        films.setHasFixedSize(true);
        films.setLayoutManager(new GridLayoutManager(this, 4));

        TMDbApiInterface tmdbApi = TMDbApiClient.getClient();
        Call<MovieResponse> call = tmdbApi.searchMovies(TMDbApiClient.getApiKey(),search);

        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                if (response.isSuccessful()) {
                    MovieResponse movieResponse = response.body();
                    src_movies = movieResponse.getResults();
                    MovieAdapter adapter = new MovieAdapter(Research.this , src_movies);
                    films.setAdapter(adapter);
                } else {
                    Log.e("Error", "Response not successful");
                }
            }


            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                Log.e("Error", "Network error: " + t.getMessage());
            }
        });

        SearchView searchView = findViewById(R.id.searchView);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Intent intent = new Intent(Research.this, Research.class);
                intent.putExtra("search",query);
                startActivity(intent);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // Filtrer les données en fonction du texte de recherche
                return true;
            }
        });

    }
}
