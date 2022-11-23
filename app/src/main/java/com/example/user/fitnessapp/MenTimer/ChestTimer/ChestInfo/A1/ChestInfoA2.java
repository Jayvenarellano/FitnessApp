package com.example.user.fitnessapp.MenTimer.ChestTimer.ChestInfo.A1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;

import com.example.user.fitnessapp.MenTimer.ChestTimer.Ready.ChestReady2;
import com.example.user.fitnessapp.R;

public class ChestInfoA2 extends AppCompatActivity {
    ImageView Closechests2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chest_info_a2);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.9),(int)(height*.6));
        Closechests2=(ImageView)findViewById(R.id.Closechests2);
        Closechests2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChestInfoA2.this, ChestReady2.class);
                startActivity(intent);
            }
        });
    }
}
