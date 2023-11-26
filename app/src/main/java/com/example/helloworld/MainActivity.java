package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

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
        film1 = findViewById(R.id.film1) ;
        film2 = findViewById(R.id.film2) ;
        film3 = findViewById(R.id.film3) ;
        film4 = findViewById(R.id.film4) ;

        getSupportActionBar().hide();


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,MainActivity2.class));
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