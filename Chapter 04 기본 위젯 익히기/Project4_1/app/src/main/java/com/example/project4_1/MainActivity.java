package com.example.project4_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edit1, edit2;
    Button btnAdd, btnSub, btnMul, btnDiv, btnMod;
    TextView textResult;
    Double num1, num2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("사칙연산 계산기");

        edit1 = (EditText) findViewById(R.id.Edit1);
        edit2 = (EditText) findViewById(R.id.Edit2);

        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnSub = (Button) findViewById(R.id.btnSub);
        btnMul = (Button) findViewById(R.id.BtnMul);
        btnDiv = (Button) findViewById(R.id.BtnDiv);
        btnMod = (Button) findViewById(R.id.BtnMod);

        textResult = (TextView) findViewById(R.id.textResult);

        btnAdd.setOnClickListener(v -> {
            getNum();
            if (num1 == null || num2 == null) return;
            textResult.setText("계산 결과 : " + (num1 + num2));
        });

        btnSub.setOnClickListener(v -> {
            getNum();
            if (num1 == null || num2 == null) return;
            textResult.setText("계산 결과 : " + (num1 - num2));
        });

        btnMul.setOnClickListener(v -> {
            getNum();
            if (num1 == null || num2 == null) return;
            textResult.setText("계산 결과 : " + (num1 * num2));
        });

        btnDiv.setOnClickListener(v -> {
            getNum();
            if (num1 == null || num2 == null) return;
            if (num2 == 0) {
                Toast.makeText(getApplicationContext(), "0으로 나눌 수 없습니다.", Toast.LENGTH_SHORT).show();
                return;
            }
            textResult.setText("계산 결과 : " + (num1 / num2));
        });

        btnMod.setOnClickListener(v -> {
            getNum();
            if (num1 == null || num2 == null) return;
            if (num2 == 0) {
                Toast.makeText(getApplicationContext(), "0으로 나눌 수 없습니다.", Toast.LENGTH_SHORT).show();
                return;
            }
            textResult.setText("계산 결과 : " + (num1 % num2));
        });

    }

    /**
     * edit1, edit2에 입력된 값을 가져와서 num1, num2에 저장
     * 입력값이 없으면 Toast 메시지 출력
     * 입력값이 있으면 num1, num2에 저장
     *
     * @return void
     */
    void getNum() {
        if (edit1.getText().toString().equals("") || edit2.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(), "값을 입력하세요.", Toast.LENGTH_SHORT).show();
            num1 = num2 = null;
            return;
        }
        num1 = Double.parseDouble(edit1.getText().toString());
        num2 = Double.parseDouble(edit2.getText().toString());
    }
}