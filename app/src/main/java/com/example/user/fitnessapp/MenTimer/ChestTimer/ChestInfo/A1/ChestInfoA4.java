package com.example.user.fitnessapp.MenTimer.ChestTimer.ChestInfo.A1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;

import com.example.user.fitnessapp.MenTimer.ChestTimer.Ready.ChestReady4;
import com.example.user.fitnessapp.R;

public class ChestInfoA4 extends AppCompatActivity {
    ImageView Closechests4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chest_info_a4);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.9),(int)(height*.6));
        Closechests4=(ImageView)findViewById(R.id.Closechests4);
        Closechests4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChestInfoA4.this, ChestReady4.class);
                startActivity(intent);
            }
        });
    }
}
