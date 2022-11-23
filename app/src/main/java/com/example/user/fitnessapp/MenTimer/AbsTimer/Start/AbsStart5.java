package com.example.user.fitnessapp.MenTimer.AbsTimer.Start;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.fitnessapp.MenTimer.AbsTimer.PopupInfo.Info1.Info5.PopupInfoA5;
import com.example.user.fitnessapp.MenTimer.AbsTimer.Ready.AbsReady6;
import com.example.user.fitnessapp.MenTimer.MenuExit.Absmenu.MenuExita5;
import com.example.user.fitnessapp.R;

import io.github.krtkush.lineartimer.LinearTimer;
import io.github.krtkush.lineartimer.LinearTimerView;

public class AbsStart5 extends AppCompatActivity implements LinearTimer.TimerListener {
    CountDownTimer countDownready5;
    LinearTimer linearstart5;
    TextView textready5;
    ImageView textinfoa5;
    TextView textbackA5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abs_start5);

        textready5 = (TextView) findViewById(R.id.textreadya5);
        final LinearTimerView linearTimerView = (LinearTimerView) findViewById(R.id.linearTimera5);
        long duration = 10 * 2000;


        linearstart5 = new LinearTimer.Builder()
                .linearTimerView(linearTimerView)
                .duration(duration)
                .timerListener(this)
                .getCountUpdate(LinearTimer.COUNT_DOWN_TIMER, 1000)
                .build();


        textinfoa5=(ImageView)findViewById(R.id.infoA5);
        textinfoa5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countDownready5.cancel();
                linearstart5.pauseTimer();
                Intent intent = new Intent(AbsStart5.this, PopupInfoA5.class);
                startActivity(intent);

            }
        });


        textbackA5=(TextView) findViewById(R.id.armbackA5);
        textbackA5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AbsStart5.this, MenuExita5.class);
                startActivity(intent);
            }
        });



        countDownready5 = new CountDownTimer(21000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                textready5.setText("" + millisUntilFinished / 1000);
                try {
                    linearstart5.startTimer();
                } catch (IllegalStateException e) {
                }
            }
            @Override
            public void onFinish() {
                Intent intent = new Intent(AbsStart5.this, AbsReady6.class);
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
