package com.example.user.fitnessapp.MenTimer.AbsTimer.Ready;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.fitnessapp.MenTimer.AbsTimer.PopupInfo.Info1.Info4.PopupInfo4;
import com.example.user.fitnessapp.MenTimer.AbsTimer.Start.AbsStart4;
import com.example.user.fitnessapp.MenTimer.MenuExit.Absmenu.MenuExit4;
import com.example.user.fitnessapp.R;

import io.github.krtkush.lineartimer.LinearTimer;
import io.github.krtkush.lineartimer.LinearTimerView;

public class AbsReady4 extends AppCompatActivity implements LinearTimer.TimerListener {
    CountDownTimer countDownready4;
    LinearTimer linearready4;
    TextView textready4;
    ImageView textinfo4;
    TextView textskip4;
    TextView textback4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abs_ready4);

        textready4 = (TextView) findViewById(R.id.textready4);
        final LinearTimerView linearTimerView = (LinearTimerView) findViewById(R.id.LinearReady4);
        long duration = 10 * 510;


        linearready4 = new LinearTimer.Builder()
                .linearTimerView(linearTimerView)
                .duration(duration)
                .timerListener(this)
                .getCountUpdate(LinearTimer.COUNT_DOWN_TIMER, 1000)
                .build();


        textinfo4 = (ImageView) findViewById(R.id.info4);
        textinfo4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countDownready4.cancel();
                linearready4.pauseTimer();
                Intent intent = new Intent(AbsReady4.this, PopupInfo4.class);
                startActivity(intent);
            }
        });


        textskip4 = (TextView) findViewById(R.id.skip4);
        textskip4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countDownready4.cancel();
                linearready4.pauseTimer();
                Intent intent = new Intent(AbsReady4.this, AbsStart4.class);
                startActivity(intent);
            }
        });

        textback4=(TextView)findViewById(R.id.armback4);
        textback4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countDownready4.cancel();
                linearready4.pauseTimer();
                Intent intent = new Intent(AbsReady4.this, MenuExit4.class);
                startActivity(intent);


            }
        });


        countDownready4 = new CountDownTimer(6000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                textready4.setText("" + millisUntilFinished / 1000);
                try {
                    linearready4.startTimer();
                } catch (IllegalStateException e) {
                }
            }
            @Override
            public void onFinish() {
                Intent intent = new Intent(AbsReady4.this, AbsStart4.class);
                startActivity(intent);
            }
        }.start();


    }
    @Override
    public void onBackPressed(){
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
