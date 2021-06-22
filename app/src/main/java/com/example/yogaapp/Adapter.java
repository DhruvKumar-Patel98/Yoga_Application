package com.example.yogaapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ListViewHolder>  {
    private OnItemClickListener mListener;
    private  ArrayList<ListViewItem> mlistViewItems;


    public interface OnItemClickListener {
        void onItemClick(int position);
    }
    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener=listener;
    }

    public static class ListViewHolder extends RecyclerView.ViewHolder{
        public ImageView mImageView;
        public TextView mTextView1;
        public TextView mTextview2;
        
        public ListViewHolder(final View itemView,final OnItemClickListener listener) {
            super(itemView);
            mImageView=itemView.findViewById(R.id.imageView1);
            mTextView1=itemView.findViewById(R.id.textViewName);
            mTextview2=itemView.findViewById(R.id.textViewDetails);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }
                }
            });

        }
    }

    public Adapter(ArrayList<ListViewItem>listViewItems){
    mlistViewItems=listViewItems;

    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_view_design,parent,false);
        ListViewHolder lvh=new ListViewHolder(v,mListener);
        return lvh;

    }


    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {


        ListViewItem currentItem=mlistViewItems.get(position);
        holder.mImageView.setImageResource(currentItem.getmImageResource());
        holder.mTextView1.setText(currentItem.getText1());
        holder.mTextview2.setText(currentItem.getText2());

    }

    @Override
    public int getItemCount() {
        return mlistViewItems.size();
    }
}
