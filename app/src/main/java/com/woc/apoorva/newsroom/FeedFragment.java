package com.woc.apoorva.newsroom;


import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class FeedFragment extends Fragment {
    RecyclerView newsCardRecyclerView;
    NewsCardAdapter adapter;
    List<News> newsList;
    private RequestQueue mQueue;
    private final String url =
            "https://graph.facebook.com/v3.2/me?fields=id%2Cname%2Cfeed%7Bmessage%7D&access_token=EAAkE1GFTfCMBAPycnsQQ0wOdMXFWue8O6QkIybMSrvuZAabE47sDAba8xhKV2ZBI0Rx4LDrQJUajaJ3UCeaZBVcOyy62LACmM2EVJwzjFeTgSLfAn7BZC9JIJ1GIwx9vZAWnm2i2NdrnhDQOIN3WsxkKlkmwauHXbVk9Y0oOTup5mbbNDAoQicWzZCNbuGWugvZAUrXOe876SGXpTmL5jVH";
    ArrayList<String> list = new ArrayList<String>();

    public static FeedFragment newInstance() {

        return new FeedFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_feed, container, false);
        newsList = new ArrayList<>();
        newsCardRecyclerView = (RecyclerView) view.findViewById(R.id.newsCardRecyclerView);
        newsCardRecyclerView.setHasFixedSize(true);
        newsCardRecyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        mQueue = VolleySingleton.getInstance(getContext()).getmRequestQueue();
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {

                            JSONObject jsonObject = response.getJSONObject("feed");
                            JSONArray jsonArray = jsonObject.getJSONArray("data");

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject data = jsonArray.getJSONObject(i);

                                String message = data.getString("message");
                                String id = data.getString("id");
                                //Toast.makeText(getContext(),message,Toast.LENGTH_SHORT).show();
                                newsList.add(new News(R.drawable.ic_launcher_foreground, message));
                                adapter = new NewsCardAdapter(getActivity(), newsList);
                                newsCardRecyclerView.setAdapter(adapter);
                                list.add(message);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                    }
                });

        mQueue.add(request);

//        for (int i = 0; i < list.size(); i++) {
//
//            newsList.add(new News(R.drawable.ic_launcher_foreground, "I'm the best"));
//        }


        return view;
    }

    private void jsonParse() {


        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {

                            JSONObject jsonObject = response.getJSONObject("feed");
                            JSONArray jsonArray = jsonObject.getJSONArray("data");

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject data = jsonArray.getJSONObject(i);

                                String message = data.getString("message");
                                String id = data.getString("id");

                                list.add(message);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                    }
                });

        mQueue.add(request);
    }
}