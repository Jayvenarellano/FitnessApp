package com.example.user.fitnessapp.MenTimer.ChestTimer.Start;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.fitnessapp.MenTimer.ChestTimer.Ready.ChestReady2;
import com.example.user.fitnessapp.R;

public class ChestStart1 extends AppCompatActivity implements View.OnClickListener{
    private CardView cheststarts1;
    ImageView chestinfos1;
    TextView chestbacks1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chest_start1);

        cheststarts1 = (CardView) findViewById(R.id.cheststarts1);

        cheststarts1.setOnClickListener(this);

        chestinfos1 = (ImageView) findViewById(R.id.chestinfos1);
        chestinfos1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        chestbacks1=(TextView) findViewById(R.id.chestbacks1);
        chestbacks1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    @Override
    public void onClick(View view) {
        Intent i;

        switch (view.getId()) {
            case R.id.cheststarts1:
                i = new Intent(this, ChestReady2.class);startActivity(i);break;
            default:
                break;
        }

    }
}
