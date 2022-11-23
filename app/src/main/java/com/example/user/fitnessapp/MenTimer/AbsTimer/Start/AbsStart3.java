package com.example.user.fitnessapp.MenTimer.AbsTimer.Start;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.fitnessapp.MenTimer.AbsTimer.PopupInfo.Info1.Info3.PopupInfoA3;
import com.example.user.fitnessapp.MenTimer.AbsTimer.Ready.AbsReady4;
import com.example.user.fitnessapp.MenTimer.MenuExit.Absmenu.MenuExita3;
import com.example.user.fitnessapp.R;

public class AbsStart3 extends AppCompatActivity implements View.OnClickListener{
    private CardView russsianstart1;
    ImageView textinfoa3;
    TextView textbackA3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abs_start3);

        russsianstart1 = (CardView) findViewById(R.id.russsianstart1);

        russsianstart1.setOnClickListener(this);



        textinfoa3 = (ImageView) findViewById(R.id.infoA3);
        textinfoa3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AbsStart3.this, PopupInfoA3.class);
                startActivity(intent);
            }
        });

        textbackA3=(TextView) findViewById(R.id.armbackA3);
        textbackA3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AbsStart3.this, MenuExita3.class);
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
            case R.id.russsianstart1:i = new Intent(this, AbsReady4.class);startActivity(i);break;
            default:break;
        }

    }
}
