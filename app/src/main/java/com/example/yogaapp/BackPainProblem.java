package com.example.yogaapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BackPainProblem extends Navigation_bar implements AsanaInformationDetails {
    private ArrayList<ListViewItem> listViewItems;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater inflater=LayoutInflater.from(this);
        View v=inflater.inflate(R.layout.activity_back_pain_problem,null,false);
        drawerLayout.addView(v,0);

        ArrayList<ListViewItem> listViewItems=new ArrayList<>();
        listViewItems.add(new ListViewItem(R.drawable.marjariasana,"Marjariasana",marjariasana));
        listViewItems.add(new ListViewItem(R.drawable.adhomukhasvanasana,"Adho Mukha Svanasana",adhoMukhaSvanasana));
        listViewItems.add(new ListViewItem(R.drawable.salamba_bhujangasana,"Salamba Bhujangasana",salambaBhujangasana));
        listViewItems.add(new ListViewItem(R.drawable.basic_yoga_poses_slideshow,"Bhujangasana",bhujangasan));
        listViewItems.add(new ListViewItem(R.drawable._salabhasana,"Salabhasana",salabhasana));
        listViewItems.add(new ListViewItem(R.drawable.sethubandha,"Sethu Bandhasana",sethubandha));
        listViewItems.add(new ListViewItem(R.drawable.ardha_matsyendrasana,"Ardha matsyendrasana",ardhamatsyendrasana));
        listViewItems.add(new ListViewItem(R.drawable.supta_matsyendrasana,"Supta Matsyendrasana",suptaMatsyendrasana));
        listViewItems.add(new ListViewItem(R.drawable.balasana,"Balasana",balasana));



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
                Intent intent = new Intent(BackPainProblem.this, AsanDetails.class);
                intent.putExtra("Example Item", listViewItems.get(position));
                startActivity(intent);
            }
        });

    }
}