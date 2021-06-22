package com.example.yogaapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Headache extends Navigation_bar implements AsanaInformationDetails{

    private ArrayList<ListViewItem> listViewItems;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        LayoutInflater inflater=LayoutInflater.from(this);
        View v=inflater.inflate(R.layout.activity_headache,null,false);
        drawerLayout.addView(v,0);


        ArrayList<ListViewItem> listViewItems=new ArrayList<>();
        listViewItems.add(new ListViewItem(R.drawable.hastapadasana,"Hastapadasana",hastapadasana));
        listViewItems.add(new ListViewItem(R.drawable.sethubandha,"Sethubandhasana",sethubandha));
        listViewItems.add(new ListViewItem(R.drawable.shishuasana,"Shishuasana",shishuasana));
        listViewItems.add(new ListViewItem(R.drawable.marjariasana,"Marjariasana",marjariasana));
        listViewItems.add(new ListViewItem(R.drawable.paschimotan_asana,"Paschimotanasana",paschimotasan));
        listViewItems.add(new ListViewItem(R.drawable.adhomukhasvanasana,"Adhomukhasvanasana",adhoMukhaSvanasana));
        listViewItems.add(new ListViewItem(R.drawable.padmasana,"Padmasana",padmasana));
        listViewItems.add(new ListViewItem(R.drawable.savasana,"Shavasana",savasana));



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
                Intent intent = new Intent(Headache.this, AsanDetails.class);
                intent.putExtra("Example Item", listViewItems.get(position));
                startActivity(intent);
            }
        });

    }
}