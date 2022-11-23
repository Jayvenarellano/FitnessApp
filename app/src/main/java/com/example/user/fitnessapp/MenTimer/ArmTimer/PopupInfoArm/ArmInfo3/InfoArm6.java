package com.example.user.fitnessapp.MenTimer.ArmTimer.PopupInfoArm.ArmInfo3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;

import com.example.user.fitnessapp.MenTimer.ArmTimer.Start.ArmStart3;
import com.example.user.fitnessapp.R;

public class InfoArm6 extends AppCompatActivity {
    ImageView closeArm6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_arm6);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.9),(int)(height*.6));


        closeArm6=(ImageView)findViewById(R.id.closeArm6);
        closeArm6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InfoArm6.this, ArmStart3.class);
                startActivity(intent);
            }
        });
    }
}
