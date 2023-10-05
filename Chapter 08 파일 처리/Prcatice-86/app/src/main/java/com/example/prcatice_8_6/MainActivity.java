package com.example.prcatice_8_6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.os.Bundle;
import android.os.Environment;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Logger;

public class MainActivity extends AppCompatActivity {

    Logger logger = Logger.getLogger(MainActivity.class.getName());
    FileOutputStream fileOutputStream;
    DatePicker datePicker;
    EditText diaryEditText;
    Button saveButton;

    File sdcard = Environment.getExternalStorageDirectory();
    String folderName = "myDiary";
    File myDir = new File(sdcard.getAbsolutePath() + "/" + folderName);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // SD카드 permission 설정
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, MODE_PRIVATE);
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, MODE_PRIVATE);


        datePicker = findViewById(R.id.datePicker);
        diaryEditText = findViewById(R.id.editTextDiary);
        saveButton = findViewById(R.id.button);

        // sdcard/myDir 디렉터리가 없으면 생성
        logger.info("SD card path : " + sdcard.getAbsolutePath());
        logger.info("myDir path : " + myDir.getAbsolutePath());
        if (!myDir.exists()) {
            boolean result = myDir.mkdir();
            logger.info("디렉터리가 생성되었습니다. \n생성 결과:" + result);
        } else {
            logger.info("디렉터리가 이미 존재합니다.");
        }

        // 현재 날짜의 일기 파일 읽어오기
        loadDiary();

        // 데이트피커에 리스너 설정
        datePicker.setOnDateChangedListener((view, year, monthOfYear, dayOfMonth) -> {
            loadDiary();
        });

        // 저장 버튼에 리스너 설정
        saveButton.setOnClickListener(v -> {
            SaveDiary();
        });
    }

    public String getDiaryName() {
        int year = datePicker.getYear();
        int month = datePicker.getMonth();
        int day = datePicker.getDayOfMonth();

        String today = "diary_" + year + "_" + (month + 1) + "_" + day + ".txt";
        logger.info("생성된 파일명 :" + today);

        return today;
    }

    /**
     * 파일에서 데이터를 읽어와 EditText에 표시
     * 파일이 존재하지 않으면 아무것도 표시하지 않음
     */
    public void loadDiary() {
        File diaryFile = new File(myDir, getDiaryName());
        if (diaryFile.exists()) {
            try {
                FileInputStream fileInputStream = new FileInputStream(diaryFile);
                byte[] txt = new byte[fileInputStream.available()];
                fileInputStream.read(txt);
                fileInputStream.close();
                diaryEditText.setText(new String(txt));

            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            diaryEditText.setText("");
            logger.info("파일이 존재하지 않습니다.");
        }

    }

    /**
     * EditText의 내용을 파일에 저장
     * 파일명은 현재 날짜
     */
    public void SaveDiary() {
        File diaryFile = new File(myDir, getDiaryName());

        logger.info("파일명 : " + diaryFile.getName());
        logger.info("파일경로 : " + diaryFile.getAbsolutePath());
        logger.info("저장될 내용: " + diaryEditText.getText().toString());

        // 파일에 데이터 저장
        try {
            fileOutputStream = new FileOutputStream(diaryFile);
            String str = diaryEditText.getText().toString();
            fileOutputStream.write(str.getBytes());
            fileOutputStream.close();
            logger.info("저장 완료");
        } catch (Exception e) {
            logger.warning("저장 실패");
            e.printStackTrace();
        }
    }
}
