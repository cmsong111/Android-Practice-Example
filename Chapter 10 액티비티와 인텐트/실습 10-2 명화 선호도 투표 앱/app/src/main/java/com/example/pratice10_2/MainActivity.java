package com.example.pratice10_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.pratice10_2.databinding.ActivityMainBinding;

import java.util.logging.Logger;

public class MainActivity extends AppCompatActivity {

    Logger logger = Logger.getLogger(MainActivity.class.getName());

    private ActivityMainBinding binding;
    ImageView lastImageView ;

    // 0으로 초기화
    int[] vote_score = {0, 0, 0, 0, 0, 0, 0, 0, 0};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.imageView1.setOnClickListener(v -> selectImage(binding.imageView1, 0));
        binding.imageView2.setOnClickListener(v -> selectImage(binding.imageView2, 1));
        binding.imageView3.setOnClickListener(v -> selectImage(binding.imageView3, 2));
        binding.imageView4.setOnClickListener(v -> selectImage(binding.imageView4, 3));
        binding.imageView5.setOnClickListener(v -> selectImage(binding.imageView5, 4));
        binding.imageView6.setOnClickListener(v -> selectImage(binding.imageView6, 5));
        binding.imageView7.setOnClickListener(v -> selectImage(binding.imageView7, 6));
        binding.imageView8.setOnClickListener(v -> selectImage(binding.imageView8, 7));
        binding.imageView9.setOnClickListener(v -> selectImage(binding.imageView9, 8));


        binding.btnVote.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
            intent.putExtra("vote_score", vote_score);
            startActivity(intent);
        });

    }

    /**
     * Selects the image and sets the opacity of the selected image to 0.5f
     *
     * @param imageView the id of the selected image
     */
    private void selectImage(ImageView imageView, int index) {
        // 이전에 선택된 이미지의 투명도를 1.0f로 설정
        if (lastImageView != null) {
            lastImageView.setAlpha(1.0f);
        }

        // 선택된 이미지의 투명도를 0.5f로 설정
        lastImageView = imageView;
        lastImageView.setAlpha(0.5f);

        // 투표수 증가
        vote_score[index]++;
        Toast.makeText(getApplicationContext(), index + 1 + "번째 이미지는  " + vote_score[index] + "회 투표되었습니다", Toast.LENGTH_SHORT).show();
    }
}