package com.example.hansol.page0_200413_hs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Page0_4 extends AppCompatActivity implements View.OnClickListener {
    TextView a1_plan, a2_free;
    TextView page4_later, page4_back;

    int[] score;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page0_4);

        score = new int[8];

        a1_plan = (TextView)findViewById(R.id.page4_a1);
        a2_free = (TextView)findViewById(R.id.page4_a2);

        page4_later = (TextView)findViewById(R.id.page4_later);
        page4_back = (TextView) findViewById(R.id.page4_back);

        a1_plan.setOnClickListener(this);
        a2_free.setOnClickListener(this);

        page4_later.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Page0_4.this, MainActivity.class);
                startActivity(intent);
            }
        });

        page4_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(Page0_4.this, Page0_3.class);
//                startActivity(intent);
                // 첫 번째 인자: 새로 불러오는 activity효과
                // 두 번째 인자: 현재 activity효과
                finish();
                overridePendingTransition(R.anim.hold, R.anim.anim_slide);
            }
        });

        Intent intent = getIntent();
        score = intent.getIntArrayExtra("Page3");
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(getApplicationContext(), Page0_5.class);
        if (view.getId() == R.id.page4_a1){
            score[2] = 0;
            intent.putExtra("Page4",score);
            Toast.makeText(getApplicationContext(), "받은 배열:" + score[0] + "," + score[1]+ "," + score[2], Toast.LENGTH_SHORT).show();
        } else if (view.getId() == R.id.page4_a2) {
            score[2] = 1;
            intent.putExtra("Page4",score);
            Toast.makeText(getApplicationContext(), "받은 배열:" + score[0] + "," + score[1]+ "," + score[2], Toast.LENGTH_SHORT).show();
        }

        startActivity(intent);
        // finish();
        overridePendingTransition(R.anim.anim_slide_out, R.anim.hold);
    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
//        overridePendingTransition(R.anim.hold, R.anim.anim_slide);
    }
}
