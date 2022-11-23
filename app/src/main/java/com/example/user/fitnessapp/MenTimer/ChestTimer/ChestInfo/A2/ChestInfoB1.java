package com.example.user.fitnessapp.MenTimer.ChestTimer.ChestInfo.A2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;

import com.example.user.fitnessapp.MenTimer.ChestTimer.Start.ChestStart1;
import com.example.user.fitnessapp.R;

public class ChestInfoB1 extends AppCompatActivity {
    ImageView Closechest1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chest_info_b1);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.9),(int)(height*.6));
        Closechest1=(ImageView)findViewById(R.id.Closechest1);
        Closechest1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChestInfoB1.this, ChestStart1.class);
                startActivity(intent);
            }
        });
    }
}
