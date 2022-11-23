package com.example.user.fitnessapp.MenTimer.ArmTimer.Start;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.fitnessapp.MenTimer.ArmTimer.ArmMenu.B.ArmB1;
import com.example.user.fitnessapp.MenTimer.ArmTimer.PopupInfoArm.ArmInfo1.InfoArm2;
import com.example.user.fitnessapp.MenTimer.ArmTimer.Ready.ArmReady2;
import com.example.user.fitnessapp.R;

import io.github.krtkush.lineartimer.LinearTimer;
import io.github.krtkush.lineartimer.LinearTimerView;

public class ArmStart1 extends AppCompatActivity implements LinearTimer.TimerListener {
    CountDownTimer countDownTimer;
    LinearTimer ArmTimera1;
    TextView ArmViewa1;
    ImageView Arminfoa1;
    TextView backArma1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arm_start1);


        ArmViewa1= (TextView) findViewById(R.id.ArmViewa1);
        LinearTimerView linearTimerView = (LinearTimerView) findViewById(R.id.ArmTimera1);

        long duration = 10 * 3000;

        ArmTimera1 = new LinearTimer.Builder()
                .linearTimerView(linearTimerView)
                .duration(duration)
                .timerListener(this)
                .getCountUpdate(LinearTimer.COUNT_DOWN_TIMER, 1000)
                .build();

        Arminfoa1=(ImageView)findViewById(R.id.Arminfoa1);
        Arminfoa1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countDownTimer.cancel();
                ArmTimera1.pauseTimer();
                Intent intent = new Intent(ArmStart1.this, InfoArm2.class);
                startActivity(intent);

            }
        });

        backArma1=(TextView) findViewById(R.id.backArma1);
        backArma1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countDownTimer.cancel();
                ArmTimera1.pauseTimer();
                Intent intent = new Intent(ArmStart1.this, ArmB1.class);
                startActivity(intent);

            }
        });




        countDownTimer = new CountDownTimer(31000,  1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                ArmViewa1.setText("" + millisUntilFinished/1000 );
                try {
                    ArmTimera1.startTimer();
                } catch (IllegalStateException e) {
                }


            }

            @Override
            public void onFinish() {
                Intent intent = new Intent(ArmStart1.this, ArmReady2.class);
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
