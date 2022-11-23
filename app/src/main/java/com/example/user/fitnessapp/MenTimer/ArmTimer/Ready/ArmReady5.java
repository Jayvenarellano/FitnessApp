package com.example.user.fitnessapp.MenTimer.ArmTimer.Ready;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.fitnessapp.MenTimer.ArmTimer.ArmMenu.A.ArmA5;
import com.example.user.fitnessapp.MenTimer.ArmTimer.PopupInfoArm.ArmInfo5.InfoArm9;
import com.example.user.fitnessapp.MenTimer.ArmTimer.Start.ArmStart5;
import com.example.user.fitnessapp.R;

import io.github.krtkush.lineartimer.LinearTimer;
import io.github.krtkush.lineartimer.LinearTimerView;

public class ArmReady5 extends AppCompatActivity implements LinearTimer.TimerListener {

    CountDownTimer countDownTimer;
    LinearTimer ArmTimer5;
    TextView Armview5;
    TextView backarm5;
    TextView armskip5;
    ImageView arminfo5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arm_ready5);


        Armview5= (TextView) findViewById(R.id.Armview5);
        final LinearTimerView linearTimerView = (LinearTimerView) findViewById(R.id.ArmTimer5);


        backarm5=(TextView)findViewById(R.id.backarm5);
        backarm5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countDownTimer.cancel();
                ArmTimer5.pauseTimer();
                Intent intent = new Intent(ArmReady5.this, ArmA5.class);
                startActivity(intent);

            }
        });

        armskip5=(TextView)findViewById(R.id.armskip5);
        armskip5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countDownTimer.cancel();
                ArmTimer5.pauseTimer();
                Intent intent = new Intent(ArmReady5.this, ArmStart5.class);
                startActivity(intent);

            }
        });



        arminfo5=(ImageView)findViewById(R.id.arminfo5);
        arminfo5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countDownTimer.cancel();
                ArmTimer5.pauseTimer();
                Intent intent = new Intent(ArmReady5.this, InfoArm9.class);
                startActivity(intent);

            }
        });

        long duration = 10 * 510;

        ArmTimer5 = new LinearTimer.Builder()
                .linearTimerView(linearTimerView)
                .duration(duration)
                .timerListener(this)
                .getCountUpdate(LinearTimer.COUNT_DOWN_TIMER, 1000)
                .build();




        countDownTimer = new CountDownTimer(6000,  1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                Armview5.setText("" + millisUntilFinished/1000 );
                try {
                    ArmTimer5.startTimer();
                } catch (IllegalStateException e) {


                }


            }

            @Override
            public void onFinish() {
                Intent intent = new Intent(ArmReady5.this, ArmStart5.class);
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
