package com.example.user.fitnessapp.MenTimer.AbsTimer.Start;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.fitnessapp.MenTimer.AbsTimer.PopupInfo.Info1.Info7.PopupInfoA7;
import com.example.user.fitnessapp.MenTimer.AbsTimer.Ready.AbsReady8;
import com.example.user.fitnessapp.MenTimer.MenuExit.Absmenu.MenuExita7;
import com.example.user.fitnessapp.R;

import io.github.krtkush.lineartimer.LinearTimer;
import io.github.krtkush.lineartimer.LinearTimerView;

public class AbsStart7 extends AppCompatActivity implements LinearTimer.TimerListener {
    CountDownTimer countDownready7;
    LinearTimer linearready7;
    TextView textready7;
    ImageView textinfo7;
    TextView textskip7;
    TextView textbackA7;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abs_start7);

        textready7 = (TextView) findViewById(R.id.heelstarta1);
        final LinearTimerView linearTimerView = (LinearTimerView) findViewById(R.id.linearTimera7);
        long duration = 10 * 2000;


        linearready7 = new LinearTimer.Builder()
                .linearTimerView(linearTimerView)
                .duration(duration)
                .timerListener(this)
                .getCountUpdate(LinearTimer.COUNT_DOWN_TIMER, 1000)
                .build();


        textinfo7 = (ImageView) findViewById(R.id.infoA7);
        textinfo7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AbsStart7.this, PopupInfoA7.class);
                startActivity(intent);
            }
        });

        textbackA7=(TextView) findViewById(R.id.armbackA7  );
        textbackA7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AbsStart7.this, MenuExita7.class);
                startActivity(intent);
            }
        });


        countDownready7 = new CountDownTimer(21000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                textready7.setText("" + millisUntilFinished / 1000);
                try {
                    linearready7.startTimer();
                } catch (IllegalStateException e) {
                }
            }
            @Override
            public void onFinish() {
                Intent intent = new Intent(AbsStart7.this, AbsReady8.class);
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
