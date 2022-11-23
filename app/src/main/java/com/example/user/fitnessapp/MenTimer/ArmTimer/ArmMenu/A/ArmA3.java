package com.example.user.fitnessapp.MenTimer.ArmTimer.ArmMenu.A;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.util.DisplayMetrics;
import android.view.View;

import com.example.user.fitnessapp.Men.Men2;
import com.example.user.fitnessapp.MenTimer.ArmTimer.Ready.ArmReady3;
import com.example.user.fitnessapp.R;

public class ArmA3 extends AppCompatActivity implements View.OnClickListener {
    private CardView Armcon3,Armquit3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arm_a3);

        Armcon3 = (CardView) findViewById(R.id.Armcon3);
        Armquit3 = (CardView) findViewById(R.id.Armquit3);

        Armcon3.setOnClickListener(this);
        Armquit3.setOnClickListener(this);

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
            case R.id.Armcon3: i = new Intent(this,ArmReady3.class);startActivity(i); break;
            case R.id.Armquit3: i = new Intent(this,Men2.class);startActivity(i); break;
            default:break;
        }
    }
}
