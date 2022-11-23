package com.example.user.fitnessapp.MenTimer.ArmTimer.Ready;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.fitnessapp.MenTimer.ArmTimer.ArmMenu.A.ArmA6;
import com.example.user.fitnessapp.MenTimer.ArmTimer.PopupInfoArm.ArmInfo6.InfoArm11;
import com.example.user.fitnessapp.MenTimer.ArmTimer.Start.ArmStart6;
import com.example.user.fitnessapp.R;

import io.github.krtkush.lineartimer.LinearTimer;
import io.github.krtkush.lineartimer.LinearTimerView;

public class ArmReady6 extends AppCompatActivity implements LinearTimer.TimerListener {


    CountDownTimer countDownTimer;
    LinearTimer ArmTimer6;
    TextView Armview6;
    TextView backarm6;
    TextView armskip6;
    ImageView arminfo6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arm_ready6);


        Armview6= (TextView) findViewById(R.id.Armview6);
        final LinearTimerView linearTimerView = (LinearTimerView) findViewById(R.id.ArmTimer6);


        backarm6=(TextView)findViewById(R.id.backarm6);
        backarm6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countDownTimer.cancel();
                ArmTimer6.pauseTimer();
                Intent intent = new Intent(ArmReady6.this, ArmA6.class);
                startActivity(intent);


            }
        });

        armskip6=(TextView)findViewById(R.id.armskip6);
        armskip6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countDownTimer.cancel();
                ArmTimer6.pauseTimer();
                Intent intent = new Intent(ArmReady6.this, ArmStart6.class);
                startActivity(intent);

            }
        });



        arminfo6=(ImageView)findViewById(R.id.arminfo6);
        arminfo6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countDownTimer.cancel();
                ArmTimer6.pauseTimer();
                Intent intent = new Intent(ArmReady6.this, InfoArm11.class);
                startActivity(intent);

            }
        });

        long duration = 10 * 510;

        ArmTimer6 = new LinearTimer.Builder()
                .linearTimerView(linearTimerView)
                .duration(duration)
                .timerListener(this)
                .getCountUpdate(LinearTimer.COUNT_DOWN_TIMER, 1000)
                .build();




        countDownTimer = new CountDownTimer(6000,  1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                Armview6.setText("" + millisUntilFinished/1000 );
                try {
                    ArmTimer6.startTimer();
                } catch (IllegalStateException e) {


                }


            }

            @Override
            public void onFinish() {
                Intent intent = new Intent(ArmReady6.this, ArmStart6.class);
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
