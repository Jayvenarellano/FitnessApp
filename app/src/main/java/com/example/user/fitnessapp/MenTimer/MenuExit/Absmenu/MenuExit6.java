package com.example.user.fitnessapp.MenTimer.MenuExit.Absmenu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.util.DisplayMetrics;
import android.view.View;

import com.example.user.fitnessapp.Men.Men1;
import com.example.user.fitnessapp.MenTimer.AbsTimer.Ready.AbsReady6;
import com.example.user.fitnessapp.R;

public class MenuExit6 extends AppCompatActivity implements View.OnClickListener{
    private CardView menuexit11,menuexit12;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_exit6);


        menuexit11 = (CardView) findViewById(R.id.menuexit11);
        menuexit12 = (CardView) findViewById(R.id.menuexit12);

        menuexit11.setOnClickListener(this);
        menuexit12.setOnClickListener(this);

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
            case R.id.menuexit11: i = new Intent(this,AbsReady6.class);startActivity(i); break;
            case R.id.menuexit12: i = new Intent(this,Men1.class);startActivity(i); break;
            default:break;
        }

    }
}
