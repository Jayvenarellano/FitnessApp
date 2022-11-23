package com.example.user.fitnessapp.MenTimer.ChestTimer.ChestMenu.A2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.util.DisplayMetrics;
import android.view.View;

import com.example.user.fitnessapp.Men.Men3;
import com.example.user.fitnessapp.MenTimer.ChestTimer.Ready.ChestReady2;
import com.example.user.fitnessapp.R;

public class ChestMenus2 extends AppCompatActivity implements View.OnClickListener {
    private CardView ChestBtn2,ChestBtns2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chest_menus2);

        ChestBtn2 = (CardView) findViewById(R.id.ChestBtn2);
        ChestBtns2 = (CardView) findViewById(R.id.ChestBtns2);

        ChestBtn2.setOnClickListener(this);
        ChestBtns2.setOnClickListener(this);

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
            case R.id.ChestBtn2: i = new Intent(this,ChestReady2.class);startActivity(i); break;
            case R.id.ChestBtns2: i = new Intent(this,Men3.class);startActivity(i); break;
            default:break;
        }
    }
}
