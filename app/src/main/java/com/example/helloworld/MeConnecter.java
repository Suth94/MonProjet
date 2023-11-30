package com.example.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MeConnecter extends AppCompatActivity {
    private TextView connect;
    private TextView password;
    private TextView email;
    private ImageView avatar;
    private EditText motdepasse;
    private EditText adresse;


    private Button seconnecter;

    private Button register;

    private static String MDP = "MDP";

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

        seconnecter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Mot_De_Passe = motdepasse.getText().toString();
                /*Intent intent = getIntent();
                String[] emails = intent.getStringArrayExtra("enteredEmail");
                String[] passwords = intent.getStringArrayExtra("enteredPassword");
                for(int i = 0; i<10; i++ ){
                    if (Mot_De_Passe.equals(passwords[i])){*/
                if (Mot_De_Passe.equals(MDP)) {
                    startActivity(new Intent(MeConnecter.this, MainActivity.class));
                }
                else {
                    password.setText("Mot de passe éroné");
                }
            }

        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MeConnecter.this, Creationcompte.class));
            }

        });
    }
}