package com.example.user.fitnessapp.MenTimer.ArmTimer.ArmMenu.B;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.util.DisplayMetrics;
import android.view.View;

import com.example.user.fitnessapp.Men.Men2;
import com.example.user.fitnessapp.MenTimer.ArmTimer.Start.ArmStart1;
import com.example.user.fitnessapp.R;

public class ArmB1 extends AppCompatActivity implements View.OnClickListener{
    private CardView ArmB1,ArmBA1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arm_b1);

        ArmB1 = (CardView) findViewById(R.id.ArmB1);
        ArmBA1 = (CardView) findViewById(R.id.ArmBA1);

        ArmB1.setOnClickListener(this);
        ArmBA1.setOnClickListener(this);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.9),(int)(height*.6));
    }

    @Override
    public void onClick(View view) {
        Intent i;

        switch (view.getId()){
            case R.id.ArmB1: i = new Intent(this,ArmStart1.class);startActivity(i); break;
            case R.id.ArmBA1: i = new Intent(this,Men2.class);startActivity(i); break;
            default:break;
        }
    }
}
