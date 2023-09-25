package com.example.project7_2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    LinearLayout baseLayout;
    Button btnChangeBackground, btnChagneButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        baseLayout = (LinearLayout) findViewById(R.id.base_layout);
        btnChangeBackground = (Button) findViewById(R.id.btnChangeBackground);
        registerForContextMenu(btnChangeBackground);
        btnChagneButton = (Button) findViewById(R.id.btnChangeButton);
        registerForContextMenu(btnChagneButton);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        System.out.println("onCreateContextMenu");
        MenuInflater mInflater = getMenuInflater();
        if (v == btnChangeBackground) {
            menu.setHeaderTitle("배경색 변경");
            mInflater.inflate(R.menu.menu1, menu);
        }
        if (v == btnChagneButton) {
            menu.setHeaderTitle("버튼 변경");
            mInflater.inflate(R.menu.menu2, menu);
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.itemRed) {
            baseLayout.setBackgroundColor(Color.RED);
            return true;
        } else if (itemId == R.id.itemGreen) {
            baseLayout.setBackgroundColor(Color.GREEN);
            return true;
        } else if (itemId == R.id.itemBlue) {
            baseLayout.setBackgroundColor(Color.BLUE);
            return true;
        } else if (itemId == R.id.subRotate) {
            btnChagneButton.setRotation(45);
            return true;
        } else if (itemId == R.id.subSize) {
            btnChagneButton.setScaleX(2);
            return true;
        }
        return false;
    }

}