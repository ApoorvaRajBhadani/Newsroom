package com.woc.apoorva.newsroom;


import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ClubsFragment extends Fragment implements TabCult.OnFragmentInteractionListener,TabSports.OnFragmentInteractionListener,TabTech.OnFragmentInteractionListener {

    public static ClubsFragment newInstance() {

        return new ClubsFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_clubs, container, false);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}