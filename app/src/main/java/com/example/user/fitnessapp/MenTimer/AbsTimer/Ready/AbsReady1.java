package com.example.user.fitnessapp.MenTimer.AbsTimer.Ready;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.fitnessapp.MenTimer.AbsTimer.PopupInfo.Info1.PopupInfo1;
import com.example.user.fitnessapp.MenTimer.AbsTimer.Start.AbsStart1;
import com.example.user.fitnessapp.MenTimer.MenuExit.Absmenu.MenuExit1;
import com.example.user.fitnessapp.R;

import io.github.krtkush.lineartimer.LinearTimer;
import io.github.krtkush.lineartimer.LinearTimerView;

public class AbsReady1 extends AppCompatActivity implements LinearTimer.TimerListener {
    CountDownTimer countDownTimer;
    LinearTimer linearTimer;
    TextView textview;
    TextView textback1;
    TextView textskip1;
    ImageView textinfo1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abs_ready1);

        textview= (TextView) findViewById(R.id.textView);
        final LinearTimerView linearTimerView = (LinearTimerView) findViewById(R.id.linearTimer);


        textback1=(TextView)findViewById(R.id.armback1);
        textback1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countDownTimer.cancel();
                linearTimer.pauseTimer();
                Intent intent = new Intent(AbsReady1.this, MenuExit1.class);
                startActivity(intent);


            }
        });

        textskip1=(TextView)findViewById(R.id.skip1);
        textskip1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countDownTimer.cancel();
                linearTimer.pauseTimer();
                Intent intent = new Intent(AbsReady1.this, AbsStart1.class);
                startActivity(intent);

            }
        });



        textinfo1=(ImageView)findViewById(R.id.info1);
        textinfo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countDownTimer.cancel();
                linearTimer.pauseTimer();
                Intent intent = new Intent(AbsReady1.this, PopupInfo1.class);
                startActivity(intent);

            }
        });

        long duration = 10 * 510;

        linearTimer = new LinearTimer.Builder()
                .linearTimerView(linearTimerView)
                .duration(duration)
                .timerListener(this)
                .getCountUpdate(LinearTimer.COUNT_DOWN_TIMER, 1000)
                .build();




        countDownTimer = new CountDownTimer(6000,  1000) {
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
                Intent intent = new Intent(AbsReady1.this, AbsStart1.class);
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
