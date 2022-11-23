package com.example.user.fitnessapp.MenTimer.ChestTimer.Ready;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.fitnessapp.MenTimer.ChestTimer.ChestInfo.A1.ChestInfoA2;
import com.example.user.fitnessapp.MenTimer.ChestTimer.ChestMenu.A1.ChestMenu2;
import com.example.user.fitnessapp.MenTimer.ChestTimer.Start.ChestStart2;
import com.example.user.fitnessapp.R;

import io.github.krtkush.lineartimer.LinearTimer;
import io.github.krtkush.lineartimer.LinearTimerView;

public class ChestReady2 extends AppCompatActivity implements LinearTimer.TimerListener {
    CountDownTimer countDownTimer;
    LinearTimer chestTimer2;
    TextView chestView2;
    TextView chestback2;
    TextView chestskip2;
    ImageView chestinfo2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chest_ready2);

        chestView2= (TextView) findViewById(R.id.chestView2);
        final LinearTimerView linearTimerView = (LinearTimerView) findViewById(R.id.chestTimer2);


        chestback2=(TextView)findViewById(R.id.chestback2);
        chestback2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countDownTimer.cancel();
                chestTimer2.pauseTimer();
                Intent intent = new Intent(ChestReady2.this, ChestMenu2.class);
                startActivity(intent);


            }
        });

        chestskip2=(TextView)findViewById(R.id.chestskip2);
        chestskip2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countDownTimer.cancel();
                chestTimer2.pauseTimer();
                Intent intent = new Intent(ChestReady2.this, ChestStart2.class);
                startActivity(intent);

            }
        });



        chestinfo2=(ImageView)findViewById(R.id.chestinfo2);
        chestinfo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countDownTimer.cancel();
                chestTimer2.pauseTimer();
                Intent intent = new Intent(ChestReady2.this, ChestInfoA2.class);
                startActivity(intent);

            }
        });

        long duration = 10 * 510;

        chestTimer2 = new LinearTimer.Builder()
                .linearTimerView(linearTimerView)
                .duration(duration)
                .timerListener(this)
                .getCountUpdate(LinearTimer.COUNT_DOWN_TIMER, 1000)
                .build();




        countDownTimer = new CountDownTimer(6000,  1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                chestView2.setText("" + millisUntilFinished/1000 );
                try {
                    chestTimer2.startTimer();
                } catch (IllegalStateException e) {


                }


            }

            @Override
            public void onFinish() {
                Intent intent = new Intent(ChestReady2.this, ChestStart2.class);
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
