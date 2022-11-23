package com.example.user.fitnessapp.MenTimer.AbsTimer.PopupInfo.Info1.Info6;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;

import com.example.user.fitnessapp.MenTimer.AbsTimer.Ready.AbsReady6;
import com.example.user.fitnessapp.R;

public class PopupInfo6 extends AppCompatActivity {
    ImageView close6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_info6);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.9),(int)(height*.6));

        close6=(ImageView)findViewById(R.id.close6);
        close6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PopupInfo6.this, AbsReady6.class);
                startActivity(intent);
            }
        });
    }
}
