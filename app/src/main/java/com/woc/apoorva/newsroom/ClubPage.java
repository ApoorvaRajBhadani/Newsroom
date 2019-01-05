package com.woc.apoorva.newsroom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import static com.woc.apoorva.newsroom.ClubsFragment.EXTRA_CLUB_DETAIL;
import static com.woc.apoorva.newsroom.ClubsFragment.EXTRA_CLUB_NAME;

public class ClubPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club_page);

        Intent intent = getIntent();
        String clubName = intent.getStringExtra(EXTRA_CLUB_NAME);
        String clubDetail = intent.getStringExtra(EXTRA_CLUB_DETAIL);

        TextView clubNameTextView = findViewById(R.id.club_name_pagetext);
        TextView clubDetailTextView = findViewById(R.id.club_detail_pagetext);

        clubNameTextView.setText(clubName);
        clubDetailTextView.setText(clubDetail);
    }
}
