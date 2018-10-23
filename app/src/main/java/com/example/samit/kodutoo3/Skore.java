package com.example.samit.kodutoo3;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.widget.ArrayAdapter;
import android.widget.ListView;

import android.widget.Toast;

import java.util.ArrayList;



public class Skore extends AppCompatActivity {
    //TextView Skore_name, Skore_skore;
    ListView ListView1;
    private ArrayList<String> Skore = new ArrayList<>();
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.name_skore);

        //Skore_name= findViewById(R.id.Skore_name);
        //Skore_skore=findViewById(R.id.Skore_skore);
        ListView1= findViewById(R.id.ListView1);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Skore);
        //ListView1.setAdapter(adapter);


        //String Skore_name=intent.getStringExtra("name"+"Score");
        //Skore.add(Skore_name);
        ListView1.setAdapter(adapter);
        //String Skore_skore=intent.getStringExtra("Score");

       SharedPreferences preferences=getSharedPreferences("MYPREFS",MODE_PRIVATE);
        //ntent intent=getIntent();
        String skore =preferences.getString("name"+"Skore", "");
        Skore.add(skore);
        Toast.makeText(this, "Sinu tilemused", Toast.LENGTH_SHORT).show();





    }

}
