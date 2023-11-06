package com.example.androidstudy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.jakewharton.rxbinding2.widget.RxTextView;

import java.util.concurrent.TimeUnit;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;

public class InputDebounceActivity extends AppCompatActivity {

    TextView textView;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_debounce);
        textView = findViewById(R.id.tv_text);
        editText = findViewById(R.id.et_amount);

        //监听输入框的值
        RxTextView.textChanges(editText)
                .debounce(500, TimeUnit.MILLISECONDS)//去抖动
                .observeOn(AndroidSchedulers.mainThread())
                //CharSequence转换为String
                .map(CharSequence::toString)
                .subscribe(s -> {
                    //这里可以查询数据库或请求服务器查询
                    textView.setText(s);
                });
    }
}