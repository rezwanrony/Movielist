package com.example.azer.movielist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class DetailsActivity extends AppCompatActivity {
ImageView img_moviefront;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        img_moviefront=(ImageView)findViewById(R.id.img_moviefront);
        String url=getIntent().getStringExtra("urlofimage");
        Glide.with(getApplicationContext()).load(url).centerCrop().into(img_moviefront);
    }
}
