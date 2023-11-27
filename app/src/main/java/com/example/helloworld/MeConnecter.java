package com.example.helloworld;

import android.media.Image;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MeConnecter extends AppCompatActivity {

    private TextView connect;
    private TextView password;
    private TextView email;
    private ImageView avatar;
    private EditText motdepasse;
    private EditText adresse;

    private

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.meconnecter);
        adresse =  findViewById(R.id.EmailAddress);
        motdepasse = findViewById(R.id.Password);
        avatar = findViewById(R.id.Avatar);
        email = findViewById(R.id.email);
        password = findViewById(R.id.MDP);
        connect = findViewById(R.id.Seconnecter);
        getSupportActionBar().setTitle("Se Connecter");


    }
}