package com.example.prcatice13_1;

import android.Manifest;
import android.annotation.SuppressLint;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.example.prcatice13_1.databinding.ActivityMainBinding;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> musicList = new ArrayList<String>();
    ActivityMainBinding binding;
    MediaPlayer mediaPlayer = new MediaPlayer();
    String selectedMusic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        // 권한 요청
        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.READ_MEDIA_AUDIO}, MODE_PRIVATE);

        // 음악 목록 가져오기
        Cursor cursor = getApplicationContext().getContentResolver().query(
                android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                null, null, null, null);

        if (cursor != null) {
            Log.d("cursor", "cursor.getCount() is :" + cursor.getCount());
            while (cursor.moveToNext()) {
                @SuppressLint("Range") String data = cursor.getString(cursor.getColumnIndex(
                        android.provider.MediaStore.Audio.Media.DATA));
                musicList.add(data);
            }
            cursor.close();
        }

        // ListView에 음악 목록 출력
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_single_choice, musicList);


        binding.listViewMP3.setAdapter(adapter);

        // ListView의 Item을 클릭했을 때 이벤트 처리
        binding.listViewMP3.setOnItemClickListener((parent, view, position, id) -> {
            selectedMusic = musicList.get(position);
        });

        // 재생 버튼을 눌렀을 때 이벤트 처리
        binding.btnPlay.setOnClickListener(v -> {
            binding.selectedMusicTitle.setText("실행중인 음악: " + selectedMusic);
            try {
                mediaPlayer.reset();
                mediaPlayer.setDataSource(selectedMusic);
                mediaPlayer.prepare();
                mediaPlayer.start();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        // 정지 버튼을 눌렀을 때 이벤트 처리
        binding.btnStop.setOnClickListener(v -> {
            mediaPlayer.stop();
            mediaPlayer.reset();
            selectedMusic = null;
            binding.selectedMusicTitle.setText("실행중인 음악: ");
        });
    }
}