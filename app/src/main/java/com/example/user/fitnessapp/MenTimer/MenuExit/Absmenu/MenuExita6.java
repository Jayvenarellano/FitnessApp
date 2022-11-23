package com.example.user.fitnessapp.MenTimer.MenuExit.Absmenu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.util.DisplayMetrics;
import android.view.View;

import com.example.user.fitnessapp.Men.Men1;
import com.example.user.fitnessapp.MenTimer.AbsTimer.Start.AbsStart6;
import com.example.user.fitnessapp.R;

public class MenuExita6 extends AppCompatActivity implements View.OnClickListener{
    private CardView menuexita11,menuexita12;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_exita6);

        menuexita11 = (CardView) findViewById(R.id.menuexita11);
        menuexita12 = (CardView) findViewById(R.id.menuexita12);

        menuexita11.setOnClickListener(this);
        menuexita12.setOnClickListener(this);

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
            case R.id.menuexita11: i = new Intent(this,AbsStart6.class);startActivity(i); break;
            case R.id.menuexita12: i = new Intent(this,Men1.class);startActivity(i); break;
            default:break;
        }

    }
}
