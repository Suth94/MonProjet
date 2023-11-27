package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tmdb_api.Movie;
import tmdb_api.MovieResponse;
import tmdb_api.TMDbApiClient;
import tmdb_api.TMDbApiInterface;


public class MainActivity extends AppCompatActivity {

    private ImageButton btn;
    private ImageButton btnAccount;

    private CardView film1;
    private CardView film2;
    private CardView film3;
    private CardView film4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.btnMenu) ;
        btnAccount = findViewById(R.id.btnAccount);
        film1 = findViewById(R.id.film1) ;
        film2 = findViewById(R.id.film2) ;
        film3 = findViewById(R.id.film3) ;
        film4 = findViewById(R.id.film4) ;

        TextView titre1 = findViewById(R.id.titre1);
        TextView titre2 = findViewById(R.id.titre2);
        TextView titre3 = findViewById(R.id.titre3);
        TextView titre4 = findViewById(R.id.titre4);

        ImageView img1 = findViewById(R.id.image1);
        ImageView img2 = findViewById(R.id.image2);
        ImageView img3 = findViewById(R.id.image3);
        ImageView img4 = findViewById(R.id.image4);


        getSupportActionBar().hide();

        TMDbApiInterface tmdbApi = TMDbApiClient.getClient();
        Call<MovieResponse> call = tmdbApi.getPopularMovies(TMDbApiClient.getApiKey());

        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                if (response.isSuccessful()) {
                    MovieResponse movieResponse = response.body();
                    List<Movie> movies = movieResponse.getResults();

                    titre1.setText(movies.get(0).getTitle());
                    Glide.with(getApplicationContext()).load(movies.get(0).getImgPATH()).into(img1);
                    titre2.setText(movies.get(1).getTitle());
                    Glide.with(getApplicationContext()).load(movies.get(1).getImgPATH()).into(img2);
                    titre3.setText(movies.get(2).getTitle());
                    Glide.with(getApplicationContext()).load(movies.get(2).getImgPATH()).into(img3);
                    titre4.setText(movies.get(3).getTitle());
                    Glide.with(getApplicationContext()).load(movies.get(3).getImgPATH()).into(img4);
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
                startActivity(new Intent(MainActivity.this,MainActivity2.class));
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,MainActivity2.class));
            }
        });

        btnAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent( MainActivity.this, MeConnecter.class));
            }
        });


        film1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,MovieDetail.class));
            }
        });
        film2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,MovieDetail.class));
            }
        });

        film3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,MovieDetail.class));
            }
        });

        film4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,MovieDetail.class));
            }
        });
    }



        }