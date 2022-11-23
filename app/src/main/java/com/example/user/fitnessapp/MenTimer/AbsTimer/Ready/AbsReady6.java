package com.example.user.fitnessapp.MenTimer.AbsTimer.Ready;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.fitnessapp.MenTimer.AbsTimer.PopupInfo.Info1.Info6.PopupInfo6;
import com.example.user.fitnessapp.MenTimer.AbsTimer.Start.AbsStart6;
import com.example.user.fitnessapp.MenTimer.MenuExit.Absmenu.MenuExit6;
import com.example.user.fitnessapp.R;

import io.github.krtkush.lineartimer.LinearTimer;
import io.github.krtkush.lineartimer.LinearTimerView;

public class AbsReady6 extends AppCompatActivity implements LinearTimer.TimerListener {
    CountDownTimer countDownready6;
    LinearTimer linearready6;
    TextView textready6;
    ImageView textinfo6;
    TextView textskip6;
    TextView textback6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abs_ready6);

        textready6 = (TextView) findViewById(R.id.textready6);
        final LinearTimerView linearTimerView = (LinearTimerView) findViewById(R.id.LinearReady6);
        long duration = 10 * 510;


        linearready6 = new LinearTimer.Builder()
                .linearTimerView(linearTimerView)
                .duration(duration)
                .timerListener(this)
                .getCountUpdate(LinearTimer.COUNT_DOWN_TIMER, 1000)
                .build();



        textinfo6 = (ImageView) findViewById(R.id.info6);
        textinfo6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countDownready6.cancel();
                linearready6.pauseTimer();
                Intent intent = new Intent(AbsReady6.this, PopupInfo6.class);
                startActivity(intent);
            }
        });


        textskip6 = (TextView) findViewById(R.id.skip6);
        textskip6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countDownready6.cancel();
                linearready6.pauseTimer();
                Intent intent = new Intent(AbsReady6.this, AbsStart6.class);
                startActivity(intent);
            }
        });


        textback6=(TextView)findViewById(R.id.armback6);
        textback6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countDownready6.cancel();
                linearready6.pauseTimer();
                Intent intent = new Intent(AbsReady6.this, MenuExit6.class);
                startActivity(intent);


            }
        });

        countDownready6 = new CountDownTimer(6000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                textready6.setText("" + millisUntilFinished / 1000);
                try {
                    linearready6.startTimer();
                } catch (IllegalStateException e) {
                }
            }
            @Override
            public void onFinish() {
                Intent intent = new Intent(AbsReady6.this, AbsStart6.class);
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
