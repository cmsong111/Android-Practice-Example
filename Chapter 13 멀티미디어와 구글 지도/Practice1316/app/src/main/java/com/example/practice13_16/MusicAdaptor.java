package com.example.practice13_16;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MusicAdaptor extends BaseAdapter {

    private TextView textViewTitle;
    private TextView textViewArtist;
    private TextView textViewDuration;
    private ImageView imageViewAlbumArt;
    ArrayList<Music> musicList = new ArrayList<Music>();

    public MusicAdaptor(ArrayList<Music> musicList) {
        this.musicList = musicList;
    }

    @Override
    public int getCount() {
        return musicList.size();
    }

    @Override
    public Object getItem(int i) {
        return musicList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final Context context = viewGroup.getContext();
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.music_item_tile, viewGroup, false);
        }

        textViewTitle = view.findViewById(R.id.music_title);
        textViewArtist = view.findViewById(R.id.music_artist);
        textViewDuration = view.findViewById(R.id.music_duration);
        imageViewAlbumArt = view.findViewById(R.id.music_image);

        textViewTitle.setText(musicList.get(i).title);
        textViewArtist.setText(musicList.get(i).artist);
        textViewDuration.setText(musicList.get(i).album);

        return view;
    }
}
