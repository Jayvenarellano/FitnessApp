package com.example.user.fitnessapp.MenTimer.ArmTimer.Ready;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.fitnessapp.MenTimer.ArmTimer.ArmMenu.A.ArmA1;
import com.example.user.fitnessapp.MenTimer.ArmTimer.PopupInfoArm.ArmInfo1.InfoArm1;
import com.example.user.fitnessapp.MenTimer.ArmTimer.Start.ArmStart1;
import com.example.user.fitnessapp.R;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import io.github.krtkush.lineartimer.LinearTimer;
import io.github.krtkush.lineartimer.LinearTimerView;

public class ArmReady1 extends AppCompatActivity implements LinearTimer.TimerListener {
    CountDownTimer countDownTimer;
    LinearTimer ArmTimer1;
    TextView Armview1;
    TextView backarm1;
    TextView armskip1;
    ImageView arminfo1;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arm_ready1);


        Armview1 = (TextView) findViewById(R.id.Armview1);
        final LinearTimerView linearTimerView = (LinearTimerView) findViewById(R.id.ArmTimer1);


        backarm1 = (TextView) findViewById(R.id.backarm1);
        backarm1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countDownTimer.cancel();
                ArmTimer1.pauseTimer();
                Intent intent = new Intent(ArmReady1.this, ArmA1.class);
                startActivity(intent);

            }
        });

        armskip1 = (TextView) findViewById(R.id.armskip1);
        armskip1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countDownTimer.cancel();
                ArmTimer1.pauseTimer();
                Intent intent = new Intent(ArmReady1.this, ArmStart1.class);
                startActivity(intent);

            }
        });


        arminfo1 = (ImageView) findViewById(R.id.arminfo1);
        arminfo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countDownTimer.cancel();
                ArmTimer1.pauseTimer();
                Intent intent = new Intent(ArmReady1.this, InfoArm1.class);
                startActivity(intent);

            }
        });

        long duration = 10 * 510;

        ArmTimer1 = new LinearTimer.Builder()
                .linearTimerView(linearTimerView)
                .duration(duration)
                .timerListener(this)
                .getCountUpdate(LinearTimer.COUNT_DOWN_TIMER, 1000)
                .build();


        countDownTimer = new CountDownTimer(6000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                Armview1.setText("" + millisUntilFinished / 1000);
                try {
                    ArmTimer1.startTimer();
                } catch (IllegalStateException e) {


                }


            }

            @Override
            public void onFinish() {
                Intent intent = new Intent(ArmReady1.this, ArmStart1.class);
                startActivity(intent);


            }
        }.start();


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
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

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("ArmReady1 Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}
