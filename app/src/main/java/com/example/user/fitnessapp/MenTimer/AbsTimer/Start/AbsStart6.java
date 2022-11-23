package com.example.user.fitnessapp.MenTimer.AbsTimer.Start;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.fitnessapp.MenTimer.AbsTimer.PopupInfo.Info1.Info6.PopupInfoA6;
import com.example.user.fitnessapp.MenTimer.AbsTimer.Ready.AbsReady7;
import com.example.user.fitnessapp.MenTimer.MenuExit.Absmenu.MenuExita6;
import com.example.user.fitnessapp.R;

public class AbsStart6 extends AppCompatActivity implements View.OnClickListener{
    private CardView legstart6;
    ImageView textinfoa6;
    TextView textbackA6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abs_start6);


        legstart6 = (CardView) findViewById(R.id.legstart6);

        legstart6.setOnClickListener(this);



        textinfoa6 = (ImageView) findViewById(R.id.infoA6);
        textinfoa6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AbsStart6.this, PopupInfoA6.class);
                startActivity(intent);
            }
        });

        textbackA6=(TextView) findViewById(R.id.armbackA6   );
        textbackA6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AbsStart6.this, MenuExita6.class);
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
            case R.id.legstart6:
                i = new Intent(this, AbsReady7.class);startActivity(i);break;
            default:
                break;
        }


    }
}
