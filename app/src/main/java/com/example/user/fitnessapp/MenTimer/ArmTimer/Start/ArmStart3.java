package com.example.user.fitnessapp.MenTimer.ArmTimer.Start;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.fitnessapp.MenTimer.ArmTimer.ArmMenu.B.ArmB3;
import com.example.user.fitnessapp.MenTimer.ArmTimer.PopupInfoArm.ArmInfo3.InfoArm6;
import com.example.user.fitnessapp.MenTimer.ArmTimer.Ready.ArmReady4;
import com.example.user.fitnessapp.R;

public class ArmStart3 extends AppCompatActivity  implements View.OnClickListener{
    private CardView pushupstart1;
    ImageView arminfoa3;
    TextView backarma3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arm_start3);

        pushupstart1 = (CardView) findViewById(R.id.pushupstart1);

        pushupstart1.setOnClickListener(this);

        arminfoa3 = (ImageView) findViewById(R.id.arminfoa3);
        arminfoa3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ArmStart3.this, InfoArm6.class);
                startActivity(intent);

            }
        });

        backarma3=(TextView) findViewById(R.id.backarma3);
        backarma3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ArmStart3.this, ArmB3.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View view) {
        Intent i;

        switch (view.getId()) {
            case R.id.pushupstart1:
                i = new Intent(this, ArmReady4.class);startActivity(i);break;
            default:
                break;
        }

    }
}
