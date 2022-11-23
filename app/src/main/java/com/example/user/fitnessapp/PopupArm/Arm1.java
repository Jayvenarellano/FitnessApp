package com.example.user.fitnessapp.PopupArm;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.user.fitnessapp.Men.Men3;
import com.example.user.fitnessapp.MenTimer.ChestTimer.Ready.ChestReady1;
import com.example.user.fitnessapp.R;

public class Arm1 extends AppCompatActivity {
    TextView textView;
    Button Chestbtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arm1);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.9),(int)(height*.7));

        textView=(TextView)findViewById(R.id.textV1);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Arm1.this, Men3.class);
                startActivity(intent);

            }
        });
        textView=(TextView)findViewById(R.id.armarrow2);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Arm1.this, Arm2.class);
                startActivity(intent);


            }
        });

        Chestbtn=(Button) findViewById(R.id.chestbtn);
        Chestbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Arm1.this, ChestReady1.class);
                startActivity(intent);


            }
        });


    }
    @Override
    public void onBackPressed(){

    }
}
