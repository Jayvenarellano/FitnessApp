package com.example.user.fitnessapp.MenTimer.ArmTimer.Ready;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.fitnessapp.MenTimer.ArmTimer.ArmMenu.A.ArmA3;
import com.example.user.fitnessapp.MenTimer.ArmTimer.PopupInfoArm.ArmInfo3.InfoArm5;
import com.example.user.fitnessapp.MenTimer.ArmTimer.Start.ArmStart3;
import com.example.user.fitnessapp.R;

import io.github.krtkush.lineartimer.LinearTimer;
import io.github.krtkush.lineartimer.LinearTimerView;

public class ArmReady3 extends AppCompatActivity implements LinearTimer.TimerListener {
    CountDownTimer countDownTimer;
    LinearTimer ArmTimer3;
    TextView Armview3;
    TextView backarm3;
    TextView armskip3;
    ImageView arminfo3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arm_ready3);


        Armview3= (TextView) findViewById(R.id.Armview3);
        final LinearTimerView linearTimerView = (LinearTimerView) findViewById(R.id.ArmTimer3);


        backarm3=(TextView)findViewById(R.id.backarm3);
        backarm3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countDownTimer.cancel();
                ArmTimer3.pauseTimer();
                Intent intent = new Intent(ArmReady3.this, ArmA3.class);
                startActivity(intent);

            }
        });

        armskip3=(TextView)findViewById(R.id.armskip3);
        armskip3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countDownTimer.cancel();
                ArmTimer3.pauseTimer();
                Intent intent = new Intent(ArmReady3.this, ArmStart3.class);
                startActivity(intent);

            }
        });



        arminfo3=(ImageView)findViewById(R.id.arminfo3);
        arminfo3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countDownTimer.cancel();
                ArmTimer3.pauseTimer();
                Intent intent = new Intent(ArmReady3.this, InfoArm5.class);
                startActivity(intent);

            }
        });

        long duration = 10 * 510;

        ArmTimer3 = new LinearTimer.Builder()
                .linearTimerView(linearTimerView)
                .duration(duration)
                .timerListener(this)
                .getCountUpdate(LinearTimer.COUNT_DOWN_TIMER, 1000)
                .build();




        countDownTimer = new CountDownTimer(6000,  1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                Armview3.setText("" + millisUntilFinished/1000 );
                try {
                    ArmTimer3.startTimer();
                } catch (IllegalStateException e) {


                }


            }

            @Override
            public void onFinish() {
                Intent intent = new Intent(ArmReady3.this, ArmStart3.class);
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
