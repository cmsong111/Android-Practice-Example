package com.example.doit_5_5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edit1, edit2;
    Button btnAdd, btnSub, btnMul, btnDiv;
    TextView textResult;
    String num1, num2;
    Integer result;

    Button[] numButtons = new Button[10];
    Integer[] numBtnIDs = {R.id.BtnNum0, R.id.BtnNum1, R.id.BtnNum2, R.id.BtnNum3, R.id.BtnNum4, R.id.BtnNum5, R.id.BtnNum6, R.id.BtnNum7, R.id.BtnNum8, R.id.BtnNum9};
    int i;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit1 = (EditText) findViewById(R.id.Edit1);
        edit2 = (EditText) findViewById(R.id.Edit2);

        btnAdd = (Button) findViewById(R.id.BtnAdd);
        btnSub = (Button) findViewById(R.id.BtnSub);
        btnMul = (Button) findViewById(R.id.BtnMul);
        btnDiv = (Button) findViewById(R.id.BtnDiv);

        textResult = (TextView) findViewById(R.id.TextResult);

        for (i = 0; i < numBtnIDs.length; i++) {
            numButtons[i] = (Button) findViewById(numBtnIDs[i]);
        }

        btnAdd.setOnClickListener(v -> {
            num1 = edit1.getText().toString();
            num2 = edit2.getText().toString();

            try {
                result = Integer.parseInt(num1) + Integer.parseInt(num2);
                textResult.setText("계산 결과 : " + result.toString());
            } catch (Exception e) {
                Toast.makeText(getApplicationContext(), "숫자를 입력하세요", Toast.LENGTH_SHORT).show();
            }
        });

        btnSub.setOnClickListener(v -> {
            num1 = edit1.getText().toString();
            num2 = edit2.getText().toString();


            try {
                result = Integer.parseInt(num1) - Integer.parseInt(num2);
                textResult.setText("계산 결과 : " + result.toString());
            } catch (Exception e) {
                Toast.makeText(getApplicationContext(), "숫자를 입력하세요", Toast.LENGTH_SHORT).show();
            }
        });

        btnMul.setOnClickListener(v -> {
            num1 = edit1.getText().toString();
            num2 = edit2.getText().toString();


            try {
                result = Integer.parseInt(num1) * Integer.parseInt(num2);
                textResult.setText("계산 결과 : " + result.toString());
            } catch (Exception e) {
                Toast.makeText(getApplicationContext(), "숫자를 입력하세요", Toast.LENGTH_SHORT).show();
            }
        });

        btnDiv.setOnClickListener(v -> {
            num1 = edit1.getText().toString();
            num2 = edit2.getText().toString();


            if (Integer.parseInt(num2) == 0) {
                Toast.makeText(getApplicationContext(), "0으로 나눌 수 없습니다.", Toast.LENGTH_SHORT).show();
                return;
            }

            try {

                result = Integer.parseInt(num1) / Integer.parseInt(num2);
                textResult.setText("계산 결과 : " + result.toString());
            } catch (Exception e) {
                Toast.makeText(getApplicationContext(), "숫자를 입력하세요", Toast.LENGTH_SHORT).show();
            }

        });


        for (i = 0; i < numBtnIDs.length; i++) {
            final int index;
            index = i;
            numButtons[index].setOnClickListener(v -> {
                if (edit1.isFocused() == true) {
                    num1 = edit1.getText().toString() + numButtons[index].getText().toString();
                    edit1.setText(num1);
                } else if (edit2.isFocused() == true) {
                    num2 = edit2.getText().toString() + numButtons[index].getText().toString();
                    edit2.setText(num2);
                } else {
                    Toast.makeText(getApplicationContext(), "먼저 에디트텍스트를 선택하세요", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

}
