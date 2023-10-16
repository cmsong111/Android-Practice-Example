package com.example.practice13_16;

import android.graphics.Bitmap;

public class Music {
    public String data;
    public String title;
    public String album;
    public String artist;
    public String duration;
    public int albumId;
    public Bitmap albumImage;

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
