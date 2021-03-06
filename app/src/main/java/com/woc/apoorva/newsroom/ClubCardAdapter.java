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

public class ClubCardAdapter extends RecyclerView.Adapter<ClubCardAdapter.ClubCardViewHolder> {
    private Context mCtx;
    private List<Club> clubList;
    private OnClubCardClickListener mListener;

    public interface OnClubCardClickListener {
        void onClubCardClick(int position);
    }

    //will be used for the interface created above
    public void setOnClubCardClickListener(OnClubCardClickListener listener) {
        mListener = listener;
    }

    public ClubCardAdapter(Context mCtx, List<Club> clubList) {
        this.mCtx = mCtx;
        this.clubList = clubList;
    }

    @NonNull
    @Override
    public ClubCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.clublist_layout, parent, false);
        return new ClubCardViewHolder(v);
    }


    @Override
    public void onBindViewHolder(ClubCardViewHolder holder, int position) {
        Club club = clubList.get(position);
        holder.clubName.setText(club.getClubName());
        holder.clubLogo.setImageDrawable(mCtx.getResources().getDrawable(club.getClubLogo()));
        holder.clubDetail.setText(club.getClubDetail());
        switch (club.getClubType()) {
            case 0:
                holder.clubType.setText("T\nE\nC\nH");
                break;
            case 1:
                holder.clubType.setText("S\nP\nO\nR\nT");
                holder.clubType.setTextSize(6);
                break;
            case 2:
                holder.clubType.setText("C\nU\nL\nT");
                break;
            default:
                break;
        }
    }

    @Override
    public int getItemCount() {
        return clubList.size();
    }

    class ClubCardViewHolder extends RecyclerView.ViewHolder {

        TextView clubName, clubType;
        ImageView clubLogo;
        TextView clubDetail;


        public ClubCardViewHolder(@NonNull View itemView) {
            super(itemView);

            clubLogo = itemView.findViewById(R.id.club_logo_cardimage);
            clubName = itemView.findViewById(R.id.club_name_cardtext);
            clubType = itemView.findViewById(R.id.club_type_cardtext);
            clubDetail = itemView.findViewById(R.id.club_detail_cardtext);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mListener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            mListener.onClubCardClick(position);
                        }
                    }
                }
            });
        }
    }

}