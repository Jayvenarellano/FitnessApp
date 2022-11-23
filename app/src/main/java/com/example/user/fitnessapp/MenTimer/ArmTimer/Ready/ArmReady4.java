package com.example.user.fitnessapp.MenTimer.ArmTimer.Ready;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.fitnessapp.MenTimer.ArmTimer.ArmMenu.A.ArmA4;
import com.example.user.fitnessapp.MenTimer.ArmTimer.PopupInfoArm.ArmInfo4.InfoArm7;
import com.example.user.fitnessapp.MenTimer.ArmTimer.Start.ArmStart4;
import com.example.user.fitnessapp.R;

import io.github.krtkush.lineartimer.LinearTimer;
import io.github.krtkush.lineartimer.LinearTimerView;

public class ArmReady4 extends AppCompatActivity implements LinearTimer.TimerListener {

    CountDownTimer countDownTimer;
    LinearTimer ArmTimer4;
    TextView Armview4;
    TextView backarm4;
    TextView armskip4;
    ImageView arminfo4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arm_ready4);

        Armview4= (TextView) findViewById(R.id.Armview4);
        final LinearTimerView linearTimerView = (LinearTimerView) findViewById(R.id.ArmTimer4);


        backarm4=(TextView)findViewById(R.id.backarm4);
        backarm4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countDownTimer.cancel();
                ArmTimer4.pauseTimer();
                Intent intent = new Intent(ArmReady4.this, ArmA4.class);
                startActivity(intent);

            }
        });

        armskip4=(TextView)findViewById(R.id.armskip4);
        armskip4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countDownTimer.cancel();
                ArmTimer4.pauseTimer();
                Intent intent = new Intent(ArmReady4.this, ArmStart4.class);
                startActivity(intent);

            }
        });



        arminfo4=(ImageView)findViewById(R.id.arminfo4);
        arminfo4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countDownTimer.cancel();
                ArmTimer4.pauseTimer();
                Intent intent = new Intent(ArmReady4.this, InfoArm7.class);
                startActivity(intent);

            }
        });

        long duration = 10 * 510;

        ArmTimer4 = new LinearTimer.Builder()
                .linearTimerView(linearTimerView)
                .duration(duration)
                .timerListener(this)
                .getCountUpdate(LinearTimer.COUNT_DOWN_TIMER, 1000)
                .build();




        countDownTimer = new CountDownTimer(6000,  1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                Armview4.setText("" + millisUntilFinished/1000 );
                try {
                    ArmTimer4.startTimer();
                } catch (IllegalStateException e) {


                }


            }

            @Override
            public void onFinish() {
                Intent intent = new Intent(ArmReady4.this, ArmStart4.class);
                startActivity(intent);




            }
        }.start();

    }

    @Override
    public void animationComplete() {

    }

    @Override
    public void timerTick(long tickUpdateInMillis) {

    }

    @Override
    public void onTimerReset() {

    }
}
