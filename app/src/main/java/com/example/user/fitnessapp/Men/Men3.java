package com.example.user.fitnessapp.Men;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;

import com.example.user.fitnessapp.Mens;
import com.example.user.fitnessapp.PopupArm.Arm1;
import com.example.user.fitnessapp.PopupArm.Arm2;
import com.example.user.fitnessapp.PopupArm.Arm3;
import com.example.user.fitnessapp.PopupArm.Arm4;
import com.example.user.fitnessapp.PopupArm.Arm5;
import com.example.user.fitnessapp.PopupArm.Arm6;
import com.example.user.fitnessapp.R;

public class Men3 extends AppCompatActivity implements View.OnClickListener{
    private CardView armworkouts1,armworkouts2,armworkouts3,armworkouts4,armworkouts5,armworkouts6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_men3);

        getSupportActionBar().setTitle("Arm Workout");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        armworkouts1 = (CardView) findViewById(R.id.armworkouts1);
        armworkouts2 = (CardView) findViewById(R.id.armworkouts2);
        armworkouts3 = (CardView) findViewById(R.id.armworkouts3);
        armworkouts4 = (CardView) findViewById(R.id.armworkouts4);
        armworkouts5 = (CardView) findViewById(R.id.armworkouts5);
        armworkouts6 = (CardView) findViewById(R.id.armworkouts6);




        armworkouts1.setOnClickListener(this);
        armworkouts2.setOnClickListener(this);
        armworkouts3.setOnClickListener(this);
        armworkouts4.setOnClickListener(this);
        armworkouts5.setOnClickListener(this);
        armworkouts6.setOnClickListener(this);


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
            case R.id.armworkouts1: i = new Intent(this,Arm1.class);startActivity(i); break;
            case R.id.armworkouts2: i = new Intent(this,Arm2.class);startActivity(i); break;
            case R.id.armworkouts3: i = new Intent(this,Arm3.class);startActivity(i); break;
            case R.id.armworkouts4: i = new Intent(this,Arm4.class);startActivity(i); break;
            case R.id.armworkouts5: i = new Intent(this,Arm5.class);startActivity(i); break;
            case R.id.armworkouts6: i = new Intent(this,Arm6.class);startActivity(i); break;

            default:break;
        }


    }
}
