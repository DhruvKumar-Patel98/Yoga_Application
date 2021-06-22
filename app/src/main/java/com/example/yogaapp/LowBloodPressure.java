package com.example.yogaapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LowBloodPressure extends Navigation_bar implements AsanaInformationDetails{

    private ArrayList<ListViewItem> listViewItems;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        LayoutInflater inflater=LayoutInflater.from(this);
        View v=inflater.inflate(R.layout.activity_heart_problem,null,false);
        drawerLayout.addView(v,0);


        ArrayList<ListViewItem> listViewItems=new ArrayList<>();
        listViewItems.add(new ListViewItem(R.drawable.uttanasana,"Uttanasana",uttanasana));
        listViewItems.add(new ListViewItem(R.drawable.adhomukhasvanasana,"Adhomukhasvanasana",adhoMukhaSvanasana));
        listViewItems.add(new ListViewItem(R.drawable.pawanamuktasana,"Pavanmuktasana",pawanamuktasana));
        listViewItems.add(new ListViewItem(R.drawable.shishuasana,"Shishuasana",shishuasana));
        listViewItems.add(new ListViewItem(R.drawable.sarvangasana,"Sarvangasana",sarvangasan));
        listViewItems.add(new ListViewItem(R.drawable.matsyasana,"Matsyasana",matsyasan));
        listViewItems.add(new ListViewItem(R.drawable.kapal_bhati,"Kapal Bhati Pranayam",kapalBhatiPranayama));
        listViewItems.add(new ListViewItem(R.drawable.bhastrika_pranayama,"Bhastrika Pranayam",bhastrikaPranayama));
        listViewItems.add(new ListViewItem(R.drawable.suryabhedi_pranayama,"Suryabhedi Pranayam",suryabhediPranayama));



        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(this);
        adapter=new Adapter(listViewItems);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemViewCacheSize(20);
        recyclerView.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
        adapter.setOnItemClickListener(new Adapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(LowBloodPressure.this, AsanDetails.class);
                intent.putExtra("Example Item", listViewItems.get(position));
                startActivity(intent);
            }
        });

    }
}