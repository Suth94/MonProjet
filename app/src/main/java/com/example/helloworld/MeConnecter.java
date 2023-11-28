package com.example.helloworld;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
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

    private Button seconnecter;

    private Button register;

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
        seconnecter = findViewById(R.id.button_se_connecter);
        register = findViewById(R.id.button_register);
        getSupportActionBar().setTitle("Se Connecter");

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MeConnecter.this,creationcompte.class));
            }
        });


    }
}