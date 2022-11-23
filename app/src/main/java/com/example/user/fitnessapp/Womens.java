package com.example.user.fitnessapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Womens extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_womens);

        getSupportActionBar().setTitle("Women's Workout");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void onBackPressed(){

    }
}
