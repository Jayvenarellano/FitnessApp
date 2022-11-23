package com.example.user.fitnessapp.MenTimer.ArmTimer.ArmMenu.A;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.util.DisplayMetrics;
import android.view.View;

import com.example.user.fitnessapp.Men.Men2;
import com.example.user.fitnessapp.MenTimer.ArmTimer.Ready.ArmReady5;
import com.example.user.fitnessapp.R;

public class ArmA5 extends AppCompatActivity implements View.OnClickListener {
    private CardView Armcon5,Armquit5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arm_a5);
        Armcon5 = (CardView) findViewById(R.id.Armcon5);
        Armquit5 = (CardView) findViewById(R.id.Armquit5);

        Armcon5.setOnClickListener(this);
        Armquit5.setOnClickListener(this);

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
            case R.id.Armcon5: i = new Intent(this,ArmReady5.class);startActivity(i); break;
            case R.id.Armquit5: i = new Intent(this,Men2.class);startActivity(i); break;
            default:break;
        }

    }
}
