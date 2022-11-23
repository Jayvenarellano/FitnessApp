package com.example.user.fitnessapp.MenTimer.AbsTimer.Ready;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.fitnessapp.MenTimer.AbsTimer.PopupInfo.Info1.Info8.PopupInfo8;
import com.example.user.fitnessapp.MenTimer.AbsTimer.Start.AbsStart8;
import com.example.user.fitnessapp.MenTimer.MenuExit.Absmenu.MenuExit8;
import com.example.user.fitnessapp.R;

import io.github.krtkush.lineartimer.LinearTimer;
import io.github.krtkush.lineartimer.LinearTimerView;

public class AbsReady8 extends AppCompatActivity implements LinearTimer.TimerListener {
    CountDownTimer countDownready8;
    LinearTimer linearready8;
    TextView textready8;
    ImageView textinfo8;
    TextView textskip8;
    TextView textback8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abs_ready8);

        textready8 = (TextView) findViewById(R.id.textready8);
        final LinearTimerView linearTimerView = (LinearTimerView) findViewById(R.id.LinearReady8);
        long duration = 10 * 510;


        linearready8 = new LinearTimer.Builder()
                .linearTimerView(linearTimerView)
                .duration(duration)
                .timerListener(this)
                .getCountUpdate(LinearTimer.COUNT_DOWN_TIMER, 1000)
                .build();

        textinfo8 = (ImageView) findViewById(R.id.info8);
        textinfo8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countDownready8.cancel();
                linearready8.pauseTimer();
                Intent intent = new Intent(AbsReady8.this, PopupInfo8.class);
                startActivity(intent);
            }
        });


        textskip8 = (TextView) findViewById(R.id.skip8);
        textskip8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countDownready8.cancel();
                linearready8.pauseTimer();
                Intent intent = new Intent(AbsReady8.this, AbsStart8.class);
                startActivity(intent);
            }
        });


        textback8=(TextView)findViewById(R.id.armback8);
        textback8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countDownready8.cancel();
                linearready8.pauseTimer();
                Intent intent = new Intent(AbsReady8.this, MenuExit8.class);
                startActivity(intent);


            }
        });


        countDownready8 = new CountDownTimer(6000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                textready8.setText("" + millisUntilFinished / 1000);
                try {
                    linearready8.startTimer();
                } catch (IllegalStateException e) {
                }
            }
            @Override
            public void onFinish() {
                Intent intent = new Intent(AbsReady8.this, AbsStart8.class);
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
