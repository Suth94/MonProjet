package com.example.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import java.util.List;
import java.util.ArrayList;

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
        List<String> names = new ArrayList<>();
        List<String> emails = new ArrayList<>();
        List<String> passwords = new ArrayList<>();

        info = findViewById(R.id.info);
        bienvenue = findViewById(R.id.bienvenue);
        name = findViewById(R.id.et_name);
        email = findViewById(R.id.et_email);
        mdp = findViewById(R.id.et_password);
        confirmation_mdp = findViewById(R.id.et_repassword);
        enregistrer = findViewById(R.id.button);

        getSupportActionBar().hide();


        enregistrer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Mot_De_Passe = mdp.getText().toString();
                String check2 = confirmation_mdp.getText().toString();
                String Name = name.getText().toString();
                String EMAIL = email.getText().toString();

                names.add(Name);
                emails.add(EMAIL);
                passwords.add(Mot_De_Passe);

                String[] emailsTAB = emails.toArray(new String[0]);
                String[] passwordsTAB = passwords.toArray(new String[0]);

                Intent intent = new Intent(Creationcompte.this, MeConnecter.class);
                intent.putExtra("enteredEmail", emailsTAB);
                intent.putExtra("enteredPassword", passwordsTAB);
                startActivity(intent);
                if (Mot_De_Passe.equals(check2)){
                    finish();

                }
                else {
                    bienvenue.setText("Les deux derniers champs doivent être identique");
                }
            }
        });
    }
}
