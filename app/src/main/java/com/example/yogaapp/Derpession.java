package com.example.yogaapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Derpession extends Navigation_bar implements AsanaInformationDetails {
    private ArrayList<ListViewItem> listViewItems;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        LayoutInflater inflater=LayoutInflater.from(this);
        View v=inflater.inflate(R.layout.activity_derpession,null,false);
        drawerLayout.addView(v,0);

      /*  String suptaBadhakoasana=  ("This pose instills a deep state of relaxation and is an amazing posture for stretching the hip and groin region. It is exactly like the Badha Konasana or Butterfly pose. The only difference is that it is done lying on the back. It can be done by beginners and experts and is generally done towards the end of a yoga session before meditation.\n\nHow to do Supta Baddha Konasana\n"+"Start with a sitting dandasana, i.e., sit with your spine erect and legs stretched out, feet touching each other and toes pointing upwards"+"\n");
        SpannableString ss = new SpannableString(suptaBadhakoasana);
        Typeface typefaceSpan = Typeface.create(ResourcesCompat.getFont(this, R.font.andika), Typeface.BOLD);
        StyleSpan boldSpan = new StyleSpan(Typeface.BOLD);
        StyleSpan italicSpan = new StyleSpan(Typeface.ITALIC);
        StyleSpan boldItalicSpan = new StyleSpan(Typeface.BOLD_ITALIC);
        ss.setSpan(new TypefaceSpan(typefaceSpan), 0, 342, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

       */


        ArrayList<ListViewItem> listViewItems=new ArrayList<>();
       listViewItems.add(new ListViewItem(R.drawable.dhanurasana,"Dhanurasana",dhanurasana));
        listViewItems.add(new ListViewItem(R.drawable.matsyasana,"Matsyasana",matsyasan));
        listViewItems.add(new ListViewItem(R.drawable.janu_shirsasana,"Janu Shirsasana",januShirsasana));
        listViewItems.add(new ListViewItem(R.drawable.sethubandha,"Sethubandhasana",sethubandha));
        listViewItems.add(new ListViewItem(R.drawable.marjariasana,"Marjariasana",marjariasana));
        listViewItems.add(new ListViewItem(R.drawable.paschimotan_asana,"Paschimottanasana",paschimotasan));
        listViewItems.add(new ListViewItem(R.drawable.hastapadasana,"Hastapadasana",hastapadasana));
        listViewItems.add(new ListViewItem(R.drawable.adhomukhasvanasana,"AdhoMukhaSvamasana",adhoMukhaSvanasana));
        listViewItems.add(new ListViewItem(R.drawable.sirsasana,"Sirsasana",sirsasana));
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
                Intent intent = new Intent(Derpession.this, AsanDetails.class);
                intent.putExtra("Example Item", listViewItems.get(position));
                startActivity(intent);
            }
        });

    }
}