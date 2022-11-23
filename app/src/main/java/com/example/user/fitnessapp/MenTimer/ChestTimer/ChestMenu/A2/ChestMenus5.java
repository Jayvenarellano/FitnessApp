package com.example.user.fitnessapp.MenTimer.ChestTimer.ChestMenu.A2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.util.DisplayMetrics;
import android.view.View;

import com.example.user.fitnessapp.Men.Men3;
import com.example.user.fitnessapp.MenTimer.ChestTimer.Ready.ChestReady5;
import com.example.user.fitnessapp.R;

public class ChestMenus5 extends AppCompatActivity implements View.OnClickListener {
    private CardView ChestBtn5,ChestBtns5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chest_menus5);

        ChestBtn5 = (CardView) findViewById(R.id.ChestBtn5);
        ChestBtns5 = (CardView) findViewById(R.id.ChestBtns5);

        ChestBtn5.setOnClickListener(this);
        ChestBtns5.setOnClickListener(this);

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
            case R.id.ChestBtn5: i = new Intent(this,ChestReady5.class);startActivity(i); break;
            case R.id.ChestBtns5: i = new Intent(this,Men3.class);startActivity(i); break;
            default:break;
        }

    }
}
