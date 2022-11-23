package com.example.user.fitnessapp.MenTimer.ArmTimer.ArmMenu.B;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.util.DisplayMetrics;
import android.view.View;

import com.example.user.fitnessapp.Men.Men2;
import com.example.user.fitnessapp.MenTimer.ArmTimer.Start.ArmStart5;
import com.example.user.fitnessapp.R;

public class ArmB5 extends AppCompatActivity implements View.OnClickListener {
    private CardView ArmB5,ArmBA5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arm_b5);

        ArmB5 = (CardView) findViewById(R.id.ArmB5);
        ArmBA5 = (CardView) findViewById(R.id.ArmBA5);

        ArmB5.setOnClickListener(this);
        ArmBA5.setOnClickListener(this);

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
            case R.id.ArmB5: i = new Intent(this,ArmStart5.class);startActivity(i); break;
            case R.id.ArmBA5: i = new Intent(this,Men2.class);startActivity(i); break;
            default:break;
        }

    }
}
