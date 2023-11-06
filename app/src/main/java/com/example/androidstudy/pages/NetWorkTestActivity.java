package com.example.androidstudy.pages;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.androidstudy.R;
import com.example.androidstudy.bean.ArticleEntry;
import com.example.androidstudy.bean.ResultInfo;
import com.example.androidstudy.utils.JsonUtil;
import com.example.androidstudy.utils.NetUtils;

import java.util.List;

public class NetWorkTestActivity extends AppCompatActivity {

    private static final String TAG = "NetWorkTestActivity";

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net_work_test);

        textView = findViewById(R.id.tv_content);

        new Thread(new Runnable() {
            @Override
            public void run() {
                NetUtils.getNetUtils().request("https://www.wanandroid.com/article/list/0/json", new NetUtils.ResultCallback() {
                    @Override
                    public void success(String s) {
                        ResultInfo resultInfo = JsonUtil.parseJson(s, ResultInfo.class);
                        Log.d(TAG, "success: ");

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                List<ArticleEntry> datas = resultInfo.getDataInfo().getDatas();
                                ArticleEntry articleEntry = datas.get(0);

                                textView.setText("" + articleEntry.getTitle());
                            }
                        });
                    }

                    @Override
                    public void failed() {

                    }
                });
            }
        }).start();

    }
}