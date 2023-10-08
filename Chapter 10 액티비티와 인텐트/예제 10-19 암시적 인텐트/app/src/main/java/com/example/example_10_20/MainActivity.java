package com.example.example_10_20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.example.example_10_20.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnTell.setOnClickListener(view -> {
            startActivity(new Intent("android.intent.action.DIAL", Uri.parse("tel:010-1234-5678")));
        });

        binding.btnWeb.setOnClickListener(view -> {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://www.google.com")));
        });

        binding.btnMap.setOnClickListener(view -> {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse("geo:37.5662952,126.9779451")));
        });

        binding.btnSearch.setOnClickListener(view -> {
            Intent intent = new Intent("android.intent.action.WEB_SEARCH");
            intent.putExtra("query", "안드로이드");
            startActivity(intent);
        });

        binding.btnText.setOnClickListener(view -> {
            Intent intent = new Intent("android.intent.action.SENDTO", Uri.parse("smsto:010-1234-5678"));
            intent.putExtra("sms_body", "안녕하세요?");
            startActivity(intent);
        });

        binding.btnPhoto.setOnClickListener(view -> {
            startActivity(new Intent("android.media.action.IMAGE_CAPTURE"));
        });
    }
}