package com.example.prcatice14_4;

import android.graphics.Bitmap;

public class Music {
    public String data;
    public String title;
    public String album;
    public String artist;
    public Long duration;
    public int albumId;

    @Override
    public String toString() {
        return "Music{" +
                "data='" + data + '\'' +
                ", title='" + title + '\'' +
                ", album='" + album + '\'' +
                ", artist='" + artist + '\'' +
                ", duration='" + duration + '\'' +
                ", albumId=" + albumId +
                '}';
    }
}