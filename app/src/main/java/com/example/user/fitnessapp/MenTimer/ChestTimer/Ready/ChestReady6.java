package com.example.user.fitnessapp.MenTimer.ChestTimer.Ready;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.fitnessapp.MenTimer.ChestTimer.ChestInfo.A1.ChestInfoA6;
import com.example.user.fitnessapp.MenTimer.ChestTimer.ChestMenu.A1.ChestMenu6;
import com.example.user.fitnessapp.MenTimer.ChestTimer.Start.ChestStart6;
import com.example.user.fitnessapp.R;

import io.github.krtkush.lineartimer.LinearTimer;
import io.github.krtkush.lineartimer.LinearTimerView;

public class ChestReady6 extends AppCompatActivity implements LinearTimer.TimerListener{
    CountDownTimer countDownTimer;
    LinearTimer chestTimer6;
    TextView chestView6;
    TextView chestback6;
    TextView chestskip6;
    ImageView chestinfo6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chest_ready6);

        chestView6= (TextView) findViewById(R.id.chestView6);
        final LinearTimerView linearTimerView = (LinearTimerView) findViewById(R.id.chestTimer6);


        chestback6=(TextView)findViewById(R.id.chestback6);
        chestback6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countDownTimer.cancel();
                chestTimer6.pauseTimer();
                Intent intent = new Intent(ChestReady6.this, ChestMenu6.class);
                startActivity(intent);


            }
        });

        chestskip6=(TextView)findViewById(R.id.chestskip6);
        chestskip6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countDownTimer.cancel();
                chestTimer6.pauseTimer();
                Intent intent = new Intent(ChestReady6.this, ChestStart6.class);
                startActivity(intent);

            }
        });



        chestinfo6=(ImageView)findViewById(R.id.chestinfo6);
        chestinfo6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countDownTimer.cancel();
                chestTimer6.pauseTimer();
                Intent intent = new Intent(ChestReady6.this, ChestInfoA6.class);
                startActivity(intent);

            }
        });

        long duration = 10 * 510;

        chestTimer6 = new LinearTimer.Builder()
                .linearTimerView(linearTimerView)
                .duration(duration)
                .timerListener(this)
                .getCountUpdate(LinearTimer.COUNT_DOWN_TIMER, 1000)
                .build();




        countDownTimer = new CountDownTimer(6000,  1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                chestView6.setText("" + millisUntilFinished/1000 );
                try {
                    chestTimer6.startTimer();
                } catch (IllegalStateException e) {


                }


            }

            @Override
            public void onFinish() {
                Intent intent = new Intent(ChestReady6.this, ChestStart6.class);
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
