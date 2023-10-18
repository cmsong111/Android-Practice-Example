package com.example.self_13_2;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.SystemClock;
import android.widget.SeekBar;

import com.example.self_13_2.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        binding.getRoot().setPadding(20, 20, 20, 20);

        binding.musicSwitch.setOnClickListener(v -> {
            if (binding.musicSwitch.isChecked()) {
                mediaPlayer = MediaPlayer.create(this, R.raw.song3);
                mediaPlayer.start();
                updateSeekBar();
            } else {
                mediaPlayer.stop();
            }
        });

        binding.musicSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mediaPlayer.seekTo(seekBar.getProgress());
            }
        });
    }

    private void updateSeekBar() {
        binding.musicSeekbar.setMax(mediaPlayer.getDuration());
        new Thread(() -> {
            while (mediaPlayer.isPlaying()) {
                binding.musicSeekbar.setProgress(mediaPlayer.getCurrentPosition());
                SystemClock.sleep(100);
            }
        }).start();
    }
}
