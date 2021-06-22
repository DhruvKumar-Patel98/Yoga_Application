package com.example.yogaapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HeartProblem extends Navigation_bar implements AsanaInformationDetails{

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
        listViewItems.add(new ListViewItem(R.drawable.tadasana,"Tadasana",tadasana));
        listViewItems.add(new ListViewItem(R.drawable.utthita_hastapadasana,"Utthita Hastapadasana",utthitaHastapadasana));
        listViewItems.add(new ListViewItem(R.drawable.trikonasana,"Trikonasana",trikonasana));
        listViewItems.add(new ListViewItem(R.drawable.virabhadrasana,"Virabhadrasana",virabhadrasana));
        listViewItems.add(new ListViewItem(R.drawable.utkatasana,"Utkatasana",utkatasana));
        listViewItems.add(new ListViewItem(R.drawable.marjariasana,"Marjariasana",marjariasana));
        listViewItems.add(new ListViewItem(R.drawable.adhomukhasvanasana,"Adhomukhosvanasana",adhoMukhaSvanasana));
        listViewItems.add(new ListViewItem(R.drawable.basic_yoga_poses_slideshow,"Bhujangasana",bhujangasan));
        listViewItems.add(new ListViewItem(R.drawable.dhanurasana,"Dhanurasana",dhanurasana));
        listViewItems.add(new ListViewItem(R.drawable.sethubandha,"Setu Bandhasana",sethubandha));
        listViewItems.add(new ListViewItem(R.drawable.salamba_bhujangasana,"Salamba Sarvangasana",sarvangasan));
        listViewItems.add(new ListViewItem(R.drawable.ardha_matsyendrasana,"Ardha Matsyendrasana",ardhamatsyendrasana));
        listViewItems.add(new ListViewItem(R.drawable.paschimotan_asana,"Paschimottanasana",paschimotasan));
        //listViewItems.add(new ListViewItem(R.drawable.ardha_pincha_mayurasana,"Ardha Pincha Mayurasana",ard));



        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(this);
        adapter=new Adapter(listViewItems);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.setItemViewCacheSize(20);
        recyclerView.setDrawingCacheEnabled(true);
        recyclerView.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);


        adapter.setOnItemClickListener(new Adapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(HeartProblem.this, AsanDetails.class);
                intent.putExtra("Example Item", listViewItems.get(position));
                startActivity(intent);
            }
        });

    }
}