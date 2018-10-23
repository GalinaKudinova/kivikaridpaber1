package com.example.samit.kodutoo3;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Login extends AppCompatActivity {
    TextView name;
    Button btnOK;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logo);
        name=findViewById(R.id.Name);
        btnOK= findViewById(R.id.btnOK);

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // salvetsame nimi
                SharedPreferences preferences=getSharedPreferences("MYPREFS", MODE_PRIVATE);
                String User= name.getText().toString();

                SharedPreferences.Editor editor=preferences.edit();
                editor.putString(User,User );
                editor.commit();
                //  key in skore.class
                Intent loginScreen= new Intent(Login.this, Skore.class);
                loginScreen.putExtra("name", "Sinu nimi on: ");
                startActivity(loginScreen);

                //Lähme Mainactivitisse
                Intent log=new Intent("MainActivity");
                startActivity(log);
            }
        });
    }
}
