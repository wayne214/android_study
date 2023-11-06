package com.example.androidstudy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.androidstudy.pages.EasyFloatActivity;
import com.example.androidstudy.pages.NetWorkTestActivity;

public class MainActivity extends AppCompatActivity {

    Button btnList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initListeners();
    }

    private void initListeners() {
        btnList.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, RecyclerViewActivity.class)));

        findViewById(R.id.btn_pic).setOnClickListener(view -> startActivity(new Intent(MainActivity.this, PictureActivity.class)));

        findViewById(R.id.btn_debounce).setOnClickListener(view -> startActivity(new Intent(MainActivity.this, InputDebounceActivity.class)));

        findViewById(R.id.btn_network).setOnClickListener(view -> startActivity(new Intent(MainActivity.this, NetWorkTestActivity.class)));

        findViewById(R.id.btn_easyFloat).setOnClickListener(view -> startActivity(new Intent(MainActivity.this, EasyFloatActivity.class)));
    }

    private void initViews() {
        btnList = findViewById(R.id.btn_list);
    }
}