package com.example.recyclerview;

public class WeixinActivity {
    private String name;
    private int imageId;
    private String quotes;
    public WeixinActivity(String name, int imageId, String quotes){
        this.name=name;this.imageId=imageId;this.quotes=quotes;
    }
    public String getName(){
        return name;
    }
    public String getQuotes(){
        return quotes;
    }

    public int getImageId() {
        return imageId;
    }
}
