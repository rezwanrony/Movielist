package com.example.azer.movielist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by azeR on 5/22/2017.
 */

public class CustomAdapter extends BaseAdapter{
    Context context;
    List<Movie>movieList;
    public CustomAdapter(Context context, List<Movie> movieList) {
        this.context = context;
        this.movieList = movieList;
    }

    @Override
    public int getCount() {
        return movieList.size();
    }

    @Override
    public Object getItem(int i) {
        return movieList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup)
    {
        if(view==null){
            view= LayoutInflater.from(context).inflate(R.layout.customlistview,viewGroup,false);
            TextView title=(TextView)view.findViewById(R.id.tvtitle);
            TextView rating=(TextView)view.findViewById(R.id.rating);
            TextView releaseyear=(TextView)view.findViewById(R.id.releaseyear);
            ImageView moviepic=(ImageView)view.findViewById(R.id.img_movie);

            title.setText("Movie title: "+movieList.get(i).getTitle());
            rating.setText("Movie rating: "+String.valueOf(movieList.get(i).getRating()));
            releaseyear.setText("Release year: "+String.valueOf(movieList.get(i).getYear()));

            Glide.with(context).load(movieList.get(i).getThumbonailurl()).centerCrop().into(moviepic);
        }
        return view;
    }
}

