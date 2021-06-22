package com.example.yogaapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class BloodPressureProblrm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood_pressure_problrm);

        CardView lbp=findViewById(R.id.lbpCard);
        CardView hbp=findViewById(R.id.hbpCard);
        lbp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(BloodPressureProblrm.this,LowBloodPressure.class);
                startActivity(intent);
            }
        });
        hbp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(BloodPressureProblrm.this,HighBloodPressure.class);
                startActivity(i);
            }
        });
    }
}