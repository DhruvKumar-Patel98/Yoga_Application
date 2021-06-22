package com.example.yogaapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Weight_loose extends Navigation_bar implements AsanaInformationDetails {

    private ArrayList<ListViewItem> listViewItems;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private Adapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater inflater=LayoutInflater.from(this);
        View v=inflater.inflate(R.layout.activity_weight_loose,null,false);
        drawerLayout.addView(v,0);





        ArrayList<ListViewItem> listViewItems=new ArrayList<>();
          listViewItems.add(new ListViewItem(R.drawable.adhomukhasvanasana,"Adho Mukha Svanasana",adhoMukhaSvanasana));
        listViewItems.add(new ListViewItem(R.drawable.chaturangadandasana,"Chaturanga Dandasana",chaturangadandasana));
         listViewItems.add(new ListViewItem(R.drawable.dhanurasana,"Dhanurasana",dhanurasana));
        listViewItems.add(new ListViewItem(R.drawable.parivrttautkatasana,"Parivrtta Utkatasana",parivrtaUtkasana));
        listViewItems.add(new ListViewItem(R.drawable.sarvangasana,"Sarvangasana",sarvangasan));
        listViewItems.add(new ListViewItem(R.drawable.sethubandha,"Setu Bandhasana",sethubandha));
        listViewItems.add(new ListViewItem(R.drawable.suptabaddhaonasana,"Supta Badhakonasana",suptaBadhakoasana));
        listViewItems.add(new ListViewItem(R.drawable.suryanamaskara,"Surya Namaskar",suryanamaskara));
        listViewItems.add(new ListViewItem(R.drawable.trikonasana,"Trikonasana",trikonasana));
        listViewItems.add(new ListViewItem(R.drawable.virabhadrasana,"Veerabhadrasana ",virabhadrasana));

        recyclerView=findViewById(R.id.recyclerView);
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
                Intent intent = new Intent(Weight_loose.this, AsanDetails.class);
                intent.putExtra("Example Item", listViewItems.get(position));
                startActivity(intent);
            }
        });


    }


}