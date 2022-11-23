package com.example.user.fitnessapp.MenTimer.ArmTimer.PopupInfoArm.ArmInfo6;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;

import com.example.user.fitnessapp.MenTimer.ArmTimer.Start.ArmStart6;
import com.example.user.fitnessapp.R;

public class InfoArm12 extends AppCompatActivity {
    ImageView closeArm12;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_arm12);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.9),(int)(height*.6));


        closeArm12=(ImageView)findViewById(R.id.closeArm12);
        closeArm12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InfoArm12.this, ArmStart6.class);
                startActivity(intent);
            }
        });
    }
}
