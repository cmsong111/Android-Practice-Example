package com.example.pratice10_5;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ThirdActivity extends AppCompatActivity {
    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thrid_page);
        setTitle("Third 액티비티");
        btnBack = findViewById(R.id.back_button3);

        btnBack.setOnClickListener(v -> {
            finish();
        });
    }
}
