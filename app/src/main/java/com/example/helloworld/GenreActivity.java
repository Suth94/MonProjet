package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class GenreActivity extends AppCompatActivity {

    ListView lv;
    ArrayList<String> data;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        getSupportActionBar().setTitle("Genre");
        lv = (ListView) findViewById(R.id.listview_1);
        data = new ArrayList<>();
        data.add("Action");
        data.add("Aventure");
        data.add("Comédie");
        data.add("Drame");
        data.add("Horreur");
        data.add("Science-fiction");
        data.add("Thriller");

        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, data);
        lv.setAdapter(adapter);

    }

}