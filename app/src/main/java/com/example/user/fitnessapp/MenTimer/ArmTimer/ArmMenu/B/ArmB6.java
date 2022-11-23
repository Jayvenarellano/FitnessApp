package com.example.user.fitnessapp.MenTimer.ArmTimer.ArmMenu.B;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.util.DisplayMetrics;
import android.view.View;

import com.example.user.fitnessapp.Men.Men2;
import com.example.user.fitnessapp.MenTimer.ArmTimer.Start.ArmStart6;
import com.example.user.fitnessapp.R;

public class ArmB6 extends AppCompatActivity implements View.OnClickListener {
    private CardView ArmB6,ArmBA6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arm_b6);

        ArmB6 = (CardView) findViewById(R.id.ArmB6);
        ArmBA6 = (CardView) findViewById(R.id.ArmBA6);

        ArmB6.setOnClickListener(this);
        ArmBA6.setOnClickListener(this);

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
            case R.id.ArmB6: i = new Intent(this,ArmStart6.class);startActivity(i); break;
            case R.id.ArmBA6: i = new Intent(this,Men2.class);startActivity(i); break;
            default:break;
        }
    }
}
