package com.example.androidstudy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.androidstudy.adapter.MyRecyclerAdapter;
import com.example.androidstudy.bean.TestData;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MyRecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        initViews();
        initListener();
    }

    private void initListener() {
        adapter.setItemCellClicker(tag -> Toast.makeText(RecyclerViewActivity.this, tag, Toast.LENGTH_SHORT).show());
    }

    private void initViews() {
        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        List<String> sss = new ArrayList<>();
        sss.add("重型卡车1");
        sss.add("重车11");
        sss.add("重型卡车3445");
        sss.add("重型卡车6677");
        List<String> sss1 = new ArrayList<>();
        sss1.add("轻型卡车1");
        sss1.add("轻车11");
        sss1.add("轻型卡车3445");
        sss1.add("轻型卡车6677");

        List<String> sss2 = new ArrayList<>();
        sss2.add("其他1");
        sss2.add("其他2");

        List<String> sss3 = new ArrayList<>();
        sss3.add("轻型卡车333");
        sss3.add("轻车33");
        sss3.add("轻型卡车3333");
        sss3.add("轻型卡车3355");
        sss3.add("轻型卡车3366");
        sss3.add("轻型卡车3377");
        sss3.add("轻型卡车3388");
        sss3.add("轻型卡车3399");


        List<String> sss4 = new ArrayList<>();
        sss4.add("轻型卡车44");
        sss4.add("轻车44");
        sss4.add("轻型卡车4445");
        sss4.add("轻型卡车4477");
        sss4.add("轻型卡车4466");
        sss4.add("轻型卡车4488");
        sss4.add("轻型卡车4499");
        sss4.add("轻型卡车4410");
        List<TestData> list = new ArrayList<>();
        list.add(new TestData("重型",sss));
        list.add(new TestData("轻型", sss1));
        list.add(new TestData("其他2", sss2));
        list.add(new TestData("其他3", sss3));
        list.add(new TestData("其4", sss4));
        adapter = new MyRecyclerAdapter(this, list);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}