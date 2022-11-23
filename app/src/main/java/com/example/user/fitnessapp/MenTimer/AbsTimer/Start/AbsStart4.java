package com.example.user.fitnessapp.MenTimer.AbsTimer.Start;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.fitnessapp.MenTimer.AbsTimer.PopupInfo.Info1.Info4.PopupInfoA4;
import com.example.user.fitnessapp.MenTimer.AbsTimer.Ready.AbsReady5;
import com.example.user.fitnessapp.MenTimer.MenuExit.Absmenu.MenuExita4;
import com.example.user.fitnessapp.R;

public class AbsStart4 extends AppCompatActivity implements View.OnClickListener{
    private CardView mountainstart1;
    ImageView textinfoa4;
    TextView textbackA4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abs_start4);

        mountainstart1 = (CardView) findViewById(R.id.mountainstart1);

        mountainstart1.setOnClickListener(this);

        textinfoa4 = (ImageView) findViewById(R.id.infoA4);
        textinfoa4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AbsStart4.this, PopupInfoA4.class);
                startActivity(intent);
            }
        });

        textbackA4=(TextView) findViewById(R.id.armbackA4);
        textbackA4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AbsStart4.this, MenuExita4.class);
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
            case R.id.mountainstart1:
                i = new Intent(this, AbsReady5.class);startActivity(i);break;
            default:
                break;
        }

    }
}
