package com.example.user.fitnessapp.MenTimer.AbsTimer.Start;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.fitnessapp.Men.Men2;
import com.example.user.fitnessapp.MenTimer.AbsTimer.PopupInfo.Info1.Info8.PopupInfoA8;
import com.example.user.fitnessapp.MenTimer.MenuExit.Absmenu.MenuExita8;
import com.example.user.fitnessapp.R;

import io.github.krtkush.lineartimer.LinearTimer;
import io.github.krtkush.lineartimer.LinearTimerView;

public class AbsStart8 extends AppCompatActivity implements LinearTimer.TimerListener {
    CountDownTimer countDownreadya8;
    LinearTimer linearreadya8;
    TextView textreadya8;
    ImageView textinfoa8;
    TextView textskipa8;
    TextView textbackA8;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abs_start8);

        textreadya8 = (TextView) findViewById(R.id.cobrastart1);
        final LinearTimerView linearTimerView = (LinearTimerView) findViewById(R.id.linearTimera8);
        long duration = 10 * 2000;


        linearreadya8 = new LinearTimer.Builder()
                .linearTimerView(linearTimerView)
                .duration(duration)
                .timerListener(this)
                .getCountUpdate(LinearTimer.COUNT_DOWN_TIMER, 1000)
                .build();


        textinfoa8 = (ImageView) findViewById(R.id.infoA8);
        textinfoa8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AbsStart8.this, PopupInfoA8.class);
                startActivity(intent);
            }
        });

        textbackA8=(TextView) findViewById(R.id.armbackA8  );
        textbackA8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AbsStart8.this, MenuExita8.class);
                startActivity(intent);
            }
        });

        countDownreadya8 = new CountDownTimer(21000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                textreadya8.setText("" + millisUntilFinished / 1000);
                try {
                    linearreadya8.startTimer();
                } catch (IllegalStateException e) {
                }
            }
            @Override
            public void onFinish() {
                Intent intent = new Intent(AbsStart8.this, Men2.class);
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
