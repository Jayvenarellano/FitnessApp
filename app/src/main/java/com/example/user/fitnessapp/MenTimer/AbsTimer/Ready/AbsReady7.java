package com.example.user.fitnessapp.MenTimer.AbsTimer.Ready;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.fitnessapp.MenTimer.AbsTimer.PopupInfo.Info1.Info7.PopupInfo7;
import com.example.user.fitnessapp.MenTimer.AbsTimer.Start.AbsStart7;
import com.example.user.fitnessapp.MenTimer.MenuExit.Absmenu.MenuExit7;
import com.example.user.fitnessapp.R;

import io.github.krtkush.lineartimer.LinearTimer;
import io.github.krtkush.lineartimer.LinearTimerView;

public class AbsReady7 extends AppCompatActivity implements LinearTimer.TimerListener {
    CountDownTimer countDownready7;
    LinearTimer linearready7;
    TextView textready7;
    ImageView textinfo7;
    TextView textskip7;
    TextView textback7;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abs_ready7);

        textready7 = (TextView) findViewById(R.id.textready7);
        final LinearTimerView linearTimerView = (LinearTimerView) findViewById(R.id.LinearReady7);
        long duration = 10 * 510;


        linearready7 = new LinearTimer.Builder()
                .linearTimerView(linearTimerView)
                .duration(duration)
                .timerListener(this)
                .getCountUpdate(LinearTimer.COUNT_DOWN_TIMER, 1000)
                .build();

        textinfo7 = (ImageView) findViewById(R.id.info7);
        textinfo7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countDownready7.cancel();
                linearready7.pauseTimer();
                Intent intent = new Intent(AbsReady7.this, PopupInfo7.class);
                startActivity(intent);
            }
        });


        textskip7 = (TextView) findViewById(R.id.skip7);
        textskip7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countDownready7.cancel();
                linearready7.pauseTimer();
                Intent intent = new Intent(AbsReady7.this, AbsStart7.class);
                startActivity(intent);
            }
        });

        textback7=(TextView)findViewById(R.id.armback7);
        textback7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countDownready7.cancel();
                linearready7.pauseTimer();
                Intent intent = new Intent(AbsReady7.this, MenuExit7.class);
                startActivity(intent);


            }
        });


        countDownready7 = new CountDownTimer(6000, 1000) {
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
                Intent intent = new Intent(AbsReady7.this, AbsStart7.class);
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
