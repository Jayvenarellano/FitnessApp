package com.example.user.fitnessapp.Popup;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.user.fitnessapp.Men.Men1;
import com.example.user.fitnessapp.MenTimer.AbsTimer.Ready.AbsReady1;
import com.example.user.fitnessapp.R;

public class Popupwindow7 extends AppCompatActivity {
    TextView textView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popupwindow7);

        button = (Button) findViewById(R.id.AbsStart7);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.9),(int)(height*.7));

        textView=(TextView)findViewById(R.id.textV1);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Popupwindow7.this, Men1.class);
                startActivity(intent);


            }
        });
        textView=(TextView)findViewById(R.id.arrow13);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Popupwindow7.this, Popupwindow6.class);
                startActivity(intent);
            }
        });
        textView=(TextView)findViewById(R.id.arrow14);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Popupwindow7.this, Popupwindow8.class);
                startActivity(intent);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Popupwindow7.this, AbsReady1.class);
                startActivity(intent);

            }
        });

    }

    @Override
    public void onBackPressed(){

    }
}
