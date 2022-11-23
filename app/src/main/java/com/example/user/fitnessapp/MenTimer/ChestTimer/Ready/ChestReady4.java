package com.example.user.fitnessapp.MenTimer.ChestTimer.Ready;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.fitnessapp.MenTimer.ChestTimer.ChestInfo.A1.ChestInfoA4;
import com.example.user.fitnessapp.MenTimer.ChestTimer.ChestMenu.A1.ChestMenu4;
import com.example.user.fitnessapp.MenTimer.ChestTimer.Start.ChestStart4;
import com.example.user.fitnessapp.R;

import io.github.krtkush.lineartimer.LinearTimer;
import io.github.krtkush.lineartimer.LinearTimerView;

public class ChestReady4 extends AppCompatActivity implements LinearTimer.TimerListener {
    CountDownTimer countDownTimer;
    LinearTimer chestTimer4;
    TextView chestView4;
    TextView chestback4;
    TextView chestskip4;
    ImageView chestinfo4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chest_ready4);

        chestView4= (TextView) findViewById(R.id.chestView4);
        final LinearTimerView linearTimerView = (LinearTimerView) findViewById(R.id.chestTimer4);


        chestback4=(TextView)findViewById(R.id.chestback4);
        chestback4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countDownTimer.cancel();
                chestTimer4.pauseTimer();
                Intent intent = new Intent(ChestReady4.this, ChestMenu4.class);
                startActivity(intent);



            }
        });

        chestskip4=(TextView)findViewById(R.id.chestskip4);
        chestskip4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countDownTimer.cancel();
                chestTimer4.pauseTimer();
                Intent intent = new Intent(ChestReady4.this, ChestStart4.class);
                startActivity(intent);

            }
        });



        chestinfo4=(ImageView)findViewById(R.id.chestinfo4);
        chestinfo4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countDownTimer.cancel();
                chestTimer4.pauseTimer();
                Intent intent = new Intent(ChestReady4.this, ChestInfoA4.class);
                startActivity(intent);

            }
        });

        long duration = 10 * 510;

        chestTimer4 = new LinearTimer.Builder()
                .linearTimerView(linearTimerView)
                .duration(duration)
                .timerListener(this)
                .getCountUpdate(LinearTimer.COUNT_DOWN_TIMER, 1000)
                .build();




        countDownTimer = new CountDownTimer(6000,  1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                chestView4.setText("" + millisUntilFinished/1000 );
                try {
                    chestTimer4.startTimer();
                } catch (IllegalStateException e) {


                }


            }

            @Override
            public void onFinish() {
                Intent intent = new Intent(ChestReady4.this, ChestStart4.class);
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
