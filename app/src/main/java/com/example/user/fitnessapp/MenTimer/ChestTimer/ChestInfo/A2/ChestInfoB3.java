package com.example.user.fitnessapp.MenTimer.ChestTimer.ChestInfo.A2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;

import com.example.user.fitnessapp.MenTimer.ChestTimer.Start.ChestStart3;
import com.example.user.fitnessapp.R;

public class ChestInfoB3 extends AppCompatActivity {
    ImageView Closechest3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chest_info_b3);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.9),(int)(height*.6));
        Closechest3=(ImageView)findViewById(R.id.Closechest3);
        Closechest3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChestInfoB3.this, ChestStart3.class);
                startActivity(intent);
            }
        });
    }
}
