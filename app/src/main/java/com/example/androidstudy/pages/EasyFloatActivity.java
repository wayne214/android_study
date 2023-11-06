package com.example.androidstudy.pages;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.androidstudy.R;
import com.lzf.easyfloat.EasyFloat;

public class EasyFloatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy_float);

        EasyFloat.with(this).setLayout(R.layout.float_text).show();

    }
}