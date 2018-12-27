package com.woc.apoorva.newsroom;

public class News {
    private int newsImage;
    private String newsTitle;

    public News(int newsImage,String newsTitle)
    {
        this.newsImage = newsImage;
        this.newsTitle = newsTitle;
    }

    public int getNewsImage() {
        return newsImage;
    }

    public String getNewsTitle() {
        return newsTitle;
    }
}
