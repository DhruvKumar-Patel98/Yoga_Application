package com.example.yogaapp;

public class ListViewQuotes {
    private int mImageResource;
    private String mtext1;



    public ListViewQuotes(int ImageResource, String text1){
        mImageResource=ImageResource;
        mtext1=text1;

    }
    public int getmImageResource(){
        return mImageResource;
    }
    public String getText1(){
        return mtext1;
    }

}
