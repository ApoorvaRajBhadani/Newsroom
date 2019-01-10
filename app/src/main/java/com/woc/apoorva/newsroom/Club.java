package com.woc.apoorva.newsroom;

public class Club {
    private int clubLogo,clubType;
    private String clubName,clubDetail,clubLongDetail,clubFbpageurl;

    public Club(int clubLogo,String clubName,String clubDetail,String clubLongDetail,String clubFbpageurl,int clubType)
    {
        this.clubLogo = clubLogo;
        this.clubName = clubName;
        this.clubDetail=clubDetail;
        this.clubLongDetail=clubLongDetail;
        this.clubFbpageurl=clubFbpageurl;
        this.clubType=clubType;
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
