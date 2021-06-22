package com.example.yogaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.widget.ImageView;
import android.widget.TextView;

public class AsanDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asan_details);

        Intent intent=getIntent();
        ListViewItem listViewItem=intent.getParcelableExtra("Example Item");

        int imageRes=listViewItem.getmImageResource();
        String line1=listViewItem.getText1();
        CharSequence line2=listViewItem.getText2();

        ImageView imageView=findViewById(R.id.asanImage);
        imageView.setImageResource(imageRes);

        TextView textView1=findViewById(R.id.asanName);
        textView1.setText(line1);

        TextView textView2=findViewById(R.id.asanSteps);
        textView2.setText(line2);
    }
}