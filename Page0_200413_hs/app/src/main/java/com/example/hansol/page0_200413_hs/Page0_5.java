package com.example.hansol.page0_200413_hs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Page0_5 extends AppCompatActivity implements View.OnClickListener {
    TextView a1_round, a2_rest;
    TextView page5_later, page5_back;

    int[] score;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page0_5);

        score = new int[8];

        a1_round = (TextView)findViewById(R.id.page5_a1);
        a2_rest = (TextView)findViewById(R.id.page5_a2);

        page5_later = (TextView)findViewById(R.id.page5_later);
        page5_back = (TextView) findViewById(R.id.page5_back);

        a1_round.setOnClickListener(this);
        a2_rest.setOnClickListener(this);

        page5_later.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Page0_5.this, MainActivity.class);
                startActivity(intent);
            }
        });

        page5_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(Page0_5.this, Page0_4.class);
                //startActivity(intent);
                // 첫 번째 인자: 새로 불러오는 activity효과
                // 두 번째 인자: 현재 activity효과
                finish();
                overridePendingTransition(R.anim.hold, R.anim.anim_slide);
            }
        });

        Intent intent = getIntent();
        score = intent.getIntArrayExtra("Page4");
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(getApplicationContext(), Page0_6.class);
        if (view.getId() == R.id.page5_a1){
            score[3] = 0;
            intent.putExtra("Page5",score);
            Toast.makeText(getApplicationContext(), "받은 배열:" + score[0] + "," + score[1] + "," + score[2]
                    + "," + score[3], Toast.LENGTH_SHORT).show();
        } else if (view.getId() == R.id.page5_a2) {
            score[3] = 1;
            intent.putExtra("Page5",score);
            Toast.makeText(getApplicationContext(), "받은 배열:" + score[0] + "," + score[1] + "," + score[2]
                    + "," + score[3], Toast.LENGTH_SHORT).show();
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
