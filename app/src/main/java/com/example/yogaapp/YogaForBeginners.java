package com.example.yogaapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class YogaForBeginners extends Navigation_bar implements AsanaInformationDetails {

    private ArrayList<ListViewItem> listViewItems;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater inflater=LayoutInflater.from(this);
        View v=inflater.inflate(R.layout.activity_yoga_for_beginners,null,false);
        drawerLayout.addView(v,0);

       /* CardView card1=findViewById(R.id.cardView1);
        CardView card2=findViewById(R.id.cardView2);
        CardView card3=findViewById(R.id.cardView3);

        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent easyYoga=new Intent(YogaForBeginners.this,EasyYoga.class);
                startActivity(easyYoga);
            }
        });
        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent normalYoga=new Intent(YogaForBeginners.this,NormalYoga.class);
                startActivity(normalYoga);
            }
        });
        card3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent hardYoga=new Intent(YogaForBeginners.this,HardYoga.class);
                startActivity(hardYoga);
            }
        });

        */

        ArrayList<ListViewItem> listViewItems=new ArrayList<>();
        listViewItems.add(new ListViewItem(R.drawable.tadasana,"Tadasana",tadasana));
        listViewItems.add(new ListViewItem(R.drawable.virabhadrasana,"Virabhadrasana",chaturangadandasana));
        listViewItems.add(new ListViewItem(R.drawable.trikonasana,"Trikonasana",trikonasana));
        listViewItems.add(new ListViewItem(R.drawable.chaturangadandasana,"Chaturangadandasana",chaturangadandasana));
        listViewItems.add(new ListViewItem(R.drawable.urdhva_mukha_svanasana,"Urdhva Mukha Svanasana",urdhvaMukhaSvanasana));
        listViewItems.add(new ListViewItem(R.drawable.vriksh_asana,"Vriksh Asana",vrikshasana));
        listViewItems.add(new ListViewItem(R.drawable.natarajasana,"Natarajasana",natarajasana));
        listViewItems.add(new ListViewItem(R.drawable.ardha_kapotasana,"Ardha Kapotasanar",ardhaKapotasanar));
        listViewItems.add(new ListViewItem(R.drawable.paschimotan_asana,"Trikonasana",trikonasana));


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
                Intent intent = new Intent(YogaForBeginners.this, AsanDetails.class);
                intent.putExtra("Example Item", listViewItems.get(position));
                startActivity(intent);
            }
        });


    }
}