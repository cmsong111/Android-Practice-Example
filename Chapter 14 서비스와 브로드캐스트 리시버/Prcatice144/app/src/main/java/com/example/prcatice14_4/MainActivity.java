package com.example.prcatice14_4;

import android.Manifest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.Intent;
import android.os.Bundle;

import com.example.prcatice14_4.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_MEDIA_AUDIO}, MODE_PRIVATE);


        Intent intent = new Intent(this, MusicService.class);

        binding.btnStart.setOnClickListener(v -> {
            startService(intent);
        });

        binding.btnStop.setOnClickListener(v -> {
            stopService(intent);
        });



    }
}