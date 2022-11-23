package com.example.user.fitnessapp.Men;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;

import com.example.user.fitnessapp.Mens;
import com.example.user.fitnessapp.PopupLeg.Leg1;
import com.example.user.fitnessapp.PopupLeg.Leg2;
import com.example.user.fitnessapp.PopupLeg.Leg3;
import com.example.user.fitnessapp.PopupLeg.Leg4;
import com.example.user.fitnessapp.PopupLeg.Leg5;
import com.example.user.fitnessapp.PopupLeg.Leg6;
import com.example.user.fitnessapp.R;

public class Men4 extends AppCompatActivity implements View.OnClickListener {
    private CardView legworkouts1,legworkouts2,legworkouts3,legworkouts4,legworkouts5,legworkouts6,legworkouts7,legworkouts8,legworkouts9
            ,legworkouts10,legworkouts11,legworkouts12,legworkouts13,legworkouts14;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_men4);

        getSupportActionBar().setTitle("Leg Workout");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        legworkouts1 = (CardView) findViewById(R.id.legworkouts1);
        legworkouts2 = (CardView) findViewById(R.id.legworkouts2);
        legworkouts3 = (CardView) findViewById(R.id.legworkouts3);
        legworkouts4 = (CardView) findViewById(R.id.legworkouts4);
        legworkouts5 = (CardView) findViewById(R.id.legworkouts5);
        legworkouts6 = (CardView) findViewById(R.id.legworkouts6);




        legworkouts1.setOnClickListener(this);
        legworkouts2.setOnClickListener(this);
        legworkouts3.setOnClickListener(this);
        legworkouts4.setOnClickListener(this);
        legworkouts5.setOnClickListener(this);
        legworkouts6.setOnClickListener(this);



    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, Mens.class);
        startActivity(intent);

    }

    @Override
    public void onClick(View v) {
        Intent i;

        switch (v.getId()){
            case R.id.legworkouts1: i = new Intent(this,Leg1.class);startActivity(i); break;
            case R.id.legworkouts2: i = new Intent(this,Leg2.class);startActivity(i); break;
            case R.id.legworkouts3: i = new Intent(this,Leg3.class);startActivity(i); break;
            case R.id.legworkouts4: i = new Intent(this,Leg4.class);startActivity(i); break;
            case R.id.legworkouts5: i = new Intent(this,Leg5.class);startActivity(i); break;
            case R.id.legworkouts6: i = new Intent(this,Leg6.class);startActivity(i); break;

            default:break;
        }


    }
}
