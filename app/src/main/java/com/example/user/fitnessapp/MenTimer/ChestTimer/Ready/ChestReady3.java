package com.example.user.fitnessapp.MenTimer.ChestTimer.Ready;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.fitnessapp.MenTimer.ChestTimer.ChestInfo.A1.ChestInfoA3;
import com.example.user.fitnessapp.MenTimer.ChestTimer.ChestMenu.A1.ChestMenu3;
import com.example.user.fitnessapp.MenTimer.ChestTimer.Start.ChestStart3;
import com.example.user.fitnessapp.R;

import io.github.krtkush.lineartimer.LinearTimer;
import io.github.krtkush.lineartimer.LinearTimerView;

public class ChestReady3 extends AppCompatActivity implements LinearTimer.TimerListener {
    CountDownTimer countDownTimer;
    LinearTimer chestTimer3;
    TextView chestView3;
    TextView chestback3;
    TextView chestskip3;
    ImageView chestinfo3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chest_ready3);

        chestView3= (TextView) findViewById(R.id.chestView3);
        final LinearTimerView linearTimerView = (LinearTimerView) findViewById(R.id.chestTimer3);


        chestback3=(TextView)findViewById(R.id.chestback3);
        chestback3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countDownTimer.cancel();
                chestTimer3.pauseTimer();
                Intent intent = new Intent(ChestReady3.this, ChestMenu3.class);
                startActivity(intent);



            }
        });

        chestskip3=(TextView)findViewById(R.id.chestskip3);
        chestskip3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countDownTimer.cancel();
                chestTimer3.pauseTimer();
                Intent intent = new Intent(ChestReady3.this, ChestStart3.class);
                startActivity(intent);

            }
        });



        chestinfo3=(ImageView)findViewById(R.id.chestinfo3);
        chestinfo3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countDownTimer.cancel();
                chestTimer3.pauseTimer();
                Intent intent = new Intent(ChestReady3.this, ChestInfoA3.class);
                startActivity(intent);

            }
        });

        long duration = 10 * 510;

        chestTimer3 = new LinearTimer.Builder()
                .linearTimerView(linearTimerView)
                .duration(duration)
                .timerListener(this)
                .getCountUpdate(LinearTimer.COUNT_DOWN_TIMER, 1000)
                .build();




        countDownTimer = new CountDownTimer(6000,  1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                chestView3.setText("" + millisUntilFinished/1000 );
                try {
                    chestTimer3.startTimer();
                } catch (IllegalStateException e) {


                }


            }

            @Override
            public void onFinish() {
                Intent intent = new Intent(ChestReady3.this, ChestStart3.class);
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
