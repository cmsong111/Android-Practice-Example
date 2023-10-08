package com.example.example11_1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.example11_1.databinding.ActivityMainBinding;

import java.util.logging.Logger;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    Logger logger = Logger.getLogger(MainActivity.class.getName());


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater()); // 뷰 바인딩
        setContentView(binding.getRoot()); // 뷰 바인딩

        MyGridAdapter myGridView = new MyGridAdapter(this); // MyGridView 객체 생성
        binding.gridView.setAdapter(myGridView); // 어댑터 설정


        binding.gridView.setOnItemClickListener((parent, view, position, id) -> {
            logger.info("position: " + position);

            AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
            View dialogView = View.inflate(MainActivity.this, R.layout.dialog, null);
            Dialog dialog = new Dialog(MainActivity.this);

            ImageView ivPoster = dialogView.findViewById(R.id.ivPoster);

            ivPoster.setImageResource(myGridView.posterId[position]);
            dlg.setTitle(myGridView.posterTitle[position]);
            dlg.setIcon(R.drawable.movie_icon);
            dlg.setView(dialogView);
            dlg.setNegativeButton("닫기", null);
            dlg.show();
        });
    }

}