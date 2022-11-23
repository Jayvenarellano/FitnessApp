package com.example.user.fitnessapp.MenTimer.ChestTimer.Start;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.fitnessapp.MenTimer.AbsTimer.PopupInfo.Info1.PopupInfoA1;
import com.example.user.fitnessapp.MenTimer.ChestTimer.Ready.ChestReady3;
import com.example.user.fitnessapp.R;

import io.github.krtkush.lineartimer.LinearTimer;
import io.github.krtkush.lineartimer.LinearTimerView;

public class ChestStart2 extends AppCompatActivity implements LinearTimer.TimerListener {
    CountDownTimer countDownTimer;
    LinearTimer ChestTimers2;
    TextView Chestviews2;
    ImageView Chestinfos2;
    TextView chestbacks2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chest_start2);

        Chestviews2= (TextView) findViewById(R.id.Chestviews2);
        LinearTimerView linearTimerView = (LinearTimerView) findViewById(R.id.ChestTimers2);

        long duration = 10 * 2000;

        ChestTimers2 = new LinearTimer.Builder()
                .linearTimerView(linearTimerView)
                .duration(duration)
                .timerListener(this)
                .getCountUpdate(LinearTimer.COUNT_DOWN_TIMER, 1000)
                .build();


        Chestinfos2=(ImageView)findViewById(R.id.Chestinfos2);
        Chestinfos2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countDownTimer.cancel();
                ChestTimers2.pauseTimer();
                Intent intent = new Intent(ChestStart2.this, PopupInfoA1.class);
                startActivity(intent);

            }
        });

        chestbacks2=(TextView) findViewById(R.id.chestbacks2);
        chestbacks2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        countDownTimer = new CountDownTimer(21000,  1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                Chestviews2.setText("" + millisUntilFinished/1000 );
                try {
                    ChestTimers2.startTimer();
                } catch (IllegalStateException e) {
                }


            }

            @Override
            public void onFinish() {
                Intent intent = new Intent(ChestStart2.this, ChestReady3.class);
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
