package com.example.azer.movielist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ListView listView;
    String urlimage;
    CustomAdapter adapter;
    ArrayList<Movie>movieArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=(ListView)findViewById(R.id.list_viewitem);
        fetchdata();


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(MainActivity.this,DetailsActivity.class);
                intent.putExtra("urlofimage",movieArrayList.get(i).getThumbonailurl());
                startActivity(intent);
            }
        });


    }

    void fetchdata(){
        String url="http://api.androidhive.info/json/movies.json";
        movieArrayList = new ArrayList<>();
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0; i<response.length();i++){
                    try {
                        JSONObject jsonObject=response.getJSONObject(i);;
                        Movie movie=new Movie();
                        movie.setTitle(jsonObject.getString("title"));
                        movie.setRating(jsonObject.getDouble("rating"));
                        movie.setYear(jsonObject.getInt("releaseYear"));
                        movie.setThumbonailurl(jsonObject.getString("image"));
                        Log.d("movietitle",jsonObject.getString("title"));
                        movieArrayList.add(movie);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapter=new CustomAdapter(getApplicationContext(),movieArrayList);
                listView.setAdapter(adapter);
                adapter.notifyDataSetChanged();




            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        AppController.getInstance().addToRequestQueue(jsonArrayRequest);
    }
}
