package com.example.user.fitnessapp.MenTimer.AbsTimer.Start;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.fitnessapp.MenTimer.AbsTimer.PopupInfo.Info1.Info2.PopupInfoA2;
import com.example.user.fitnessapp.MenTimer.AbsTimer.Ready.AbsReady3;
import com.example.user.fitnessapp.MenTimer.MenuExit.Absmenu.MenuExita2;
import com.example.user.fitnessapp.R;

public class AbsStart2 extends AppCompatActivity implements View.OnClickListener {
    private CardView abdominalstart1;
    ImageView textinfoa2;
    TextView textbackA2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abs_start2);

        abdominalstart1 = (CardView) findViewById(R.id.abdominalstart1);

        abdominalstart1.setOnClickListener(this);

        textinfoa2 = (ImageView) findViewById(R.id.infoA2);
        textinfoa2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AbsStart2.this, PopupInfoA2.class);
                startActivity(intent);
            }
        });

        textbackA2=(TextView) findViewById(R.id.armbackA2);
        textbackA2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AbsStart2.this, MenuExita2.class);
                startActivity(intent);
            }
        });


    }
    @Override
    public void onBackPressed(){
    }


    @Override
    public void onClick(View v) {
        Intent i;

        switch (v.getId()) {
            case R.id.abdominalstart1:
                i = new Intent(this, AbsReady3.class);startActivity(i);break;
            default:
                break;
        }
    }
}
