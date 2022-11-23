package com.example.user.fitnessapp.MenTimer.MenuExit.Absmenu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.util.DisplayMetrics;
import android.view.View;

import com.example.user.fitnessapp.Men.Men1;
import com.example.user.fitnessapp.MenTimer.AbsTimer.Ready.AbsReady7;
import com.example.user.fitnessapp.R;

public class MenuExit7 extends AppCompatActivity implements View.OnClickListener{
    private CardView menuexit13,menuexit14;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_exit7);


        menuexit13 = (CardView) findViewById(R.id.menuexit13);
        menuexit14 = (CardView) findViewById(R.id.menuexit14);

        menuexit13.setOnClickListener(this);
        menuexit14.setOnClickListener(this);

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
            case R.id.menuexit13: i = new Intent(this,AbsReady7.class);startActivity(i); break;
            case R.id.menuexit14: i = new Intent(this,Men1.class);startActivity(i); break;
            default:break;
        }

    }
}
