package com.example.user.fitnessapp.MenTimer.ChestTimer.Start;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.fitnessapp.MenTimer.ChestTimer.Ready.ChestReady4;
import com.example.user.fitnessapp.R;

public class ChestStart3 extends AppCompatActivity implements View.OnClickListener{
    private CardView cheststarts3;
    ImageView chestinfos3;
    TextView chestbacks3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chest_start3);

        cheststarts3 = (CardView) findViewById(R.id.cheststarts3);

        cheststarts3.setOnClickListener(this);

        chestinfos3 = (ImageView) findViewById(R.id.chestinfos3);
        chestinfos3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        chestbacks3=(TextView) findViewById(R.id.chestbacks3);
        chestbacks3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public void onClick(View view) {
        Intent i;

        switch (view.getId()) {
            case R.id.cheststarts3:
                i = new Intent(this, ChestReady4.class);startActivity(i);break;
            default:
                break;
        }



    }
}
