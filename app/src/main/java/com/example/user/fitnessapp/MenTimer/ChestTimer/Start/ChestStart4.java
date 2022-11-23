package com.example.user.fitnessapp.MenTimer.ChestTimer.Start;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.fitnessapp.MenTimer.ChestTimer.Ready.ChestReady5;
import com.example.user.fitnessapp.R;

import io.github.krtkush.lineartimer.LinearTimer;
import io.github.krtkush.lineartimer.LinearTimerView;

public class ChestStart4 extends AppCompatActivity implements LinearTimer.TimerListener {
    CountDownTimer countDownTimer;
    LinearTimer ChestTimers4;
    TextView Chestviews4;
    ImageView Chestinfos4;
    TextView chestbacks4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chest_start4);

        Chestviews4= (TextView) findViewById(R.id.Chestviews4);
        LinearTimerView linearTimerView = (LinearTimerView) findViewById(R.id.ChestTimers4);

        long duration = 10 * 2000;

        ChestTimers4 = new LinearTimer.Builder()
                .linearTimerView(linearTimerView)
                .duration(duration)
                .timerListener(this)
                .getCountUpdate(LinearTimer.COUNT_DOWN_TIMER, 1000)
                .build();


        Chestinfos4=(ImageView)findViewById(R.id.Chestinfos4);
        Chestinfos4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        chestbacks4=(TextView) findViewById(R.id.chestbacks4);
        chestbacks4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        countDownTimer = new CountDownTimer(21000,  1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                Chestviews4.setText("" + millisUntilFinished/1000 );
                try {
                    ChestTimers4.startTimer();
                } catch (IllegalStateException e) {
                }


            }

            @Override
            public void onFinish() {
                Intent intent = new Intent(ChestStart4.this, ChestReady5.class);
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
