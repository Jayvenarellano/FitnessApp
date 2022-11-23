package com.example.user.fitnessapp.Men;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;

import com.example.user.fitnessapp.Mens;
import com.example.user.fitnessapp.Popup.Popupwindow1;
import com.example.user.fitnessapp.Popup.Popupwindow2;
import com.example.user.fitnessapp.Popup.Popupwindow3;
import com.example.user.fitnessapp.Popup.Popupwindow4;
import com.example.user.fitnessapp.Popup.Popupwindow5;
import com.example.user.fitnessapp.Popup.Popupwindow6;
import com.example.user.fitnessapp.Popup.Popupwindow7;
import com.example.user.fitnessapp.Popup.Popupwindow8;
import com.example.user.fitnessapp.R;

public class Men1 extends AppCompatActivity implements View.OnClickListener{
    private CardView w1,w2,w3,w4,w5,w6,w7,w8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_men1);

        getSupportActionBar().setTitle("Abs Workout");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        w1 = (CardView) findViewById(R.id.w1);
        w2 = (CardView) findViewById(R.id.w2);
        w3 = (CardView) findViewById(R.id.w3);
        w4 = (CardView) findViewById(R.id.w4);
        w5 = (CardView) findViewById(R.id.w5);
        w6 = (CardView) findViewById(R.id.w6);
        w7 = (CardView) findViewById(R.id.w7);
        w8 = (CardView) findViewById(R.id.w8);

        w1.setOnClickListener(this);
        w2.setOnClickListener(this);
        w3.setOnClickListener(this);
        w4.setOnClickListener(this);
        w5.setOnClickListener(this);
        w6.setOnClickListener(this);
        w7.setOnClickListener(this);
        w8.setOnClickListener(this);
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
            case R.id.w1: i = new Intent(this,Popupwindow1.class);startActivity(i); break;
            case R.id.w2: i = new Intent(this,Popupwindow2.class);startActivity(i); break;
            case R.id.w3: i = new Intent(this,Popupwindow3.class);startActivity(i); break;
            case R.id.w4: i = new Intent(this,Popupwindow4.class);startActivity(i); break;
            case R.id.w5: i = new Intent(this,Popupwindow5.class);startActivity(i); break;
            case R.id.w6: i = new Intent(this,Popupwindow6.class);startActivity(i); break;
            case R.id.w7: i = new Intent(this,Popupwindow7.class);startActivity(i); break;
            case R.id.w8: i = new Intent(this,Popupwindow8.class);startActivity(i); break;
            default:break;
        }

    }
}
