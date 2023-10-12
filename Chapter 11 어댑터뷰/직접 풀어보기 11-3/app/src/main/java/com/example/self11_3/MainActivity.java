package com.example.self11_3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.example.self11_3.databinding.ActivityMainBinding;

import java.util.logging.Logger;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    Logger logger = Logger.getLogger(MainActivity.class.getName());
    Integer[] posterImage = {
            R.drawable.mov01, R.drawable.mov02, R.drawable.mov03,
            R.drawable.mov04, R.drawable.mov05, R.drawable.mov06,
            R.drawable.mov07, R.drawable.mov08, R.drawable.mov09,
            R.drawable.mov10, R.drawable.mov11, R.drawable.mov12,
            R.drawable.mov13, R.drawable.mov14, R.drawable.mov15,
            R.drawable.mov16, R.drawable.mov17, R.drawable.mov18,
            R.drawable.mov19, R.drawable.mov20, R.drawable.mov21,
            R.drawable.mov22, R.drawable.mov23, R.drawable.mov24,
            R.drawable.mov25, R.drawable.mov26, R.drawable.mov27,
            R.drawable.mov28, R.drawable.mov29, R.drawable.mov30,
            R.drawable.mov31, R.drawable.mov32, R.drawable.mov33,
            R.drawable.mov34, R.drawable.mov35, R.drawable.mov36,
            R.drawable.mov37, R.drawable.mov38, R.drawable.mov39,
            R.drawable.mov40, R.drawable.mov41, R.drawable.mov42,
            R.drawable.mov43, R.drawable.mov44, R.drawable.mov45,
            R.drawable.mov46, R.drawable.mov47, R.drawable.mov48,
            R.drawable.mov49, R.drawable.mov50, R.drawable.mov51,
            R.drawable.mov52, R.drawable.mov53, R.drawable.mov54,
            R.drawable.mov55, R.drawable.mov56, R.drawable.mov57,
            R.drawable.mov58, R.drawable.mov59, R.drawable.mov60,
            R.drawable.mov61, R.drawable.mov62, R.drawable.mov63,
            R.drawable.mov64, R.drawable.mov65, R.drawable.mov66,
            R.drawable.mov67, R.drawable.mov68, R.drawable.mov69,
            R.drawable.mov70, R.drawable.mov71, R.drawable.mov72,
            R.drawable.mov73, R.drawable.mov74, R.drawable.mov75,
            R.drawable.mov76, R.drawable.mov77, R.drawable.mov78,
            R.drawable.mov79, R.drawable.mov80, R.drawable.mov81,
            R.drawable.mov82, R.drawable.mov83};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater()); // 뷰 바인딩
        setContentView(binding.getRoot());  // 뷰 바인딩

        binding.spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                logger.info("Spinner item selected: " + position);
                binding.imageView.setImageResource(posterImage[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }
}