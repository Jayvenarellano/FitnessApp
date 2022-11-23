package com.example.user.fitnessapp.MenTimer.ChestTimer.ChestMenu.A1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.util.DisplayMetrics;
import android.view.View;

import com.example.user.fitnessapp.Men.Men3;
import com.example.user.fitnessapp.MenTimer.ChestTimer.Ready.ChestReady6;
import com.example.user.fitnessapp.R;

public class ChestMenu6 extends AppCompatActivity implements View.OnClickListener {
    private CardView ChestBtn6,ChestBtns6;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chest_menu6);

        ChestBtn6 = (CardView) findViewById(R.id.ChestBtn6);
        ChestBtns6 = (CardView) findViewById(R.id.ChestBtns6);

        ChestBtn6.setOnClickListener(this);
        ChestBtns6.setOnClickListener(this);

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
            case R.id.ChestBtn6: i = new Intent(this,ChestReady6.class);startActivity(i); break;
            case R.id.ChestBtns6: i = new Intent(this,Men3.class);startActivity(i); break;
            default:break;
        }

    }
}
