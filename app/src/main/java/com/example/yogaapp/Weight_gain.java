package com.example.yogaapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.SpannedString;
import android.text.style.TypefaceSpan;
import android.view.LayoutInflater;
import android.view.View;

import java.util.ArrayList;

public class Weight_gain extends Navigation_bar implements AsanaInformationDetails{
    private ArrayList<ListViewItem> listViewItems;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater inflater=LayoutInflater.from(this);
        View v=inflater.inflate(R.layout.activity_weight_gain,null,false);
        drawerLayout.addView(v,0);

        ArrayList<ListViewItem> listViewItems=new ArrayList<>();
        listViewItems.add(new ListViewItem(R.drawable.suptabaddhaonasana,"Supta Baddha Konasana",suptaBadhakoasana));
        listViewItems.add(new ListViewItem(R.drawable.vajrasana,"Vajrasana",vajrasan));
        listViewItems.add(new ListViewItem(R.drawable.sarvangasana,"Sarvangasana",sarvangasan));
        listViewItems.add(new ListViewItem(R.drawable.basic_yoga_poses_slideshow,"Bhujangasana",bhujangasan));
        listViewItems.add(new ListViewItem(R.drawable.matsyasana,"Matsyasana",matsyasan));






        recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(this);
        adapter=new Adapter(listViewItems);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new Adapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(Weight_gain.this, AsanDetails.class);
                intent.putExtra("Example Item", listViewItems.get(position));
                startActivity(intent);
            }
        });

    }
}