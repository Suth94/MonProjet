package com.example.helloworld;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Creationcompte extends AppCompatActivity {
    private TextView info;
    private TextView bienvenue;
    private EditText name;
    private EditText  email;
    private EditText mdp;
    private EditText confirmation_mdp;
    private Button enregistrer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.creationcompte);
        info = findViewById(R.id.info);
        bienvenue = findViewById(R.id.bienvenue);
        name = findViewById(R.id.et_name);
        email = findViewById(R.id.et_email);
        mdp = findViewById(R.id.et_password);
        confirmation_mdp = findViewById(R.id.et_repassword);
        enregistrer = findViewById(R.id.button);

        getSupportActionBar().hide();
    }
}
