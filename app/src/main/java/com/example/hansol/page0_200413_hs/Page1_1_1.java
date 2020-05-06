package com.example.hansol.page0_200413_hs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Page1_1_1 extends AppCompatActivity {
    private Page1_1_1_Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page1_1_1);

        init();

        getData();
    }

    private void init() {
        RecyclerView recyclerView = findViewById(R.id.page1_1_1_recyclerView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        adapter = new Page1_1_1_Adapter();
        recyclerView.setAdapter(adapter);
    }

    private void getData() {
        List<String> listTitle = Arrays.asList("서울", "전주", "군산", "여주");

        for (int i = 0 ; i < listTitle.size() ; i++) {
            Data data = new Data();
            data.setCity(listTitle.get(i));

            adapter.addItem(data);
        }
        adapter.notifyDataSetChanged();
    }
}
