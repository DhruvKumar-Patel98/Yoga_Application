package com.example.yogaapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;

public class RelaxationMusic extends Navigation_bar {

   ImageButton play,pause;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater inflater=LayoutInflater.from(this);
        View v=inflater.inflate(R.layout.activity_relaxation_music,null,false);
        drawerLayout.addView(v,0);

        play=findViewById(R.id.playMusic);
        pause=findViewById(R.id.pauseMusic);



    }

    public void playMusic(View view) {
        Intent svc=new Intent(this, BackgroundSoundService.class);
        startService(svc);
    }

    public void pauseMusic(View view) {
        Intent svc=new Intent(this, BackgroundSoundService.class);
        stopService(svc);
    }
}