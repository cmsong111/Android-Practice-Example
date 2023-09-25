package com.example.practice_6_1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    Chronometer chronometer;
    Button btnStart, btnEnd;
    RadioButton rdoCal, rdoTime;
    CalendarView calView;
    TimePicker tPicker;
    TextView tvYear, tvMonth, tvDay, tvHour, tvMinute;
    int selectYear, selectMonth, selectDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("시간 예약");

        // 위젯 연결
        chronometer = (Chronometer) findViewById(R.id.chronometer1);
        btnStart = (Button) findViewById(R.id.btnStart);
        btnEnd = (Button) findViewById(R.id.btnEnd);

        rdoCal = (RadioButton) findViewById(R.id.rdoCal);
        rdoTime = (RadioButton) findViewById(R.id.rdoTime);

        calView = (CalendarView) findViewById(R.id.calenderView1);
        tPicker = (TimePicker) findViewById(R.id.timePicker1);

        tvYear = (TextView) findViewById(R.id.txtYear);
        tvMonth = (TextView) findViewById(R.id.txtMonth);
        tvDay = (TextView) findViewById(R.id.txtDay);
        tvHour = (TextView) findViewById(R.id.txtHour);
        tvMinute = (TextView) findViewById(R.id.txtMinute);

        calView.setVisibility(View.INVISIBLE);
        tPicker.setVisibility(View.INVISIBLE);

        // 달력 선택 시
        rdoCal.setOnClickListener(view -> {
            calView.setVisibility(View.VISIBLE);
            tPicker.setVisibility(View.INVISIBLE);
        });

        // 시간 선택 시
        rdoTime.setOnClickListener(view -> {
            calView.setVisibility(View.INVISIBLE);
            tPicker.setVisibility(View.VISIBLE);
        });

        // 시작 버튼 클릭 시
        btnStart.setOnClickListener(view -> {
            chronometer.setBase(SystemClock.elapsedRealtime());
            chronometer.start();
            chronometer.setTextColor(Color.RED);
        });

        // 종료 버튼 클릭 시
        btnEnd.setOnClickListener(view -> {
            chronometer.stop();
            chronometer.setTextColor(Color.BLUE);
        });

        // 날짜 선택 시
        calView.setOnDateChangeListener((view, year, month, dayOfMonth) -> {
            selectYear = year;
            selectMonth = month + 1;
            selectDay = dayOfMonth;

            tvYear.setText(Integer.toString(selectYear));
            tvMonth.setText(Integer.toString(selectMonth));
            tvDay.setText(Integer.toString(selectDay));
        });

        // 시간 선택 시
        tPicker.setOnTimeChangedListener((view, hourOfDay, minute) -> {
            tvHour.setText(Integer.toString(hourOfDay));
            tvMinute.setText(Integer.toString(minute));
        });
    }
}