package com.example.prcatice14_4;

import android.app.Service;
import android.content.Intent;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.IBinder;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MusicService extends Service {

    MediaPlayer player;
    ArrayList<Music> musicList = new ArrayList<Music>();
    int position;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        Toast.makeText(this, "MusicService onCreate()", Toast.LENGTH_SHORT).show();
        loadMusic();
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "MusicService onStartCommand()", Toast.LENGTH_SHORT).show();
        player = MediaPlayer.create(this, Uri.parse(musicList.get(position).data));
        player.start();
        Toast.makeText(this, "Now Playing :" + musicList.get(position).title, Toast.LENGTH_SHORT).show();


        player.setOnCompletionListener(mp -> {
            position++;
            if (position >= musicList.size()) {
                position = 0;
            }
            player = MediaPlayer.create(this, Uri.parse(musicList.get(position).data));
            player.start();
            Toast.makeText(this, "Now Playing :" + musicList.get(position).title, Toast.LENGTH_SHORT).show();
        });

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this, "MusicService onDestroy()", Toast.LENGTH_SHORT).show();
        player.stop();
        super.onDestroy();
    }

    private void loadMusic() {
        musicList.clear();
        Cursor cursor = getApplicationContext().getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, null, null, null, null);

        if (cursor != null) {
            Log.d("cursor", "cursor.getCount() is :" + cursor.getCount());
            while (cursor.moveToNext()) {
                Music music = new Music();
                music.data = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DATA));
                music.title = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.TITLE));
                music.album = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ALBUM));
                music.artist = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ARTIST));
                music.albumId = cursor.getInt(cursor.getColumnIndex(MediaStore.Audio.Media.ALBUM_ID));
                music.duration = cursor.getLong(cursor.getColumnIndex(MediaStore.Audio.Media.DURATION));

                musicList.add(music);
                Log.i("music", music.toString());
            }
            cursor.close();
        }
    }


}
