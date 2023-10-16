package com.example.practice13_16;

import android.Manifest;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.SystemClock;
import android.provider.MediaStore;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.example.practice13_16.databinding.ActivityMainBinding;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Music> musicList = new ArrayList<Music>();
    ActivityMainBinding binding;

    Music selectedMusic;
    int position;
    boolean isPlaying = false;
    MediaPlayer mediaPlayer = new MediaPlayer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        // 권한 요청
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_MEDIA_AUDIO}, MODE_PRIVATE);

        loadMusic();

        binding.listViewMP3.setAdapter(new MusicAdaptor(musicList));

        // ListView의 Item을 클릭했을 때 이벤트 처리
        binding.listViewMP3.setOnItemClickListener((parent, view, position, id) -> {
            this.position = position;
            try {
                selectedMusic = musicList.get(position);
                mediaPlayer.reset();
                mediaPlayer.setDataSource(selectedMusic.data);
                mediaPlayer.prepare();
                mediaPlayer.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
            binding.selectedMusicTitle.setText(selectedMusic.title);
            new Thread(() -> {
                while (mediaPlayer.isPlaying()) {
                    runOnUiThread(() -> {
                        binding.seekBar.setMax(mediaPlayer.getDuration());
                        binding.seekBar.setProgress(mediaPlayer.getCurrentPosition());
                    });
                    SystemClock.sleep(200);
                }
            }).start();
        });

        // 이전 버튼을 눌렀을 때 이벤트 처리
        binding.previous.setOnClickListener(view -> {
            if (position > 0) {
                position--;
                try {
                    selectedMusic = musicList.get(position);
                    mediaPlayer.reset();
                    mediaPlayer.setDataSource(selectedMusic.data);
                    mediaPlayer.prepare();
                    mediaPlayer.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                binding.selectedMusicTitle.setText(selectedMusic.title);
            }
        });

        // 재생 버튼을 눌렀을 때 이벤트 처리
        binding.btnPlay.setOnClickListener(view -> {
            if (isPlaying) {
                mediaPlayer.pause();
                isPlaying = false;
                binding.btnPlay.setText("재생");
            } else {
                mediaPlayer.start();
                isPlaying = true;
                binding.btnPlay.setText("일시정지");
            }
        });

        // Next 버튼을 눌렀을 때 이벤트 처리
        binding.btnNext.setOnClickListener(view -> {
            if (position < musicList.size() - 1) {
                position++;
                try {
                    selectedMusic = musicList.get(position);
                    mediaPlayer.reset();
                    mediaPlayer.setDataSource(selectedMusic.data);
                    mediaPlayer.prepare();
                    mediaPlayer.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                binding.selectedMusicTitle.setText(selectedMusic.title);
            }
        });

        //
        binding.seekBar.setOnSeekBarChangeListener(new android.widget.SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(android.widget.SeekBar seekBar, int i, boolean b) {
                if (b) {
                    mediaPlayer.seekTo(i);
                }
            }

            @Override
            public void onStartTrackingTouch(android.widget.SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(android.widget.SeekBar seekBar) {

            }
        });

    }

    /**
     * 음악 목록 가져오기
     */
    private void loadMusic() {
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


                musicList.add(music);
            }
            cursor.close();
        }
    }
}