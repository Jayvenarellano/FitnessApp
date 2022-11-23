package com.example.user.fitnessapp.MenTimer.ChestTimer.Start;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.fitnessapp.MenTimer.ChestTimer.Ready.ChestReady6;
import com.example.user.fitnessapp.R;

import io.github.krtkush.lineartimer.LinearTimer;
import io.github.krtkush.lineartimer.LinearTimerView;

public class ChestStart5 extends AppCompatActivity implements LinearTimer.TimerListener {
    CountDownTimer countDownTimer;
    LinearTimer ChestTimers5;
    TextView Chestviews5;
    ImageView Chestinfos5;
    TextView chestbacks5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chest_start5);

        Chestviews5= (TextView) findViewById(R.id.Chestviews5);
        LinearTimerView linearTimerView = (LinearTimerView) findViewById(R.id.ChestTimers5);

        long duration = 10 * 2000;

        ChestTimers5 = new LinearTimer.Builder()
                .linearTimerView(linearTimerView)
                .duration(duration)
                .timerListener(this)
                .getCountUpdate(LinearTimer.COUNT_DOWN_TIMER, 1000)
                .build();


        Chestinfos5=(ImageView)findViewById(R.id.Chestinfos5);
        Chestinfos5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        chestbacks5=(TextView) findViewById(R.id.chestbacks5);
        chestbacks5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        countDownTimer = new CountDownTimer(21000,  1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                Chestviews5.setText("" + millisUntilFinished/1000 );
                try {
                    ChestTimers5.startTimer();
                } catch (IllegalStateException e) {
                }


            }

            @Override
            public void onFinish() {
                Intent intent = new Intent(ChestStart5.this, ChestReady6.class);
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
