package com.example.user.fitnessapp.MenTimer.AbsTimer.PopupInfo.Info1.Info2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;

import com.example.user.fitnessapp.MenTimer.AbsTimer.Ready.AbsReady2;
import com.example.user.fitnessapp.R;

public class PopupInfo2 extends AppCompatActivity {
    ImageView close2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_info2);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.9),(int)(height*.6));
        close2=(ImageView)findViewById(R.id.close2);
        close2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PopupInfo2.this, AbsReady2.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onBackPressed(){
    }

}
