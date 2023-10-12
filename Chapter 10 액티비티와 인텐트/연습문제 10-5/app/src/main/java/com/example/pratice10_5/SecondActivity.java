package com.example.pratice10_5;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    Button btnNewPage, btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_page);
        setTitle("Second 액티비티");
        btnNewPage = findViewById(R.id.new_page_button2);
        btnBack = findViewById(R.id.back_button2);
        btnNewPage.setOnClickListener(v -> {
            Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
            startActivity(intent);
        });
        btnBack.setOnClickListener(v -> {
            finish();
        });
    }
}
