package com.woc.apoorva.newsroom;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class NewsCardAdapter extends RecyclerView.Adapter<NewsCardAdapter.NewsCardViewHolder> {
    private Context mCtx;
    private List<News> newsList;

    public NewsCardAdapter(Context mCtx, List<News> newsList){
        this.mCtx = mCtx;
        this.newsList = newsList;
    }

    @NonNull
    @Override
    public NewsCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
//        LayoutInflater inflater = LayoutInflater.from(mCtx);
//        View view = inflater.inflate(R.layout.clublist_layout, null);
//        return new ClubCardViewHolder(view);
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.clublist_layout,parent,false);

        return new NewsCardViewHolder(v);
    }


    @Override
    public void onBindViewHolder(NewsCardViewHolder holder, int position) {
        News news = newsList.get(position);
        holder.newsTitle.setText(news.getNewsTitle());
        holder.newsImage.setImageDrawable(mCtx.getResources().getDrawable(news.getNewsImage()));

    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    class NewsCardViewHolder extends RecyclerView.ViewHolder {

        TextView newsTitle;
        ImageView newsImage;

        public NewsCardViewHolder(@NonNull View itemView) {
            super(itemView);

            newsImage = itemView.findViewById(R.id.news_image_cardimage);
            newsTitle = itemView.findViewById(R.id.news_title_cardtext);
        }
    }

}
