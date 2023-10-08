package com.example.practice11_2;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

public class MyGalleryAdapter extends BaseAdapter {

    Context context;

    Integer[] posterId = {
            R.drawable.mov01, R.drawable.mov02, R.drawable.mov03,
            R.drawable.mov04, R.drawable.mov05, R.drawable.mov06,
            R.drawable.mov07, R.drawable.mov08, R.drawable.mov09,
            R.drawable.mov10, R.drawable.mov11, R.drawable.mov12,
            R.drawable.mov13, R.drawable.mov14, R.drawable.mov15,
            R.drawable.mov16, R.drawable.mov17, R.drawable.mov18,
            R.drawable.mov19, R.drawable.mov20, R.drawable.mov21,
            R.drawable.mov22, R.drawable.mov23, R.drawable.mov24,
            R.drawable.mov25, R.drawable.mov26, R.drawable.mov27,
            R.drawable.mov28, R.drawable.mov29, R.drawable.mov30,
            R.drawable.mov31, R.drawable.mov32, R.drawable.mov33,
            R.drawable.mov34, R.drawable.mov35, R.drawable.mov36,
            R.drawable.mov37, R.drawable.mov38, R.drawable.mov39,
            R.drawable.mov40, R.drawable.mov41, R.drawable.mov42,
            R.drawable.mov43, R.drawable.mov44, R.drawable.mov45,
            R.drawable.mov46, R.drawable.mov47, R.drawable.mov48,
            R.drawable.mov49, R.drawable.mov50, R.drawable.mov51,
            R.drawable.mov52, R.drawable.mov53, R.drawable.mov54,
            R.drawable.mov55, R.drawable.mov56, R.drawable.mov57,
            R.drawable.mov58, R.drawable.mov59, R.drawable.mov60,
            R.drawable.mov61, R.drawable.mov62, R.drawable.mov63,
            R.drawable.mov64, R.drawable.mov65, R.drawable.mov66,
            R.drawable.mov67, R.drawable.mov68, R.drawable.mov69,
            R.drawable.mov70, R.drawable.mov71, R.drawable.mov72,
            R.drawable.mov73, R.drawable.mov74, R.drawable.mov75,
            R.drawable.mov76, R.drawable.mov77, R.drawable.mov78,
            R.drawable.mov79, R.drawable.mov80, R.drawable.mov81,
            R.drawable.mov82, R.drawable.mov83};

    Integer[] posterTitle = {
            R.string.mov01, R.string.mov02, R.string.mov03,
            R.string.mov04, R.string.mov05, R.string.mov06,
            R.string.mov07, R.string.mov08, R.string.mov09,
            R.string.mov10, R.string.mov11, R.string.mov12,
            R.string.mov13, R.string.mov14, R.string.mov15,
            R.string.mov16, R.string.mov17, R.string.mov18,
            R.string.mov19, R.string.mov20, R.string.mov21,
            R.string.mov22, R.string.mov23, R.string.mov24,
            R.string.mov25, R.string.mov26, R.string.mov27,
            R.string.mov28, R.string.mov29, R.string.mov30,
            R.string.mov31, R.string.mov32, R.string.mov33,
            R.string.mov34, R.string.mov35, R.string.mov36,
            R.string.mov37, R.string.mov38, R.string.mov39,
            R.string.mov40, R.string.mov41, R.string.mov42,
            R.string.mov43, R.string.mov44, R.string.mov45,
            R.string.mov46, R.string.mov47, R.string.mov48,
            R.string.mov49, R.string.mov50, R.string.mov51,
            R.string.mov52, R.string.mov53, R.string.mov54,
            R.string.mov55, R.string.mov56, R.string.mov57,
            R.string.mov58, R.string.mov59, R.string.mov60,
            R.string.mov61, R.string.mov62, R.string.mov63,
            R.string.mov64, R.string.mov65, R.string.mov66,
            R.string.mov67, R.string.mov68, R.string.mov69,
            R.string.mov70, R.string.mov71, R.string.mov72,
            R.string.mov73, R.string.mov74, R.string.mov75,
            R.string.mov76, R.string.mov77, R.string.mov78,
            R.string.mov79, R.string.mov80, R.string.mov81,
            R.string.mov82, R.string.mov83
    };

    public MyGalleryAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return posterId.length;
    }

    @Override
    public Object getItem(int position) {
        return posterTitle[position];
    }

    @Override
    public long getItemId(int position) {
        return posterId[position];
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(new Gallery.LayoutParams(200, 300));

        imageView.setImageResource(posterId[position]);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        return imageView;
    }
}
