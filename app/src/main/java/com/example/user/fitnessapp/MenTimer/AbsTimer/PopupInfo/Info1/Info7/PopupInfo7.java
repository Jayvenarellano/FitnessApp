package com.example.user.fitnessapp.MenTimer.AbsTimer.PopupInfo.Info1.Info7;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;

import com.example.user.fitnessapp.MenTimer.AbsTimer.Ready.AbsReady7;
import com.example.user.fitnessapp.R;

public class PopupInfo7 extends AppCompatActivity {
    ImageView close7;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_info7);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.9),(int)(height*.6));

        close7=(ImageView)findViewById(R.id.close7);
        close7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PopupInfo7.this, AbsReady7.class);
                startActivity(intent);
            }
        });
    }
}
