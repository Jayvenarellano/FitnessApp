package com.example.user.fitnessapp.Men;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;

import com.example.user.fitnessapp.Mens;
import com.example.user.fitnessapp.PopupChest.Chest1;
import com.example.user.fitnessapp.PopupChest.Chest2;
import com.example.user.fitnessapp.PopupChest.Chest3;
import com.example.user.fitnessapp.PopupChest.Chest4;
import com.example.user.fitnessapp.PopupChest.Chest5;
import com.example.user.fitnessapp.PopupChest.Chest6;
import com.example.user.fitnessapp.R;

public class Men2 extends AppCompatActivity implements View.OnClickListener{
    private CardView chestworkout1,chestworkout2,chestworkout3,chestworkout4,chestworkout5,chestworkout6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_men2);

        getSupportActionBar().setTitle("Chest Workout");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        chestworkout1 = (CardView) findViewById(R.id.chestworkout1);
        chestworkout2 = (CardView) findViewById(R.id.chestworkout2);
        chestworkout3 = (CardView) findViewById(R.id.chestworkout3);
        chestworkout4 = (CardView) findViewById(R.id.chestworkout4);
        chestworkout5 = (CardView) findViewById(R.id.chestworkout5);
        chestworkout6 = (CardView) findViewById(R.id.chestworkout6);



        chestworkout1.setOnClickListener(this);
        chestworkout2.setOnClickListener(this);
        chestworkout3.setOnClickListener(this);
        chestworkout4.setOnClickListener(this);
        chestworkout5.setOnClickListener(this);
        chestworkout6.setOnClickListener(this);


    }

    @Override
    public void onBackPressed(){
        Intent intent = new Intent(this, Mens.class);
        startActivity(intent);

    }


    @Override
    public void onClick(View v) {
        Intent i;

        switch (v.getId()){
            case R.id.chestworkout1: i = new Intent(this,Chest1.class);startActivity(i); break;
            case R.id.chestworkout2: i = new Intent(this,Chest2.class);startActivity(i); break;
            case R.id.chestworkout3: i = new Intent(this,Chest3.class);startActivity(i); break;
            case R.id.chestworkout4: i = new Intent(this,Chest4.class);startActivity(i); break;
            case R.id.chestworkout5: i = new Intent(this,Chest5.class);startActivity(i); break;
            case R.id.chestworkout6: i = new Intent(this,Chest6.class);startActivity(i); break;
            default:break;
        }

    }
}
