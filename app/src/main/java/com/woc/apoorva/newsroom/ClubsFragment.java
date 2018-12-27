package com.woc.apoorva.newsroom;


import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class ClubsFragment extends Fragment {

    RecyclerView clubCardRecyclerView;
    ClubCardAdapter adapter;
    List<Club> clubList;

    public static ClubsFragment newInstance() {

        return new ClubsFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_clubs, container, false);
        clubList = new ArrayList<>();
        clubCardRecyclerView = (RecyclerView)view.findViewById(R.id.clubCardRecyclerView);
        clubCardRecyclerView.setHasFixedSize(true);
        clubCardRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        clubList.add(
                new Club(R.drawable.ic_launcher_background,"RoboISM")
        );
        clubList.add(
                new Club(R.drawable.ic_launcher_background,"CyberLabs")
        );
        clubList.add(
                new Club(R.drawable.ic_launcher_background,"LITM")
        );
        clubList.add(
                new Club(R.drawable.ic_launcher_background,"LitC")
        );
        clubList.add(
                new Club(R.drawable.ic_launcher_background,"RoboISM")
        );
        clubList.add(
                new Club(R.drawable.ic_launcher_background,"CyberLabs")
        );
        clubList.add(
                new Club(R.drawable.ic_launcher_background,"LITM")
        );
        clubList.add(
                new Club(R.drawable.ic_launcher_background,"LitC")
        );
        clubList.add(
                new Club(R.drawable.ic_launcher_background,"RoboISM")
        );
        clubList.add(
                new Club(R.drawable.ic_launcher_background,"CyberLabs")
        );
        clubList.add(
                new Club(R.drawable.ic_launcher_background,"LITM")
        );
        clubList.add(
                new Club(R.drawable.ic_launcher_background,"LitC")
        );
        adapter = new ClubCardAdapter(getContext(),clubList);
        clubCardRecyclerView.setAdapter(adapter);
        return view;
    }


}