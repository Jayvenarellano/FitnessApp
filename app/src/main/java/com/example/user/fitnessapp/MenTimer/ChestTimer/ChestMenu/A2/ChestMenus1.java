package com.example.user.fitnessapp.MenTimer.ChestTimer.ChestMenu.A2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.util.DisplayMetrics;
import android.view.View;

import com.example.user.fitnessapp.Men.Men3;
import com.example.user.fitnessapp.MenTimer.ChestTimer.Ready.ChestReady1;
import com.example.user.fitnessapp.R;

public class ChestMenus1 extends AppCompatActivity implements View.OnClickListener{
    private CardView ChestBtn1,ChestBtns1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chest_menus1);

        ChestBtn1 = (CardView) findViewById(R.id.ChestBtn1);
        ChestBtns1 = (CardView) findViewById(R.id.ChestBtns1);

        ChestBtn1.setOnClickListener(this);
        ChestBtns1.setOnClickListener(this);

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
            case R.id.ChestBtn1: i = new Intent(this,ChestReady1.class);startActivity(i); break;
            case R.id.ChestBtns1: i = new Intent(this,Men3.class);startActivity(i); break;
            default:break;
        }

    }
}
