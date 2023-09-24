package com.example.prcatice_7;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    LinearLayout layout_whole;
    LinearLayout layout_top;
    LinearLayout layout_bottom;
    LinearLayout layout_top_left;
    LinearLayout layout_top_right;
    LinearLayout layout_top_right_top;
    LinearLayout layout_top_right_bottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        layout_whole = new LinearLayout(this);
        layout_top = new LinearLayout(this);
        layout_bottom = new LinearLayout(this);
        layout_top_left = new LinearLayout(this);
        layout_top_right = new LinearLayout(this);
        layout_top_right_top = new LinearLayout(this);
        layout_top_right_bottom = new LinearLayout(this);

        LinearLayout.LayoutParams paramsVertical = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                100,
                1.0f
        );

        LinearLayout.LayoutParams paramsHorizontal = new LinearLayout.LayoutParams(
                100,
                ViewGroup.LayoutParams.MATCH_PARENT,
                1.0f
        );

        // 1. layout_whole
        layout_whole.setOrientation(LinearLayout.VERTICAL);
        layout_whole.setBackgroundColor(Color.GRAY);
        layout_whole.setLayoutParams(new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT
                )
        );


        // 2. layout_top
        layout_top.setOrientation(LinearLayout.HORIZONTAL);
        layout_top.setBackgroundColor(Color.RED);
        layout_top.setLayoutParams(paramsVertical);

        // 3. layout_bottom
        layout_bottom.setOrientation(LinearLayout.HORIZONTAL);
        layout_bottom.setBackgroundColor(Color.BLUE);
        layout_bottom.setLayoutParams(paramsVertical);

        // 4. layout_top_left
        layout_top_left.setOrientation(LinearLayout.VERTICAL);
        layout_top_left.setBackgroundColor(Color.RED);
        layout_top_left.setLayoutParams(paramsHorizontal);

        // 5. layout_top_right
        layout_top_right.setOrientation(LinearLayout.VERTICAL);
        layout_top_right.setBackgroundColor(Color.CYAN);
        layout_top_right.setLayoutParams(paramsHorizontal);

        // 6. layout_top_right_top
        layout_top_right_top.setBackgroundColor(Color.YELLOW);
        layout_top_right_top.setLayoutParams(paramsVertical);

        // 7. layout_top_right_bottom
        layout_top_right_bottom.setBackgroundColor(Color.BLACK);
        layout_top_right_bottom.setLayoutParams(paramsVertical);


        layout_whole.addView(layout_top);
        layout_whole.addView(layout_bottom);

        layout_top.addView(layout_top_left);
        layout_top.addView(layout_top_right);

        layout_top_right.addView(layout_top_right_top);
        layout_top_right.addView(layout_top_right_bottom);

        setContentView(layout_whole);
    }
}