package com.woc.apoorva.newsroom;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ImageView;
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
import static com.woc.apoorva.newsroom.ClubsFragment.EXTRA_CLUB_FBURL;
import static com.woc.apoorva.newsroom.ClubsFragment.EXTRA_CLUB_LOGO;
import static com.woc.apoorva.newsroom.ClubsFragment.EXTRA_CLUB_LONGDETAIL;
import static com.woc.apoorva.newsroom.ClubsFragment.EXTRA_CLUB_NAME;
import static com.woc.apoorva.newsroom.ClubsFragment.EXTRA_CLUB_TYPE;

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
        String clubLongDetail = intent.getStringExtra(EXTRA_CLUB_LONGDETAIL);
        final String clubFbUrl = intent.getStringExtra(EXTRA_CLUB_FBURL);
        int clubLogoResourceId = intent.getIntExtra(EXTRA_CLUB_LOGO, R.drawable.cyberlabs);
        int clubType = intent.getIntExtra(EXTRA_CLUB_TYPE, 0);

        TextView clubNameTextView = findViewById(R.id.club_name_pagetext);
        TextView clubLongDetailTextView = findViewById(R.id.club_longdetail_pagetext);
        clubLongDetailTextView.setMovementMethod(new ScrollingMovementMethod());
        TextView clubTypeTextView = findViewById(R.id.club_type_pagetext);
        TextView clubDetailTextView = findViewById(R.id.club_detail_pagetext);
        ImageView clubLogoImageView = findViewById(R.id.club_logo_pageimage);
        ImageView clubFbRedirectImageButton = findViewById(R.id.fblogo_imagebutton);

        clubLongDetailTextView.setText(clubLongDetail);
        switch (clubType) {
            case 0:
                clubTypeTextView.setText("Technical");
                break;
            case 1:
                clubTypeTextView.setText("Sports");
                break;
            case 2:
                clubTypeTextView.setText("Cultural");
                break;
            default:
                break;
        }
        clubLogoImageView.setImageResource(clubLogoResourceId);
        clubNameTextView.setText(clubName);
        clubDetailTextView.setText(clubDetail);

        clubFbRedirectImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = clubFbUrl;
                if (!url.startsWith("https://") && !url.startsWith("http://")){
                    url = "http://" + url;
                }
                Intent openUrlIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(openUrlIntent);
            }
        });


    }

}
