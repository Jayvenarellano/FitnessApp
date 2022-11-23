package com.example.user.fitnessapp.MenTimer.ChestTimer.Ready;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.fitnessapp.MenTimer.ChestTimer.ChestInfo.A1.ChestInfoA1;
import com.example.user.fitnessapp.MenTimer.ChestTimer.ChestMenu.A1.ChestMenu1;
import com.example.user.fitnessapp.MenTimer.ChestTimer.Start.ChestStart1;
import com.example.user.fitnessapp.R;

import io.github.krtkush.lineartimer.LinearTimer;
import io.github.krtkush.lineartimer.LinearTimerView;

public class ChestReady1 extends AppCompatActivity implements LinearTimer.TimerListener{
    CountDownTimer countDownTimer;
    LinearTimer chestTimer1;
    TextView chestView1;
    TextView chestback1;
    TextView chestskip1;
    ImageView chestinfo1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chest_ready1);

        chestView1= (TextView) findViewById(R.id.chestView1);
        final LinearTimerView linearTimerView = (LinearTimerView) findViewById(R.id.chestTimer1);


        chestback1=(TextView)findViewById(R.id.chestback1);
        chestback1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countDownTimer.cancel();
                chestTimer1.pauseTimer();
                Intent intent = new Intent(ChestReady1.this, ChestMenu1.class);
                startActivity(intent);



            }
        });

        chestskip1=(TextView)findViewById(R.id.chestskip1);
        chestskip1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countDownTimer.cancel();
                chestTimer1.pauseTimer();
                Intent intent = new Intent(ChestReady1.this, ChestStart1.class);
                startActivity(intent);

            }
        });



        chestinfo1=(ImageView)findViewById(R.id.chestinfo1);
        chestinfo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countDownTimer.cancel();
                chestTimer1.pauseTimer();
                Intent intent = new Intent(ChestReady1.this, ChestInfoA1.class);
                startActivity(intent);


            }
        });

        long duration = 10 * 510;

        chestTimer1 = new LinearTimer.Builder()
                .linearTimerView(linearTimerView)
                .duration(duration)
                .timerListener(this)
                .getCountUpdate(LinearTimer.COUNT_DOWN_TIMER, 1000)
                .build();




        countDownTimer = new CountDownTimer(6000,  1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                chestView1.setText("" + millisUntilFinished/1000 );
                try {
                    chestTimer1.startTimer();
                } catch (IllegalStateException e) {


                }


            }

            @Override
            public void onFinish() {
                Intent intent = new Intent(ChestReady1.this, ChestStart1.class);
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
