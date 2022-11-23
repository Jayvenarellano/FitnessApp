package com.example.user.fitnessapp.MenTimer.AbsTimer.Ready;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.fitnessapp.MenTimer.AbsTimer.PopupInfo.Info1.Info3.PopupInfo3;
import com.example.user.fitnessapp.MenTimer.AbsTimer.Start.AbsStart3;
import com.example.user.fitnessapp.MenTimer.MenuExit.Absmenu.MenuExit3;
import com.example.user.fitnessapp.R;

import io.github.krtkush.lineartimer.LinearTimer;
import io.github.krtkush.lineartimer.LinearTimerView;

public class AbsReady3 extends AppCompatActivity implements LinearTimer.TimerListener{
    CountDownTimer countDownready3;
    LinearTimer linearready3;
    TextView textready3;
    ImageView textinfo3;
    TextView textskip3;
    TextView textback3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abs_ready3);

        textready3 = (TextView) findViewById(R.id.textready3);
        final LinearTimerView linearTimerView = (LinearTimerView) findViewById(R.id.LinearReady3);
        long duration = 10 * 510;

        linearready3 = new LinearTimer.Builder()
                .linearTimerView(linearTimerView)
                .duration(duration)
                .timerListener(this)
                .getCountUpdate(LinearTimer.COUNT_DOWN_TIMER, 1000)
                .build();

        textinfo3 = (ImageView) findViewById(R.id.info3);
        textinfo3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countDownready3.cancel();
                linearready3.pauseTimer();
                Intent intent = new Intent(AbsReady3.this, PopupInfo3.class);
                startActivity(intent);
            }
        });


        textskip3 = (TextView) findViewById(R.id.skip3);
        textskip3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countDownready3.cancel();
                linearready3.pauseTimer();
                Intent intent = new Intent(AbsReady3.this, AbsStart3.class);
                startActivity(intent);
            }
        });

        textback3=(TextView)findViewById(R.id.armback3);
        textback3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countDownready3.cancel();
                linearready3.pauseTimer();
                Intent intent = new Intent(AbsReady3.this, MenuExit3.class);
                startActivity(intent);


            }
        });


        countDownready3 = new CountDownTimer(6000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                textready3.setText("" + millisUntilFinished / 1000);
                try {
                    linearready3.startTimer();
                } catch (IllegalStateException e) {
                }
            }
            @Override
            public void onFinish() {
                Intent intent = new Intent(AbsReady3.this, AbsStart3.class);
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
