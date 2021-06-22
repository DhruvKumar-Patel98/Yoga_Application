package com.example.yogaapp;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;

public class ListViewItem implements Parcelable {
    private int mImageResource;
    private String mtext1;
    private Spanned mText2;


    public ListViewItem(int ImageResource, String text1, Spanned text2){
        mImageResource=ImageResource;
        mtext1=text1;
        mText2=text2;
    }

    protected ListViewItem(Parcel in) {
        mImageResource = in.readInt();
        mtext1 = in.readString();
        mText2=(SpannableString)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(in);
    }

    public static final Creator<ListViewItem> CREATOR = new Creator<ListViewItem>() {
        @Override
        public ListViewItem createFromParcel(Parcel in) {
            return new ListViewItem(in);
        }

        @Override
        public ListViewItem[] newArray(int size) {
            return new ListViewItem[size];
        }
    };


    public int getmImageResource(){
        return mImageResource;
    }
    public String getText1(){
        return mtext1;
    }
    public CharSequence getText2(){
        return mText2;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mImageResource);
        dest.writeString(mtext1);
        TextUtils.writeToParcel(mText2,dest,flags);
    }
}
