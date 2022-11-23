package com.example.user.fitnessapp.MenTimer.ArmTimer.PopupInfoArm.ArmInfo5;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;

import com.example.user.fitnessapp.MenTimer.ArmTimer.Start.ArmStart5;
import com.example.user.fitnessapp.R;

public class InfoArm10 extends AppCompatActivity {
    ImageView closeArm10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_arm10);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.9),(int)(height*.6));


        closeArm10=(ImageView)findViewById(R.id.closeArm10);
        closeArm10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InfoArm10.this, ArmStart5.class);
                startActivity(intent);
            }
        });
    }
}
