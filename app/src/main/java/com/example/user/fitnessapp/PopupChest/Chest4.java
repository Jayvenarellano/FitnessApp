package com.example.user.fitnessapp.PopupChest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.user.fitnessapp.Men.Men2;
import com.example.user.fitnessapp.MenTimer.ArmTimer.Ready.ArmReady1;
import com.example.user.fitnessapp.R;

public class Chest4 extends AppCompatActivity {
    TextView textView;
    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chest4);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.9),(int)(height*.7));

        textView=(TextView)findViewById(R.id.textV1);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Chest4.this, Men2.class);
                startActivity(intent);


            }
        });

        textView=(TextView)findViewById(R.id.chestw7);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Chest4.this, Chest3.class);
                startActivity(intent);
            }
        });
        textView=(TextView)findViewById(R.id.chestw8);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Chest4.this, Chest5.class);
                startActivity(intent);
            }
        });

        button1=(Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Chest4.this, ArmReady1.class);
                startActivity(intent);

            }
        });
    }
    @Override
    public void onBackPressed(){

    }
}
