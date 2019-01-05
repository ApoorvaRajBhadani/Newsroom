package com.woc.apoorva.newsroom;


import android.content.Intent;
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

public class ClubsFragment extends Fragment implements ClubCardAdapter.OnClubCardClickListener {

    public static final String EXTRA_CLUB_NAME = "clubName";
    public static final String EXTRA_CLUB_DETAIL = "clubDetail";

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
        clubCardRecyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        clubList.add(
                new Club(R.drawable.ic_launcher_background,"RoboISM","Robots, Intelligent machines , drones and more")
        );
        clubList.add(
                new Club(R.drawable.ic_launcher_background,"CyberLabs","Discover opportunities in numerous fields of computing")
        );
        clubList.add(
                new Club(R.drawable.ic_launcher_background,"LITM","Stage dance club of IIT-ISM")
        );
        clubList.add(
                new Club(R.drawable.ic_launcher_background,"LitC","Novels, debates , standup and more")
        );
        clubList.add(
                new Club(R.drawable.ic_launcher_background,"Mechismu","Racing is Religion")
        );
        clubList.add(
                new Club(R.drawable.ic_launcher_background,"Squash","Indoor sports somewhat similar to tennis")
        );
        clubList.add(
                new Club(R.drawable.ic_launcher_background,"Table Tennis","ping pong ball bouncing on the table")
        );
        clubList.add(
                new Club(R.drawable.ic_launcher_background,"Cricket club","From helicopter shots to centuries")
        );
        adapter = new ClubCardAdapter(this.getActivity(),clubList);
        clubCardRecyclerView.setAdapter(adapter);
        adapter.setOnClubCardClickListener(ClubsFragment.this);
        return view;
    }


    @Override
    public void onClubCardClick(int position) {
        Intent pageIntent = new Intent(getContext(),ClubPage.class);
        Club clickedClub = clubList.get(position);

        pageIntent.putExtra(EXTRA_CLUB_NAME,clickedClub.getClubName());
        pageIntent.putExtra(EXTRA_CLUB_DETAIL,clickedClub.getClubDetail());

        startActivity(pageIntent);
    }
}