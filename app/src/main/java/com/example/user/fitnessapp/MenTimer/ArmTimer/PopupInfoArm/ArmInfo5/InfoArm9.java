package com.example.user.fitnessapp.MenTimer.ArmTimer.PopupInfoArm.ArmInfo5;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;

import com.example.user.fitnessapp.MenTimer.ArmTimer.Ready.ArmReady5;
import com.example.user.fitnessapp.R;

public class InfoArm9 extends AppCompatActivity {
    ImageView closeArm9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_arm9);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.9),(int)(height*.6));


        closeArm9=(ImageView)findViewById(R.id.closeArm9);
        closeArm9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InfoArm9.this, ArmReady5.class);
                startActivity(intent);
            }
        });
    }
}
