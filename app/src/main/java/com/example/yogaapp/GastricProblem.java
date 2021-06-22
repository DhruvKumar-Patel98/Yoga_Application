package com.example.yogaapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class GastricProblem extends Navigation_bar implements AsanaInformationDetails {

    private ArrayList<ListViewItem> listViewItems;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        LayoutInflater inflater=LayoutInflater.from(this);
        View v=inflater.inflate(R.layout.activity_gastric_problem,null,false);
        drawerLayout.addView(v,0);


        ArrayList<ListViewItem> listViewItems=new ArrayList<>();
        listViewItems.add(new ListViewItem(R.drawable.kapal_bhati,"Kapal Bhati",kapalBhatiPranayama));
        listViewItems.add(new ListViewItem(R.drawable.halasana,"Halasana",halasana));
        listViewItems.add(new ListViewItem(R.drawable.ustra_asana,"Ushtrasana",ustrasana));
        listViewItems.add(new ListViewItem(R.drawable.bhastrika_pranayama,"Bhastrika Pranayam",bhastrikaPranayama));
        listViewItems.add(new ListViewItem(R.drawable.vajrasana,"Vajrasana",vajrasan));
        listViewItems.add(new ListViewItem(R.drawable.pawanamuktasana,"Pawanamuktasana",pawanamuktasana));
        listViewItems.add(new ListViewItem(R.drawable.anulom_ilom,"Anulom Vilom",anulomVilom));




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
                Intent intent = new Intent(GastricProblem.this, AsanDetails.class);
                intent.putExtra("Example Item", listViewItems.get(position));
                startActivity(intent);
            }
        });

    }
}