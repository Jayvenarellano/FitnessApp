package com.example.user.fitnessapp.MenTimer.ChestTimer.Start;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.fitnessapp.Men.Men3;
import com.example.user.fitnessapp.R;

import io.github.krtkush.lineartimer.LinearTimer;
import io.github.krtkush.lineartimer.LinearTimerView;

public class ChestStart6 extends AppCompatActivity implements LinearTimer.TimerListener {
    CountDownTimer countDownTimer;
    LinearTimer ChestTimers6;
    TextView Chestviews6;
    ImageView Chestinfos6;
    TextView chestbacks6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chest_start6);

        Chestviews6= (TextView) findViewById(R.id.Chestviews6);
        LinearTimerView linearTimerView = (LinearTimerView) findViewById(R.id.ChestTimers6);

        long duration = 10 * 2000;

        ChestTimers6 = new LinearTimer.Builder()
                .linearTimerView(linearTimerView)
                .duration(duration)
                .timerListener(this)
                .getCountUpdate(LinearTimer.COUNT_DOWN_TIMER, 1000)
                .build();


        Chestinfos6=(ImageView)findViewById(R.id.Chestinfos6);
        Chestinfos6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        chestbacks6=(TextView) findViewById(R.id.chestbacks6);
        chestbacks6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        countDownTimer = new CountDownTimer(21000,  1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                Chestviews6.setText("" + millisUntilFinished/1000 );
                try {
                    ChestTimers6.startTimer();
                } catch (IllegalStateException e) {
                }


            }

            @Override
            public void onFinish() {
                Intent intent = new Intent(ChestStart6.this, Men3.class);
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
