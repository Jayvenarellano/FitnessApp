package com.example.user.fitnessapp.MenTimer.ArmTimer.ArmMenu.B;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.util.DisplayMetrics;
import android.view.View;

import com.example.user.fitnessapp.Men.Men2;
import com.example.user.fitnessapp.MenTimer.ArmTimer.Start.ArmStart2;
import com.example.user.fitnessapp.R;

public class ArmB2 extends AppCompatActivity implements View.OnClickListener {
    private CardView ArmB2,ArmBA2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arm_b2);

        ArmB2 = (CardView) findViewById(R.id.ArmB2);
        ArmBA2 = (CardView) findViewById(R.id.ArmBA2);

        ArmB2.setOnClickListener(this);
        ArmBA2.setOnClickListener(this);

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
            case R.id.ArmB2: i = new Intent(this,ArmStart2.class);startActivity(i); break;
            case R.id.ArmBA2: i = new Intent(this,Men2.class);startActivity(i); break;
            default:break;
        }
    }
}
