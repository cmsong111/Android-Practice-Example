package com.example.project_7_6;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.logging.Logger;

public class MainActivity extends AppCompatActivity {

    Logger logger = Logger.getLogger(MainActivity.class.getName());

    // Main Screen 위젯
    RadioGroup radioGroup;
    Button btnShow;
    // Dialog 위젯
    View dialogView;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("박스 안의 라디오 버튼");

        radioGroup = (RadioGroup) findViewById(R.id.radioGroupAnimals);

        btnShow = (Button) findViewById(R.id.buttonShow);

        btnShow.setOnClickListener(view -> {
            logger.info("버튼 클릭");
            logger.info("클릭된 버튼: " + radioGroup.getCheckedRadioButtonId());

            int selectedAnimal = R.string.cat;
            int selectedId = R.drawable.cat;

            if (radioGroup.getCheckedRadioButtonId() == R.id.radioButtonCat) {
                logger.info("고양이 클릭");
                selectedAnimal = R.string.cat;
                selectedId = R.drawable.cat;
            } else if (radioGroup.getCheckedRadioButtonId() == R.id.radioButtonDog) {
                logger.info("강아지 클릭");
                selectedAnimal = R.string.dog;
                selectedId = R.drawable.dog;
            } else if (radioGroup.getCheckedRadioButtonId() == R.id.radioButtonRabbit) {
                logger.info("토끼 클릭");
                selectedAnimal = R.string.rabbit;
                selectedId = R.drawable.rabbit;
            } else if (radioGroup.getCheckedRadioButtonId() == R.id.radioButtonHorse) {
                logger.info("말 클릭");
                selectedAnimal = R.string.horse;
                selectedId = R.drawable.horse;
            }

            dialogView = (View) View.inflate(MainActivity.this, R.layout.animal_dialog, null);
            imageView = (ImageView) dialogView.findViewById(R.id.imageViewAnimal);

            imageView.setImageResource(selectedId);

            AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
            dlg.setTitle(selectedAnimal);
            dlg.setPositiveButton("닫기", null);
            dlg.setView(dialogView);
            dlg.show();
        });
    }
}