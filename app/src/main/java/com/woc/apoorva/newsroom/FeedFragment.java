package com.woc.apoorva.newsroom;


import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class FeedFragment extends Fragment {
    RecyclerView newsCardRecyclerView;
    NewsCardAdapter adapter;
    List<News> newsList;

    public static FeedFragment newInstance() {

        return new FeedFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_feed, container, false);
        newsList = new ArrayList<>();
        newsCardRecyclerView = (RecyclerView)view.findViewById(R.id.newsCardRecyclerView);
        newsCardRecyclerView.setHasFixedSize(true);
        newsCardRecyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));

//        newsList.add(new News(R.drawable.ic_launcher_foreground,"IIT-ISM the best"));

        adapter = new NewsCardAdapter(this.getActivity(),newsList);
        newsCardRecyclerView.setAdapter(adapter);
        return view;
    }
}