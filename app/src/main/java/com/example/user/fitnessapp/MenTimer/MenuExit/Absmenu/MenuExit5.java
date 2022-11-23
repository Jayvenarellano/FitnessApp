package com.example.user.fitnessapp.MenTimer.MenuExit.Absmenu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.util.DisplayMetrics;
import android.view.View;

import com.example.user.fitnessapp.Men.Men1;
import com.example.user.fitnessapp.MenTimer.AbsTimer.Ready.AbsReady5;
import com.example.user.fitnessapp.R;

public class MenuExit5 extends AppCompatActivity implements View.OnClickListener{
    private CardView menuexit9,menuexit10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_exit5);


        menuexit9 = (CardView) findViewById(R.id.menuexit9);
        menuexit10 = (CardView) findViewById(R.id.menuexit10);

        menuexit9.setOnClickListener(this);
        menuexit10.setOnClickListener(this);

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
            case R.id.menuexit9: i = new Intent(this,AbsReady5.class);startActivity(i); break;
            case R.id.menuexit10: i = new Intent(this,Men1.class);startActivity(i); break;
            default:break;
        }

    }
}
