package com.example.user.fitnessapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;

import com.example.user.fitnessapp.Men.Men1;
import com.example.user.fitnessapp.Men.Men2;
import com.example.user.fitnessapp.Men.Men3;
import com.example.user.fitnessapp.Men.Men4;

public class Mens extends AppCompatActivity implements View.OnClickListener{
    private CardView men1, men2, men3, men4, men5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mens);

        getSupportActionBar().setTitle("Men's Workout");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        men1 = (CardView) findViewById(R.id.men1);
        men2 = (CardView) findViewById(R.id.men2);
        men3 = (CardView) findViewById(R.id.men3);
        men4 = (CardView) findViewById(R.id.men4);


        men1.setOnClickListener(this);
        men2.setOnClickListener(this);
        men3.setOnClickListener(this);
        men4.setOnClickListener(this);



    }

    @Override
    public void onBackPressed(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }

    @Override
    public void onClick(View v) {
        Intent i;

        switch (v.getId()){
            case R.id.men1: i = new Intent(this,Men1.class);startActivity(i); break;
            case R.id.men2: i = new Intent(this,Men2.class);startActivity(i); break;
            case R.id.men3: i = new Intent(this,Men3.class);startActivity(i); break;
            case R.id.men4: i = new Intent(this,Men4.class);startActivity(i); break;
            default:break;
        }

    }
}
