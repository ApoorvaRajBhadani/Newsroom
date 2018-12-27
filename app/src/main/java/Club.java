public class Club {
    private int clubLogo;
    private String clubName;

    public Club(int clubLogo,String clubName)
    {
        this.clubLogo = clubLogo;
        this.clubName = clubName;
    }

    public int getClubLogo() {
        return clubLogo;
    }

    public String getClubName() {
        return clubName;
    }
}
