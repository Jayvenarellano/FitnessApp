package com.example.user.fitnessapp.MenTimer.ChestTimer.Ready;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.fitnessapp.MenTimer.ChestTimer.ChestInfo.A1.ChestInfoA5;
import com.example.user.fitnessapp.MenTimer.ChestTimer.ChestMenu.A1.ChestMenu5;
import com.example.user.fitnessapp.MenTimer.ChestTimer.Start.ChestStart5;
import com.example.user.fitnessapp.R;

import io.github.krtkush.lineartimer.LinearTimer;
import io.github.krtkush.lineartimer.LinearTimerView;

public class ChestReady5 extends AppCompatActivity implements LinearTimer.TimerListener {
    CountDownTimer countDownTimer;
    LinearTimer chestTimer5;
    TextView chestView5;
    TextView chestback5;
    TextView chestskip5;
    ImageView chestinfo5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chest_ready5);

        chestView5= (TextView) findViewById(R.id.chestView5);
        final LinearTimerView linearTimerView = (LinearTimerView) findViewById(R.id.chestTimer5);


        chestback5=(TextView)findViewById(R.id.chestback5);
        chestback5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countDownTimer.cancel();
                chestTimer5.pauseTimer();
                Intent intent = new Intent(ChestReady5.this, ChestMenu5.class);
                startActivity(intent);


            }
        });

        chestskip5=(TextView)findViewById(R.id.chestskip5);
        chestskip5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countDownTimer.cancel();
                chestTimer5.pauseTimer();
                Intent intent = new Intent(ChestReady5.this, ChestStart5.class);
                startActivity(intent);

            }
        });



        chestinfo5=(ImageView)findViewById(R.id.chestinfo5);
        chestinfo5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countDownTimer.cancel();
                chestTimer5.pauseTimer();
                Intent intent = new Intent(ChestReady5.this, ChestInfoA5.class);
                startActivity(intent);

            }
        });

        long duration = 10 * 510;

        chestTimer5 = new LinearTimer.Builder()
                .linearTimerView(linearTimerView)
                .duration(duration)
                .timerListener(this)
                .getCountUpdate(LinearTimer.COUNT_DOWN_TIMER, 1000)
                .build();




        countDownTimer = new CountDownTimer(6000,  1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                chestView5.setText("" + millisUntilFinished/1000 );
                try {
                    chestTimer5.startTimer();
                } catch (IllegalStateException e) {


                }


            }

            @Override
            public void onFinish() {
                Intent intent = new Intent(ChestReady5.this, ChestStart5.class);
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
