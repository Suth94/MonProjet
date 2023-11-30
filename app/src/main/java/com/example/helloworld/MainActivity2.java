package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    ListView lv;
    ArrayList<String> data;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getSupportActionBar().hide();

        lv = (ListView) findViewById(R.id.listview_1);
        data = new ArrayList<>();
        data.add("Genre");
        data.add("Mieux notés");
        data.add("A l'affiche");
        data.add("Pour vous");
        https://developer.android.com/guide/topics/ui/declaring-layout#AdapterViews
        /* adapts an array of data of type List<T> of undetermined size. this is to further be used by a view */
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,  /* android standard layout for a single entry from list: just some text and just a horizontal separator */
                data /* the List<T> contents */);
        lv.setAdapter(adapter);

        /* listen to clicks on a view whose contents depend on an adapter. that's our case */
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
                if(pos==0){
                    startActivity(new Intent(MainActivity2.this,MainActivity3.class));
                }
                if(pos==1){
                    startActivity(new Intent(MainActivity2.this,MainActivity4.class));
                }
                if(pos==2){
                    startActivity(new Intent(MainActivity2.this,MainActivity5.class));
                }
                if(pos==3){
                    startActivity(new Intent(MainActivity2.this,MainActivity6.class));
                }
            }
        });
    }
}