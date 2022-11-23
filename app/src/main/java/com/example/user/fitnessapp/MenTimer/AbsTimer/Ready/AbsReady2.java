package com.example.user.fitnessapp.MenTimer.AbsTimer.Ready;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.fitnessapp.MenTimer.AbsTimer.PopupInfo.Info1.Info2.PopupInfo2;
import com.example.user.fitnessapp.MenTimer.AbsTimer.Start.AbsStart2;
import com.example.user.fitnessapp.MenTimer.MenuExit.Absmenu.MenuExit2;
import com.example.user.fitnessapp.R;

import io.github.krtkush.lineartimer.LinearTimer;
import io.github.krtkush.lineartimer.LinearTimerView;

public class AbsReady2 extends AppCompatActivity implements LinearTimer.TimerListener {
    CountDownTimer countDownready2;
    LinearTimer linearready2;
    TextView textready2;
    TextView textskip2;
    TextView textback2;
    ImageView textinfo2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abs_ready2);

        textready2 = (TextView) findViewById(R.id.textready2);
        final LinearTimerView linearTimerView = (LinearTimerView) findViewById(R.id.LinearReady2);

        long duration = 10 * 610;

        linearready2 = new LinearTimer.Builder()
                .linearTimerView(linearTimerView)
                .duration(duration)
                .timerListener(this)
                .getCountUpdate(LinearTimer.COUNT_DOWN_TIMER, 1000)
                .build();


        textinfo2 = (ImageView) findViewById(R.id.info2);
        textinfo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countDownready2.cancel();
                linearready2.pauseTimer();
                Intent intent = new Intent(AbsReady2.this, PopupInfo2.class);
                startActivity(intent);
            }
        });

        textskip2 = (TextView) findViewById(R.id.skip2);
        textskip2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countDownready2.cancel();
                linearready2.pauseTimer();
                Intent intent = new Intent(AbsReady2.this, AbsStart2.class);
                startActivity(intent);


            }
        });

        textback2=(TextView)findViewById(R.id.armback2);
        textback2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countDownready2.cancel();
                linearready2.pauseTimer();
                Intent intent = new Intent(AbsReady2.this, MenuExit2.class);
                startActivity(intent);


            }
        });




        countDownready2 = new CountDownTimer(5000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                textready2.setText("" + millisUntilFinished / 1000);
                try {
                    linearready2.startTimer();
                } catch (IllegalStateException e) {


                }


            }

            @Override
            public void onFinish() {
                Intent intent = new Intent(AbsReady2.this, AbsStart2.class);
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
