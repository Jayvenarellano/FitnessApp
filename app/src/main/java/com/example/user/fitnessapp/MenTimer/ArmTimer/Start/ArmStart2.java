package com.example.user.fitnessapp.MenTimer.ArmTimer.Start;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.fitnessapp.MenTimer.ArmTimer.ArmMenu.B.ArmB2;
import com.example.user.fitnessapp.MenTimer.ArmTimer.PopupInfoArm.ArmInfo2.InfoArm4;
import com.example.user.fitnessapp.MenTimer.ArmTimer.Ready.ArmReady3;
import com.example.user.fitnessapp.R;

public class ArmStart2 extends AppCompatActivity implements View.OnClickListener{
    private CardView inclinestart1;
    ImageView arminfoa2;
    TextView backarma2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arm_start2);

        inclinestart1 = (CardView) findViewById(R.id.inclinestart1);

        inclinestart1.setOnClickListener(this);

        arminfoa2 = (ImageView) findViewById(R.id.arminfoa2);
        arminfoa2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ArmStart2.this, InfoArm4.class);
                startActivity(intent);
            }
        });

        backarma2=(TextView) findViewById(R.id.backarma2);
        backarma2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ArmStart2.this, ArmB2.class);
                startActivity(intent);

            }
        });


    }

    @Override
    public void onClick(View view) {
        Intent i;

        switch (view.getId()) {
            case R.id.inclinestart1:
                i = new Intent(this, ArmReady3.class);startActivity(i);break;
            default:
                break;
        }

    }
}
