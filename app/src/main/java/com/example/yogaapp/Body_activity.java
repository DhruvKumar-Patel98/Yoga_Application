package com.example.yogaapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Body_activity extends Navigation_bar implements AsanaInformationDetails{
    private ArrayList<ListViewItem> listViewItems;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LayoutInflater inflater=LayoutInflater.from(this);
        View v=inflater.inflate(R.layout.activity_body_activity,null,false);
        drawerLayout.addView(v,0);

        ArrayList<ListViewItem> listViewItems=new ArrayList<>();
        listViewItems.add(new ListViewItem(R.drawable.basic_yoga_poses_slideshow,"Bhujangasana",bhujangasan));
        listViewItems.add(new ListViewItem(R.drawable.parivrttautkatasana,"Parivrtta Utkatasana",parivrtaUtkasana));
        listViewItems.add(new ListViewItem(R.drawable.sarvangasana,"Sarvangasana",sarvangasan));
        listViewItems.add(new ListViewItem(R.drawable.marjariasana,"Marjariasana",marjariasana));
        listViewItems.add(new ListViewItem(R.drawable.vyaghrasana,"Vyaghrasana",vyaghrasana));
        listViewItems.add(new ListViewItem(R.drawable.gomukhasana,"Gomukhasana",gomukhasana));
        listViewItems.add(new ListViewItem(R.drawable.gomukhasana_garudasana,"Gomukhasana Garudasana",gomukhasanaGarudasana));
        listViewItems.add(new ListViewItem(R.drawable.ardha_matsyendrasana,"Ardha matsyendrasana",ardhamatsyendrasana));
        listViewItems.add(new ListViewItem(R.drawable.prasarita_padottanasana,"Prasarita Padottanasana",prasaritaPadottanasana));
        listViewItems.add(new ListViewItem(R.drawable.chakrasana,"Chakrasana",chakrasana));
        listViewItems.add(new ListViewItem(R.drawable.adhomukhasvanasana,"Adho Mukha Svanasana",adhoMukhaSvanasana));



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
                Intent intent = new Intent(Body_activity.this, AsanDetails.class);
                intent.putExtra("Example Item", listViewItems.get(position));
                startActivity(intent);
            }
        });

    }
}