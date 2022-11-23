package com.example.user.fitnessapp.MenTimer.MenuExit.Absmenu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.util.DisplayMetrics;
import android.view.View;

import com.example.user.fitnessapp.Men.Men1;
import com.example.user.fitnessapp.MenTimer.AbsTimer.Ready.AbsReady2;
import com.example.user.fitnessapp.R;

public class MenuExit2 extends AppCompatActivity implements View.OnClickListener{
    private CardView menuexit3,menuexit4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_exit2);


        menuexit3 = (CardView) findViewById(R.id.menuexit3);
        menuexit4 = (CardView) findViewById(R.id.menuexit4);

        menuexit3.setOnClickListener(this);
        menuexit4.setOnClickListener(this);

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
            case R.id.menuexit3: i = new Intent(this,AbsReady2.class);startActivity(i); break;
            case R.id.menuexit4: i = new Intent(this,Men1.class);startActivity(i); break;
            default:break;
        }


    }
}
