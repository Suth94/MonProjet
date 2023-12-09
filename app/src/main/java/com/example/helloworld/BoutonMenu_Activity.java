package com.example.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class BoutonMenu_Activity extends AppCompatActivity {

    ListView lv;
    ArrayList<String> data;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bouton_menu);
        getSupportActionBar().hide();

        lv = (ListView) findViewById(R.id.listview_1);
        data = new ArrayList<>();
        data.add("Genre");
        data.add("Meilleures notes");
        data.add("A l'affiche");

        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                data );
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
                if(pos==0){
                    startActivity(new Intent(BoutonMenu_Activity.this, GenreActivity.class));
                }
                if(pos==1){
                    startActivity(new Intent(BoutonMenu_Activity.this, BestNotes_Activity.class));
                }
                if(pos==2){
                    startActivity(new Intent(BoutonMenu_Activity.this, OnDisplay_Activity.class));
                }
            }
        });
    }
}