package com.example.samit.kodutoo3;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

     ImageButton kivi, karid, paber;
     Button btn_Skore;
     TextView tulemus, Score;
     ImageView arvutivalik, sinuvalik;
     int sinu_score, arvuti_score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        kivi = findViewById(R.id.kivi);
        karid = findViewById(R.id.karid);
        paber = findViewById(R.id.paber);
        tulemus = findViewById(R.id.tulemus);
        arvutivalik = findViewById(R.id.ArvutiValik);
        sinuvalik = findViewById(R.id.SinuValik);
        Score= findViewById(R.id.Score);
        btn_Skore=findViewById(R.id.button);



        kivi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sinuvalik.setImageResource(R.drawable.kivi);
                String message = Mang("kivi");
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                Score.setText("Sinu tulemus" + Integer.toString(sinu_score) + " Arvuti tulemus : " + Integer.toString(arvuti_score));
            }
        });

        karid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sinuvalik.setImageResource(R.drawable.karid);
                String message = Mang("karid");
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                Score.setText("Sinu tulemus" + Integer.toString(sinu_score) + " Arvuti tulemus: " + Integer.toString(arvuti_score));
            }
        });
        paber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sinuvalik.setImageResource(R.drawable.paber);
                String message = Mang("paber");
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();

                Score.setText("Sinu tulemus" + Integer.toString(sinu_score) + " Arvuti tulemus: " + Integer.toString(arvuti_score));

            }
        });

       /* Intent myIntent=new Intent(this,Skore.class);
        myIntent.putExtra("Score","Sinu tulemus on:");
        startActivity(myIntent);*/

        btn_Skore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences preferences=getSharedPreferences("MYPREFS", MODE_PRIVATE);
                SharedPreferences.Editor editor=preferences.edit();
                String Skr= Skore.getText().toString();
                editor.putString (Skr, Skr );
                editor.commit();



                Intent nSore=new Intent(MainActivity.this, Skore.class);
                nSore.putExtra("Score","Sinu tulemus on:");
                startActivity(nSore);
            }
        });
    }
        public String Mang(String sinu_valik){
            String arvuti_valik = "";
            Random rand = new Random();
            int arvuti_tulemus = rand.nextInt(3) + 1;
            if (arvuti_tulemus == 1) {
                arvuti_valik = "kivi";
                arvutivalik.setImageResource(R.drawable.kivi);
            } else if (arvuti_tulemus == 2) {
                arvuti_valik = "kärid";
                arvutivalik.setImageResource(R.drawable.karid);
            } else if (arvuti_tulemus == 3){
                arvuti_valik = "paber";
                arvutivalik.setImageResource(R.drawable.paber);
            }

            if (arvuti_valik == sinu_valik) {
                return "Kedagi ei vöitnud";

            } else if (sinu_valik == "kivi" && arvuti_valik == "kärid") {
                sinu_score++;
                tulemus.setText("Sina võitsid");
            } else if (sinu_valik == "kivi" && arvuti_valik == "paber") {
                arvuti_score++;
                tulemus.setText("Mäng Ära");
            } else if (sinu_valik == "karid" && arvuti_valik == "kivi") {
                arvuti_score++;
                tulemus.setText("Mäng Ära");
            } else if (sinu_valik == "karid" && arvuti_valik == "paber") {
                sinu_score++;
                tulemus.setText("Sina võitsid");
            } else if (sinu_valik == "paber" && arvuti_valik == "kivi") {
                sinu_score++;
                tulemus.setText("Sina võitsid");
            } else if (sinu_valik == "paber" && arvuti_valik == "karid") {
                arvuti_score++;
                tulemus.setText("Mäng Ära");
            }
            return "";




        }

    }













