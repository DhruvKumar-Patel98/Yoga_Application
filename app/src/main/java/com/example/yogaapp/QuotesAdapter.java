package com.example.yogaapp;

import android.media.AudioManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class QuotesAdapter  extends RecyclerView.Adapter<QuotesAdapter.ListViewHolder>{
    private Adapter.OnItemClickListener mListener;
    private ArrayList<ListViewQuotes> mlistViewQuotes;


    public static class ListViewHolder extends RecyclerView.ViewHolder{
        public ImageView mImageView;
        public EditText mTextView1;
        public AudioManager.AudioPlaybackCallback audioPlaybackCallback;


        public ListViewHolder(final View itemView) {
            super(itemView);
            mImageView=itemView.findViewById(R.id.imageQuotes);
            mTextView1=itemView.findViewById(R.id.textQuotes);
        }
    }

    public QuotesAdapter(ArrayList<ListViewQuotes>listViewQuotes){
        mlistViewQuotes=listViewQuotes;

    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.quotes_view,parent,false);
        ListViewHolder lvh=new ListViewHolder(v);
        return lvh;

    }


    @Override
    public void onBindViewHolder(@NonNull QuotesAdapter.ListViewHolder holder, int position) {

        ListViewQuotes currentItem=mlistViewQuotes.get(position);
        holder.mImageView.setImageResource(currentItem.getmImageResource());
        holder.mTextView1.setText(currentItem.getText1());


    }

    @Override
    public int getItemCount() {
        return mlistViewQuotes.size();
    }
}


