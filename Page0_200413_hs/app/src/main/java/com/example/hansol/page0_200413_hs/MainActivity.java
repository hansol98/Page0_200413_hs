package com.example.hansol.page0_200413_hs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView btn_later;
    TextView btn_start;

    int[] score = new int[8];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_later = (TextView) findViewById(R.id.later_btn);
        btn_start = (TextView) findViewById(R.id.start_btn);

        // 시작하기 버튼 눌렀을 때
        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (MainActivity.this, Page0_2.class);
                startActivity(intent);
                // 액티비티 전환 효과
                overridePendingTransition(R.anim.anim_slide_out, R.anim.hold);
            }
        });

        // 나중에 하기 버튼 눌렀을 때
        btn_later.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "나중에 하기 버튼 눌림", Toast.LENGTH_SHORT).show();
                score[1] = 3; score[4] = 1; score[5] = 0;
                Intent intent = new Intent(MainActivity.this, page1.class);
                intent.putExtra("Main", score);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.anim_slide, R.anim.hold);
    }
}
