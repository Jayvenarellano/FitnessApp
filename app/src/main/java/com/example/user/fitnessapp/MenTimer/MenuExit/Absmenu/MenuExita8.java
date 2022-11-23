package com.example.user.fitnessapp.MenTimer.MenuExit.Absmenu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.util.DisplayMetrics;
import android.view.View;

import com.example.user.fitnessapp.Men.Men1;
import com.example.user.fitnessapp.MenTimer.AbsTimer.Start.AbsStart8;
import com.example.user.fitnessapp.R;

public class MenuExita8 extends AppCompatActivity implements View.OnClickListener{
    private CardView menuexita15,menuexita16;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_exita8);

        menuexita15 = (CardView) findViewById(R.id.menuexit15);
        menuexita16 = (CardView) findViewById(R.id.menuexit16);

        menuexita15.setOnClickListener(this);
        menuexita16.setOnClickListener(this);

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
            case R.id.menuexit15: i = new Intent(this,AbsStart8.class);startActivity(i); break;
            case R.id.menuexit16: i = new Intent(this,Men1.class);startActivity(i); break;
            default:break;
        }

    }
}
