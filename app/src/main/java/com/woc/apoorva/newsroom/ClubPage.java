package com.woc.apoorva.newsroom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import static com.woc.apoorva.newsroom.ClubsFragment.EXTRA_CLUB_DETAIL;
import static com.woc.apoorva.newsroom.ClubsFragment.EXTRA_CLUB_NAME;

public class ClubPage extends AppCompatActivity {

    private RequestQueue mRequestQueue;
    TextView clubFbFeedTextView;
    String fin = "initial";

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
