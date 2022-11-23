package com.example.user.fitnessapp.MenTimer.MenuExit.Absmenu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.util.DisplayMetrics;
import android.view.View;

import com.example.user.fitnessapp.Men.Men1;
import com.example.user.fitnessapp.MenTimer.AbsTimer.Ready.AbsReady4;
import com.example.user.fitnessapp.R;

public class MenuExit4 extends AppCompatActivity implements View.OnClickListener{
    private CardView menuexit7,menuexit8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_exit4);


        menuexit7 = (CardView) findViewById(R.id.menuexit7);
        menuexit8 = (CardView) findViewById(R.id.menuexit8);

        menuexit7.setOnClickListener(this);
        menuexit8.setOnClickListener(this);

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
            case R.id.menuexit7: i = new Intent(this,AbsReady4.class);startActivity(i); break;
            case R.id.menuexit8: i = new Intent(this,Men1.class);startActivity(i); break;
            default:break;
        }

    }
}
