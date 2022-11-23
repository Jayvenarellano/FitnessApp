package com.example.user.fitnessapp.MenTimer.ArmTimer.Start;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.fitnessapp.Men.Men2;
import com.example.user.fitnessapp.MenTimer.ArmTimer.ArmMenu.B.ArmB6;
import com.example.user.fitnessapp.MenTimer.ArmTimer.PopupInfoArm.ArmInfo6.InfoArm12;
import com.example.user.fitnessapp.R;

public class ArmStart6 extends AppCompatActivity  implements View.OnClickListener{
    private CardView kneestart1;
    ImageView arminfoa6;
    TextView backarma6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arm_start6);

        kneestart1 = (CardView) findViewById(R.id.kneestart1);

        kneestart1.setOnClickListener(this);

        arminfoa6 = (ImageView) findViewById(R.id.arminfoa6);
        arminfoa6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ArmStart6.this, InfoArm12.class);
                startActivity(intent);
            }
        });

        backarma6=(TextView) findViewById(R.id.backarma6);
        backarma6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ArmStart6.this, ArmB6.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View view) {

        Intent i;

        switch (view.getId()) {
            case R.id.kneestart1:
                i = new Intent(this,Men2.class);startActivity(i);break;
            default:
                break;
        }

    }
}
