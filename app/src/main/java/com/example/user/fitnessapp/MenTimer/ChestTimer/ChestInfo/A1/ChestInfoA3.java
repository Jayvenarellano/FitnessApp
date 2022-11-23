package com.example.user.fitnessapp.MenTimer.ChestTimer.ChestInfo.A1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;

import com.example.user.fitnessapp.MenTimer.ChestTimer.Ready.ChestReady3;
import com.example.user.fitnessapp.R;

public class ChestInfoA3 extends AppCompatActivity {
    ImageView Closechests3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chest_info_a3);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.9),(int)(height*.6));
        Closechests3=(ImageView)findViewById(R.id.Closechests3);
        Closechests3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChestInfoA3.this, ChestReady3.class);
                startActivity(intent);
            }
        });
    }
}
