package com.example.user.fitnessapp.MenTimer.ArmTimer.Start;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.fitnessapp.MenTimer.ArmTimer.ArmMenu.B.ArmB4;
import com.example.user.fitnessapp.MenTimer.ArmTimer.PopupInfoArm.ArmInfo4.InfoArm8;
import com.example.user.fitnessapp.MenTimer.ArmTimer.Ready.ArmReady5;
import com.example.user.fitnessapp.R;

public class ArmStart4 extends AppCompatActivity  implements View.OnClickListener{
    private CardView widestart1;
    ImageView arminfoa4;
    TextView backarma4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arm_start4);

        widestart1 = (CardView) findViewById(R.id.widestart1);

        widestart1.setOnClickListener(this);

        arminfoa4 = (ImageView) findViewById(R.id.arminfoa4);
        arminfoa4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ArmStart4.this, InfoArm8.class);
                startActivity(intent);

            }
        });

        backarma4=(TextView) findViewById(R.id.backarma4);
        backarma4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ArmStart4.this, ArmB4.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View view) {
        Intent i;

        switch (view.getId()) {
            case R.id.widestart1:
                i = new Intent(this, ArmReady5.class);startActivity(i);break;
            default:
                break;
        }
    }
}
