package com.example.practice11_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.practice11_2.databinding.ActivityMainBinding;

import java.util.logging.Logger;

public class MainActivity extends AppCompatActivity {
    Logger logger = Logger.getLogger(MainActivity.class.getName());

    ActivityMainBinding binding;

    int lastImage = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater()); // 뷰 바인딩
        setContentView(binding.getRoot());  // 뷰 바인딩

        MyGalleryAdapter adapter = new MyGalleryAdapter(this); // 어댑터 생성
        binding.gallery.setAdapter(adapter); // 어댑터 설정


        // 이벤트 처리
        binding.gallery.setOnItemClickListener((parent, view, position, id) -> {
            binding.imageView.setImageResource(adapter.posterId[position]);
            lastImage = position;
        });
        

        binding.imageView.setOnClickListener(v -> {
            Toast toast = new Toast(MainActivity.this);
            View view = getLayoutInflater().inflate(R.layout.toast, null);
            TextView textView = view.findViewById(R.id.textView);
            textView.setText(adapter.posterTitle[lastImage]);
            toast.setView(view);
            toast.show();
        });


    }
}