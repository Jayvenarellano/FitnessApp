package com.example.user.fitnessapp.MenTimer.ChestTimer.ChestMenu.A2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.util.DisplayMetrics;
import android.view.View;

import com.example.user.fitnessapp.Men.Men3;
import com.example.user.fitnessapp.MenTimer.ChestTimer.Ready.ChestReady4;
import com.example.user.fitnessapp.R;

public class ChestMenus4 extends AppCompatActivity implements View.OnClickListener {
    private CardView ChestBtn4,ChestBtns4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chest_menus4);

        ChestBtn4 = (CardView) findViewById(R.id.ChestBtn4);
        ChestBtns4 = (CardView) findViewById(R.id.ChestBtns4);

        ChestBtn4.setOnClickListener(this);
        ChestBtns4.setOnClickListener(this);

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
            case R.id.ChestBtn4: i = new Intent(this,ChestReady4.class);startActivity(i); break;
            case R.id.ChestBtns4: i = new Intent(this,Men3.class);startActivity(i); break;
            default:break;
        }

    }
}
