package com.example.project_8_2;

import android.Manifest;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import java.util.ArrayList;
import java.util.logging.Logger;

public class MainActivity extends AppCompatActivity {

    Logger logger = Logger.getLogger(MainActivity.class.getName());
    Button btnNext, btnPrev;
    MyPictureView myPictureView;
    ArrayList<String> imageList = new ArrayList<String>();
    Cursor cursor;
    int position = 0;
    int MAX = 0;
    Uri uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
    String[] projection = new String[]{
            MediaStore.Images.Media._ID,
            MediaStore.Images.Media.DISPLAY_NAME,
            MediaStore.Images.Media.SIZE,
            MediaStore.Images.Media.DATA,
            MediaStore.Images.Media.DATE_ADDED
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("간단 이미지 뷰어");


        btnNext = findViewById(R.id.btnNext);
        btnPrev = findViewById(R.id.btnPrev);
        myPictureView = findViewById(R.id.myPictureView);

        loadImage();

        btnNext.setOnClickListener(v -> {
            if (position < MAX - 1) {
                position++;
                myPictureView.imagePath = imageList.get(position);
                myPictureView.invalidate();
            } else {
                position = 0;
            }
        });

        btnPrev.setOnClickListener(v -> {
            if (position > 0) {
                position--;
                myPictureView.imagePath = imageList.get(position);
                myPictureView.invalidate();
            } else {
                position = MAX - 1;
            }
        });
    }

    public void loadImage() {
        // 권한 요청
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, MODE_PRIVATE);

        // 외부 저장소에 있는 이미지를 가져온다.
        cursor = getApplication().getContentResolver().query(uri, projection, null, null, null);

        MAX = cursor.getCount();
        logger.info("cursor.getCount() : " + MAX);

        while (cursor.moveToNext()) {
            logger.info("cursor.getString(3) : " + cursor.getString(3));
            imageList.add(cursor.getString(3));
        }
        myPictureView.imagePath = imageList.get(0);
    }
}
