package com.example.yogaapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.GridLayout;
import android.widget.Switch;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;

public class MainActivity extends Navigation_bar {

    GridLayout mainGridLayout;
    public static MediaPlayer relaxMusic;
    Switch musicSwitch;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        LayoutInflater inflater=LayoutInflater.from(this);
        View v=inflater.inflate(R.layout.activity_main,null,false);
        drawerLayout.addView(v,0);


        mainGridLayout=(GridLayout)findViewById(R.id.mainGridLayout);
        setStringEvent(mainGridLayout);

        //Dialog box
        SharedPreferences prefs=getSharedPreferences("prefs",MODE_PRIVATE);
        boolean firstStart=prefs.getBoolean("firstStart",true);
        if(firstStart) {
            showStartDialog();
        }

        Intent svc=new Intent(this, BackgroundSoundService.class);
        startService(svc);

    }

    //dialog box
    private void showStartDialog(){
        new AlertDialog.Builder(this)
                .setTitle("Important Note")
                .setMessage("Use this App in day to day life")
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .create().show();

        SharedPreferences prefs=getSharedPreferences("prefs",MODE_PRIVATE);
        SharedPreferences.Editor editor=prefs.edit();
        editor.putBoolean("firstStart",false);
        editor.apply();
    }


    //gridlayout
    private void setStringEvent(GridLayout mainGridLayout) {
        for(int i=0;i<mainGridLayout.getChildCount();i++)
        {
            CardView cardView=(CardView)mainGridLayout.getChildAt(i);
            final int finalI=i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(finalI==0)
                    {
                        Intent intent=new Intent(MainActivity.this, Pranayam.class);
                        startActivity(intent);

                    }
                    else if (finalI==1)
                    {
                        Intent intent=new Intent(MainActivity.this,Body_activity.class);
                        startActivity(intent);
                    }
                    else if (finalI==2)
                    {
                        Intent intent=new Intent(MainActivity.this,Weight_loose.class);
                        startActivity(intent);
                    }
                    else if (finalI==3)
                    {
                        Intent intent=new Intent(MainActivity.this,Weight_gain.class);
                        startActivity(intent);
                    }
                    else if (finalI==4)
                    {
                        Intent intent=new Intent(MainActivity.this,Increase_height.class);
                        startActivity(intent);
                    }
                    else if (finalI==5)
                    {
                        Intent intent=new Intent(MainActivity.this,Weight_loose.class);
                        startActivity(intent);
                    }
                    else if (finalI==6)
                    {
                        Intent intent=new Intent(MainActivity.this,HeartProblem.class);
                        startActivity(intent);
                    }
                    else if (finalI==7)
                    {
                        Intent intent=new Intent(MainActivity.this,BloodPressureProblrm.class);
                        startActivity(intent);
                    }
                    else if (finalI==8)
                    {
                        Intent intent=new Intent(MainActivity.this,Asthama.class);
                        startActivity(intent);
                    }
                    else if (finalI==9)
                    {
                        Intent intent=new Intent(MainActivity.this,FaceYoga.class);
                        startActivity(intent);
                    }
                    else if (finalI==10)
                    {
                        Intent intent=new Intent(MainActivity.this,Headache.class);
                        startActivity(intent);
                    }
                    else if (finalI==11)
                    {
                        Intent intent=new Intent(MainActivity.this,BackPainProblem.class);
                        startActivity(intent);
                    }
                    else if (finalI==12)
                    {
                        Intent intent=new Intent(MainActivity.this,GastricProblem.class);
                        startActivity(intent);
                    }
                    else if (finalI==13)
                    {
                        Intent intent=new Intent(MainActivity.this,BoostImmunity.class);
                        startActivity(intent);
                    }
                    else if (finalI==14)
                    {
                        Intent intent=new Intent(MainActivity.this,Derpession.class);
                        startActivity(intent);
                    }

                }
            });
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        Intent svc=new Intent(this, BackgroundSoundService.class);
        if (this.isFinishing()){
            stopService(svc);
        }




    }

}