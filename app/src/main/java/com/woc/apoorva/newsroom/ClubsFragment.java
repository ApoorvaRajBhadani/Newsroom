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
    public static final String EXTRA_CLUB_LONGDETAIL = "clubLongDetail";
    public static final String EXTRA_CLUB_FBURL = "clubFBUrl";
    public static final String EXTRA_CLUB_LOGO = "clubLogo";
    public static final String EXTRA_CLUB_TYPE = "clubType";

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
                new Club(R.drawable.roboism,"RoboISM","Robots, Intelligent machines , drones and more","Robotics & AI Club is a student-run organization/club of Indian Institute of Technology (ISM) Dhanbad. The President of the club is Dr Sachin Tripathi (Associate Prof, Computer Science and Engineering). The Robotics Club is a community of students who derive pleasure in creating mechanical peers that may even be potent to work without human intervention. Each member of this family is provided mechanical, electronic, monetary and informatory aid besides the indispensable guidance of experienced members. The Club, through its regular lectures and workshops, is incessantly involved in producing robots such as autonomous and manual robots, a lot many more that make up the plethoric and diverse robotic arsenal. •\tThe Robotics Club of IIT (ISM) Dhanbad is a fraternity; not just a group but a faction of such students whose passions dwell in beholding wires and metal beget a machine. It's here, that seeds of lecturing are sown by those experienced and erudite, nurtured by the interested and novice pruned by minute yet unprecedented errors and harvested in competitions all over India. The Club offers indispensable guidance, workshops and tutorials along with tools, equipment, components and workspace. The family meets periodically to discuss over matters such as the management of the workspace, workshops, projects and competitions. We welcome anyone, with or without prior knowledge, who wishes to be a part of this fraternity. There are no pre-requisites to join because we have members that believe in the transfer of knowledge, especially that which concerns our precious interest in Robotics.","www.facebook.com/roboism",0)
        );
        clubList.add(
                new Club(R.drawable.cyberlabs,"CyberLabs","Discover opportunities in numerous fields of computing","Cyber Labs is an initiative by the students of ISM on the footsteps of MIT MediaLabs to learn vital concepts of engineering by working on realtime projects","www.facebook.com/labscyber",0)
        );
        clubList.add(
                new Club(R.drawable.litm,"LITM","Stage dance club of IIT-ISM","This page is about the official dance club of ISM Dhanbad, LITM- Legends In The Making. Let your feet move and rock","www.facebook.com/LITM.ISM",2)
        );
        clubList.add(
                new Club(R.drawable.litc,"LitC","Novels, debates , standup and more","IIT (ISM)’s Literary and Debating Club, LitC is trying to recreate the forgotten bond between IIT ISMites and literature and in the process giving necessary heed to general awareness, developing opinions and personalities, and nurturing communication skills. With its focus on unearthing hidden potentials among its members, it serves as a common platform for readers, writers, speakers, poets, bloggers, amateur journalists,debaters etc. Its activities include discussions, debates, elocution, presentations, workshops, story writing, poetry-sessions, online debates and quizzes and promotion of literature in its diverse forms.","www.facebook.com/litcism",2)
        );
        clubList.add(
                new Club(R.drawable.mechismu,"Mechismu","Racing is Religion","We couldn't find the sports car of our dreams, so we built it ourselves.","www.facebook.com/mechismu",0)
        );
        clubList.add(
                new Club(R.drawable.tabletennis,"Table Tennis","ping pong ball bouncing on the table","The Official page for the updates of Table Tennis Club at IIT(ISM) Dhanbad.","www.facebook.com/iitismTT",1)
        );
        clubList.add(
                new Club(R.drawable.cricketclub,"Cricket club","From helicopter shots to centuries","Official fb page of cricket club of IIT-ISM","www.facebook.com/cricket.iitism",1)
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
        pageIntent.putExtra(EXTRA_CLUB_LONGDETAIL,clickedClub.getClubLongDetail());
        pageIntent.putExtra(EXTRA_CLUB_FBURL,clickedClub.getClubFbpageurl());
        pageIntent.putExtra(EXTRA_CLUB_LOGO,clickedClub.getClubLogo());
        pageIntent.putExtra(EXTRA_CLUB_TYPE,clickedClub.getClubType());

        startActivity(pageIntent);
    }
}