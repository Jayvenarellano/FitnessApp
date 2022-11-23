package com.example.user.fitnessapp.MenTimer.ArmTimer.PopupInfoArm.ArmInfo1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;

import com.example.user.fitnessapp.MenTimer.ArmTimer.Ready.ArmReady1;
import com.example.user.fitnessapp.R;

public class InfoArm1 extends AppCompatActivity {
    ImageView closeArm1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_arm1);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.9),(int)(height*.6));


        closeArm1=(ImageView)findViewById(R.id.closeArm1);
        closeArm1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InfoArm1.this, ArmReady1.class);
                startActivity(intent);
            }
        });
    }
}
