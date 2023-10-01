package com.example.project_8_2;

import static android.graphics.BitmapFactory.decodeFile;
import static android.graphics.BitmapFactory.decodeResource;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class MyPictureView extends View {

    public String imagePath = null;

    public MyPictureView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (imagePath != null) {
            Bitmap bitmap = decodeFile(imagePath);
            canvas.drawBitmap(bitmap, 0, 0, null);
            bitmap.recycle();
        } else {
            canvas.drawBitmap(decodeResource(getResources(), R.drawable.not_fount), 0, 0, null);
        }
    }
}
