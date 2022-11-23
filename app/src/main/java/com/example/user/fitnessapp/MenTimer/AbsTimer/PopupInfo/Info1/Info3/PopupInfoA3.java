package com.example.user.fitnessapp.MenTimer.AbsTimer.PopupInfo.Info1.Info3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;

import com.example.user.fitnessapp.MenTimer.AbsTimer.Start.AbsStart3;
import com.example.user.fitnessapp.R;

public class PopupInfoA3 extends AppCompatActivity {
    ImageView closeA3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_info_a3);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.9),(int)(height*.6));


        closeA3=(ImageView)findViewById(R.id.closeA3);
        closeA3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PopupInfoA3.this, AbsStart3.class);
                startActivity(intent);
            }
        });
    }
}
