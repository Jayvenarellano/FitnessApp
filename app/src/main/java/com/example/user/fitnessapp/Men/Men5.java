package com.example.user.fitnessapp.Men;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;

import com.example.user.fitnessapp.Mens;
import com.example.user.fitnessapp.PopupSandB.SB1;
import com.example.user.fitnessapp.PopupSandB.SB2;
import com.example.user.fitnessapp.PopupSandB.SB3;
import com.example.user.fitnessapp.PopupSandB.SB4;
import com.example.user.fitnessapp.PopupSandB.SB5;
import com.example.user.fitnessapp.PopupSandB.SB6;
import com.example.user.fitnessapp.PopupSandB.SB7;
import com.example.user.fitnessapp.R;

public class Men5 extends AppCompatActivity implements View.OnClickListener{
    private CardView sandbworkout1,sandbworkout2,sandbworkout3,sandbworkout4,sandbworkout5,sandbworkout6,sandbworkout7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_men5);

        getSupportActionBar().setTitle("Shoulder & Back Workout");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        sandbworkout1 = (CardView) findViewById(R.id.sandbworkout1);
        sandbworkout2 = (CardView) findViewById(R.id.sandbworkout2);
        sandbworkout3 = (CardView) findViewById(R.id.sandbworkout3);
        sandbworkout4 = (CardView) findViewById(R.id.sandbworkout4);
        sandbworkout5 = (CardView) findViewById(R.id.sandbworkout5);
        sandbworkout6 = (CardView) findViewById(R.id.sandbworkout6);
        sandbworkout7 = (CardView) findViewById(R.id.sandbworkout7);


        sandbworkout1.setOnClickListener(this);
        sandbworkout2.setOnClickListener(this);
        sandbworkout3.setOnClickListener(this);
        sandbworkout4.setOnClickListener(this);
        sandbworkout5.setOnClickListener(this);
        sandbworkout6.setOnClickListener(this);
        sandbworkout7.setOnClickListener(this);
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
            case R.id.sandbworkout1: i = new Intent(this,SB1.class);startActivity(i); break;
            case R.id.sandbworkout2: i = new Intent(this,SB2.class);startActivity(i); break;
            case R.id.sandbworkout3: i = new Intent(this,SB3.class);startActivity(i); break;
            case R.id.sandbworkout4: i = new Intent(this,SB4.class);startActivity(i); break;
            case R.id.sandbworkout5: i = new Intent(this,SB5.class);startActivity(i); break;
            case R.id.sandbworkout6: i = new Intent(this,SB6.class);startActivity(i); break;
            case R.id.sandbworkout7: i = new Intent(this,SB7.class);startActivity(i); break;
            default:break;
        }

    }
}
