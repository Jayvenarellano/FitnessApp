package com.example.user.fitnessapp.MenTimer.MenuExit.Absmenu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.util.DisplayMetrics;
import android.view.View;

import com.example.user.fitnessapp.Men.Men1;
import com.example.user.fitnessapp.MenTimer.AbsTimer.Start.AbsStart7;
import com.example.user.fitnessapp.R;

public class MenuExita7 extends AppCompatActivity implements View.OnClickListener{
    private CardView menuexita13,menuexita14;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_exita7);


        menuexita13 = (CardView) findViewById(R.id.menuexita13);
        menuexita14 = (CardView) findViewById(R.id.menuexita14);

        menuexita13.setOnClickListener(this);
        menuexita14.setOnClickListener(this);

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
            case R.id.menuexita13: i = new Intent(this,AbsStart7.class);startActivity(i); break;
            case R.id.menuexita14: i = new Intent(this,Men1.class);startActivity(i); break;
            default:break;
        }

    }
}
