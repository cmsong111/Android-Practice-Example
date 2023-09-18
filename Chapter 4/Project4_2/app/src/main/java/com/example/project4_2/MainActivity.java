package com.example.project4_2;

import static android.view.View.INVISIBLE;
import static android.view.View.VISIBLE;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    TextView text1, text2;
    CheckBox chkAgree;
    RadioGroup rGroup1;
    RadioButton rdoDog, rdoCat, rdoRabbit;
    Button btnOK;
    ImageView imgPet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text1 = (TextView) findViewById(R.id.Text1);
        chkAgree = (CheckBox) findViewById(R.id.ChkAgree);

        text2 = (TextView) findViewById(R.id.Text2);
        rGroup1 = (RadioGroup) findViewById(R.id.RGroup1);
        rdoDog = (RadioButton) findViewById(R.id.RdoDog);
        rdoCat = (RadioButton) findViewById(R.id.RdoCat);
        rdoRabbit = (RadioButton) findViewById(R.id.RdoRabbit);

        btnOK = (Button) findViewById(R.id.BtnOK);
        imgPet = (ImageView) findViewById(R.id.ImgPet);

        chkAgree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (chkAgree.isChecked()) {
                    text2.setVisibility(VISIBLE);
                    rGroup1.setVisibility(VISIBLE);
                    btnOK.setVisibility(VISIBLE);
                    imgPet.setVisibility(VISIBLE);
                } else {
                    text2.setVisibility(INVISIBLE);
                    rGroup1.setVisibility(INVISIBLE);
                    btnOK.setVisibility(INVISIBLE);
                    imgPet.setVisibility(INVISIBLE);
                }
            }
        });


        btnOK.setOnClickListener(view -> {
            int checkedRadioButtonId = rGroup1.getCheckedRadioButtonId();
            if (checkedRadioButtonId == R.id.RdoDog) {
                imgPet.setImageResource(R.drawable.dog);
            } else if (checkedRadioButtonId == R.id.RdoCat) {
                imgPet.setImageResource(R.drawable.cat);
            } else if (checkedRadioButtonId == R.id.RdoRabbit) {
                imgPet.setImageResource(R.drawable.rabbit);
            } else {
                Toast.makeText(getApplicationContext(), "동물 먼저 선택하세요", Toast.LENGTH_SHORT).show();
            }
        });
    }
}