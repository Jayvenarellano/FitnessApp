package com.example.user.fitnessapp.MenTimer.AbsTimer.Start;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.fitnessapp.MenTimer.AbsTimer.PopupInfo.Info1.PopupInfoA1;
import com.example.user.fitnessapp.MenTimer.AbsTimer.Ready.AbsReady2;
import com.example.user.fitnessapp.MenTimer.MenuExit.Absmenu.Menuexita1;
import com.example.user.fitnessapp.R;

import io.github.krtkush.lineartimer.LinearTimer;
import io.github.krtkush.lineartimer.LinearTimerView;

public class AbsStart1 extends AppCompatActivity implements LinearTimer.TimerListener {
    CountDownTimer countDownTimer;
    LinearTimer linearTimer;
    TextView textview;
    ImageView textinfoA1;
    TextView armbackA1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abs_start1);

        textview= (TextView) findViewById(R.id.textView1);
        LinearTimerView linearTimerView = (LinearTimerView) findViewById(R.id.linearTimer1);

        long duration = 10 * 2000;

        linearTimer = new LinearTimer.Builder()
                .linearTimerView(linearTimerView)
                .duration(duration)
                .timerListener(this)
                .getCountUpdate(LinearTimer.COUNT_DOWN_TIMER, 1000)
                .build();


        textinfoA1=(ImageView)findViewById(R.id.infoA1);
        textinfoA1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countDownTimer.cancel();
                linearTimer.pauseTimer();
                Intent intent = new Intent(AbsStart1.this, PopupInfoA1.class);
                startActivity(intent);

            }
        });

        armbackA1=(TextView) findViewById(R.id.armbacka1);
        armbackA1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countDownTimer.cancel();
                linearTimer.pauseTimer();
                Intent intent = new Intent(AbsStart1.this, Menuexita1.class);
                startActivity(intent);
            }
        });

        countDownTimer = new CountDownTimer(21000,  1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                textview.setText("" + millisUntilFinished/1000 );
                try {
                    linearTimer.startTimer();
                } catch (IllegalStateException e) {
                }


            }

            @Override
            public void onFinish() {
                Intent intent = new Intent(AbsStart1.this, AbsReady2.class);
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
