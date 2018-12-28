package com.woc.apoorva.newsroom;

public class Club {
    private int clubLogo;
    private String clubName,clubDetail;

    public Club(int clubLogo,String clubName,String clubDetail)
    {
        this.clubLogo = clubLogo;
        this.clubName = clubName;
        this.clubDetail=clubDetail;
    }

    public String getClubDetail() {
        return clubDetail;
    }

    public int getClubLogo() {
        return clubLogo;
    }

    public String getClubName() {
        return clubName;
    }
}
