package com.example.user.fitnessapp.MenTimer.ArmTimer.Start;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.fitnessapp.MenTimer.ArmTimer.ArmMenu.B.ArmB5;
import com.example.user.fitnessapp.MenTimer.ArmTimer.PopupInfoArm.ArmInfo5.InfoArm10;
import com.example.user.fitnessapp.MenTimer.ArmTimer.Ready.ArmReady6;
import com.example.user.fitnessapp.R;

public class ArmStart5 extends AppCompatActivity implements View.OnClickListener{
    private CardView triceparmstart1;
    ImageView arminfoa5;
    TextView backarma5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arm_start5);


        triceparmstart1 = (CardView) findViewById(R.id.triceparmstart1);

        triceparmstart1.setOnClickListener(this);

        arminfoa5 = (ImageView) findViewById(R.id.arminfoa5);
        arminfoa5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ArmStart5.this, InfoArm10.class);
                startActivity(intent);
            }
        });

        backarma5=(TextView) findViewById(R.id.backarma5);
        backarma5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ArmStart5.this, ArmB5.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View view) {
        Intent i;

        switch (view.getId()) {
            case R.id.triceparmstart1:
                i = new Intent(this, ArmReady6.class);startActivity(i);break;
            default:
                break;
        }

    }
}
