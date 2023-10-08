package com.example.pratice10_2;

import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import com.example.pratice10_2.databinding.VoteResultBinding;

import java.util.Arrays;
import java.util.logging.Logger;

public class ResultActivity extends AppCompatActivity {
    private final Logger logger = Logger.getLogger(MainActivity.class.getName());

    private VoteResultBinding binding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = VoteResultBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // 점수 가져오기
        int[] vote_score = getIntent().getIntArrayExtra("vote_score");

        // 이미지 설정
        if (vote_score != null) {
            setImage(vote_score);
        }

        // 점수 초기화
        if (vote_score != null) {
            binding.ratingBarPic1.setRating(vote_score[0]);
            binding.ratingBarPic2.setRating(vote_score[1]);
            binding.ratingBarPic3.setRating(vote_score[2]);
            binding.ratingBarPic4.setRating(vote_score[3]);
            binding.ratingBarPic5.setRating(vote_score[4]);
            binding.ratingBarPic6.setRating(vote_score[5]);
            binding.ratingBarPic7.setRating(vote_score[6]);
            binding.ratingBarPic8.setRating(vote_score[7]);
            binding.ratingBarPic9.setRating(vote_score[8]);
        }

        // 종료 버튼
        binding.btnBack.setOnClickListener(v -> finish());
    }

    private void setImage(int[] vote) {
        // 가장 높은 idx 검색
        int max_idx = 0;
        for (int i = 1; i < 9; i++) {
            if (vote[max_idx] < vote[i]) {
                max_idx = i;
            }
        }
        logger.info("max_idx: " + max_idx);

        String identifier = "pic" + (max_idx + 1);


        // 가장 높은 점수의 이미지 설정
        int text_id = getResources().getIdentifier(identifier, "string", getPackageName());
        int image_id = getResources().getIdentifier(identifier, "drawable", getPackageName());

        binding.selectedPicImageView.setImageDrawable(getDrawable(image_id));
        binding.selectedPicTextView.setText(text_id);
    }
}
