package com.example.user.fitnessapp.MenTimer.ArmTimer.ArmMenu.A;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.util.DisplayMetrics;
import android.view.View;

import com.example.user.fitnessapp.Men.Men2;
import com.example.user.fitnessapp.MenTimer.ArmTimer.Ready.ArmReady4;
import com.example.user.fitnessapp.R;

public class ArmA4 extends AppCompatActivity implements View.OnClickListener {
    private CardView Armcon4,Armquit4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arm_a4);

        Armcon4 = (CardView) findViewById(R.id.Armcon4);
        Armquit4 = (CardView) findViewById(R.id.Armquit4);

        Armcon4.setOnClickListener(this);
        Armquit4.setOnClickListener(this);

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
            case R.id.Armcon4: i = new Intent(this,ArmReady4.class);startActivity(i); break;
            case R.id.Armquit4: i = new Intent(this,Men2.class);startActivity(i); break;
            default:break;
        }
    }
}
