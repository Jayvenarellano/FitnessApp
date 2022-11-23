package com.example.user.fitnessapp.MenTimer.AbsTimer.Ready;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.fitnessapp.MenTimer.AbsTimer.PopupInfo.Info1.Info5.PopupInfo5;
import com.example.user.fitnessapp.MenTimer.AbsTimer.Start.AbsStart5;
import com.example.user.fitnessapp.MenTimer.MenuExit.Absmenu.MenuExit5;
import com.example.user.fitnessapp.R;

import io.github.krtkush.lineartimer.LinearTimer;
import io.github.krtkush.lineartimer.LinearTimerView;

public class AbsReady5 extends AppCompatActivity implements LinearTimer.TimerListener {
    CountDownTimer countDownready5;
    LinearTimer linearready5;
    TextView textready5;
    ImageView textinfo5;
    TextView textskip5;
    TextView textback5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abs_ready5);

        textready5 = (TextView) findViewById(R.id.textready5);
        final LinearTimerView linearTimerView = (LinearTimerView) findViewById(R.id.LinearReady5);
        long duration = 10 * 510;


        linearready5 = new LinearTimer.Builder()
                .linearTimerView(linearTimerView)
                .duration(duration)
                .timerListener(this)
                .getCountUpdate(LinearTimer.COUNT_DOWN_TIMER, 1000)
                .build();

        textinfo5 = (ImageView) findViewById(R.id.info5);
        textinfo5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countDownready5.cancel();
                linearready5.pauseTimer();
                Intent intent = new Intent(AbsReady5.this, PopupInfo5.class);
                startActivity(intent);
            }
        });


        textskip5 = (TextView) findViewById(R.id.skip5);
        textskip5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countDownready5.cancel();
                linearready5.pauseTimer();
                Intent intent = new Intent(AbsReady5.this, AbsStart5.class);
                startActivity(intent);
            }
        });

        textback5=(TextView)findViewById(R.id.armback5);
        textback5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countDownready5.cancel();
                linearready5.pauseTimer();
                Intent intent = new Intent(AbsReady5.this, MenuExit5.class);
                startActivity(intent);


            }
        });

        countDownready5 = new CountDownTimer(6000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                textready5.setText("" + millisUntilFinished / 1000);
                try {
                    linearready5.startTimer();
                } catch (IllegalStateException e) {
                }
            }
            @Override
            public void onFinish() {
                Intent intent = new Intent(AbsReady5.this, AbsStart5.class);
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
