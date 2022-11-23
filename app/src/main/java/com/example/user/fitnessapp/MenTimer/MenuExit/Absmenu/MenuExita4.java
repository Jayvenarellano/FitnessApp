package com.example.user.fitnessapp.MenTimer.MenuExit.Absmenu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.util.DisplayMetrics;
import android.view.View;

import com.example.user.fitnessapp.Men.Men1;
import com.example.user.fitnessapp.MenTimer.AbsTimer.Start.AbsStart4;
import com.example.user.fitnessapp.R;

public class MenuExita4 extends AppCompatActivity implements View.OnClickListener{
    private CardView menuexita7,menuexita8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_exita4);

        menuexita7 = (CardView) findViewById(R.id.menuexita7);
        menuexita8 = (CardView) findViewById(R.id.menuexita8);

        menuexita7.setOnClickListener(this);
        menuexita8.setOnClickListener(this);

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
            case R.id.menuexita7: i = new Intent(this,AbsStart4.class);startActivity(i); break;
            case R.id.menuexita8: i = new Intent(this,Men1.class);startActivity(i); break;
            default:break;
        }

    }
}
