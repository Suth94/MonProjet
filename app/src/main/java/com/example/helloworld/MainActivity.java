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
import tmdb_api.*;


public class MainActivity extends AppCompatActivity {

    private ImageButton btn;
    private ImageButton btnAccount;
    private List<Movie> pop_movies;
    private List<Movie> new_movies;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        btn = findViewById(R.id.btnMenu) ;
        btnAccount = findViewById(R.id.btnAccount);

        //Init des films populaires
        CardView pop_film1 = findViewById(R.id.pop_film1) ;
        CardView pop_film2 = findViewById(R.id.pop_film2) ;
        CardView pop_film3 = findViewById(R.id.pop_film3) ;
        CardView pop_film4 = findViewById(R.id.pop_film4) ;

        TextView pop_titre1 = findViewById(R.id.pop_titre1);
        TextView pop_titre2 = findViewById(R.id.pop_titre2);
        TextView pop_titre3 = findViewById(R.id.pop_titre3);
        TextView pop_titre4 = findViewById(R.id.pop_titre4);

        ImageView pop_img1 = findViewById(R.id.pop_image1);
        ImageView pop_img2 = findViewById(R.id.pop_image2);
        ImageView pop_img3 = findViewById(R.id.pop_image3);
        ImageView pop_img4 = findViewById(R.id.pop_image4);

        //Init des films nouveaux
        CardView new_film1 = findViewById(R.id.new_film1) ;
        CardView new_film2 = findViewById(R.id.new_film2) ;
        CardView new_film3 = findViewById(R.id.new_film3) ;
        CardView new_film4 = findViewById(R.id.new_film4) ;

        TextView new_titre1 = findViewById(R.id.new_titre1);
        TextView new_titre2 = findViewById(R.id.new_titre2);
        TextView new_titre3 = findViewById(R.id.new_titre3);
        TextView new_titre4 = findViewById(R.id.new_titre4);

        ImageView new_img1 = findViewById(R.id.new_image1);
        ImageView new_img2 = findViewById(R.id.new_image2);
        ImageView new_img3 = findViewById(R.id.new_image3);
        ImageView new_img4 = findViewById(R.id.new_image4);




    //Appel API pour les films popuplaires
        TMDbApiInterface tmdbApi = TMDbApiClient.getClient();
        Call<MovieResponse> call = tmdbApi.getPopularMovies(TMDbApiClient.getApiKey());
        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                if (response.isSuccessful()) {
                    MovieResponse movieResponse = response.body();
                    pop_movies = movieResponse.getResults();

                    pop_titre1.setText(pop_movies.get(0).getTitle());
                    Glide.with(getApplicationContext()).load(pop_movies.get(0).getImgPATH()).into(pop_img1);
                    pop_titre2.setText(pop_movies.get(1).getTitle());
                    Glide.with(getApplicationContext()).load(pop_movies.get(1).getImgPATH()).into(pop_img2);
                    pop_titre3.setText(pop_movies.get(2).getTitle());
                    Glide.with(getApplicationContext()).load(pop_movies.get(2).getImgPATH()).into(pop_img3);
                    pop_titre4.setText(pop_movies.get(3).getTitle());
                    Glide.with(getApplicationContext()).load(pop_movies.get(3).getImgPATH()).into(pop_img4);
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

                    new_titre1.setText(new_movies.get(0).getTitle());
                    Glide.with(getApplicationContext()).load(new_movies.get(0).getImgPATH()).into(new_img1);
                    new_titre2.setText(new_movies.get(1).getTitle());
                    Glide.with(getApplicationContext()).load(new_movies.get(1).getImgPATH()).into(new_img2);
                    new_titre3.setText(new_movies.get(2).getTitle());
                    Glide.with(getApplicationContext()).load(new_movies.get(2).getImgPATH()).into(new_img3);
                    new_titre4.setText(new_movies.get(3).getTitle());
                    Glide.with(getApplicationContext()).load(new_movies.get(3).getImgPATH()).into(new_img4);
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


        pop_film1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,MovieDetail.class);
                intent.putExtra("movie",pop_movies.get(0));
                startActivity(intent);
            }
        });
        pop_film2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,MovieDetail.class);
                intent.putExtra("movie",pop_movies.get(1));
                startActivity(intent);
            }
        });

        pop_film3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,MovieDetail.class);
                intent.putExtra("movie",pop_movies.get(2));
                startActivity(intent);
            }
        });

        pop_film4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,MovieDetail.class);
                intent.putExtra("movie",pop_movies.get(3));
                startActivity(intent);
            }
        });





        new_film1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,MovieDetail.class);
                intent.putExtra("movie",new_movies.get(0));
                startActivity(intent);
            }
        });
        new_film2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,MovieDetail.class);
                intent.putExtra("movie",new_movies.get(1));
                startActivity(intent);
            }
        });

        new_film3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,MovieDetail.class);
                intent.putExtra("movie",new_movies.get(2));
                startActivity(intent);
            }
        });

        new_film4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,MovieDetail.class);
                intent.putExtra("movie",new_movies.get(3));
                startActivity(intent);
            }
        });
    }



}