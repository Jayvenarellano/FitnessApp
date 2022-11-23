package com.example.user.fitnessapp.MenTimer.ArmTimer.Ready;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.fitnessapp.MenTimer.ArmTimer.ArmMenu.A.ArmA2;
import com.example.user.fitnessapp.MenTimer.ArmTimer.PopupInfoArm.ArmInfo2.InfoArm3;
import com.example.user.fitnessapp.MenTimer.ArmTimer.Start.ArmStart2;
import com.example.user.fitnessapp.R;

import io.github.krtkush.lineartimer.LinearTimer;
import io.github.krtkush.lineartimer.LinearTimerView;

public class ArmReady2 extends AppCompatActivity implements LinearTimer.TimerListener{
    CountDownTimer countDownTimer;
    LinearTimer ArmTimer2;
    TextView Armview2;
    TextView backarm2;
    TextView armskip2;
    ImageView arminfo2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arm_ready2);

        Armview2= (TextView) findViewById(R.id.Armview2);
        final LinearTimerView linearTimerView = (LinearTimerView) findViewById(R.id.ArmTimer2);


        backarm2=(TextView)findViewById(R.id.backarm2);
        backarm2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countDownTimer.cancel();
                ArmTimer2.pauseTimer();
                Intent intent = new Intent(ArmReady2.this, ArmA2.class);
                startActivity(intent);

            }
        });

        armskip2=(TextView)findViewById(R.id.armskip2);
        armskip2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countDownTimer.cancel();
                ArmTimer2.pauseTimer();
                Intent intent = new Intent(ArmReady2.this, ArmStart2.class);
                startActivity(intent);

            }
        });



        arminfo2=(ImageView)findViewById(R.id.arminfo2);
        arminfo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countDownTimer.cancel();
                ArmTimer2.pauseTimer();
                Intent intent = new Intent(ArmReady2.this, InfoArm3.class);
                startActivity(intent);

            }
        });

        long duration = 10 * 510;

        ArmTimer2 = new LinearTimer.Builder()
                .linearTimerView(linearTimerView)
                .duration(duration)
                .timerListener(this)
                .getCountUpdate(LinearTimer.COUNT_DOWN_TIMER, 1000)
                .build();




        countDownTimer = new CountDownTimer(6000,  1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                Armview2.setText("" + millisUntilFinished/1000 );
                try {
                    ArmTimer2.startTimer();
                } catch (IllegalStateException e) {


                }


            }

            @Override
            public void onFinish() {
                Intent intent = new Intent(ArmReady2.this, ArmStart2.class);
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
