package com.example.hansol.page0_200413_hs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Page0_7 extends AppCompatActivity implements View.OnClickListener {
    TextView a1_activity, a2_noAc;
    TextView page7_later, page7_back;

    int[] score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page0_7);

        score = new int[8];

        a1_activity = (TextView)findViewById(R.id.page7_a1);
        a2_noAc = (TextView)findViewById(R.id.page7_a2);

        page7_later = (TextView)findViewById(R.id.page7_later);
        page7_back = (TextView) findViewById(R.id.page7_back);

        a1_activity.setOnClickListener(this);
        a2_noAc.setOnClickListener(this);

        page7_later.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Page0_7.this, MainActivity.class);
                startActivity(intent);
            }
        });

        page7_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(Page0_7.this, Page0_6.class);
//                startActivity(intent);
                // 첫 번째 인자: 새로 불러오는 activity효과
                // 두 번째 인자: 현재 activity효과
                finish();
                overridePendingTransition(R.anim.hold, R.anim.anim_slide);
            }
        });

        Intent intent = getIntent();
        score = intent.getIntArrayExtra("Page6");
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(getApplicationContext(), Page0_8.class);
        if (view.getId() == R.id.page7_a1){
            score[5] = 0;
            intent.putExtra("Page7",score);
            Toast.makeText(getApplicationContext(), "받은 배열:" + score[0] + "," + score[1] + "," + score[2]
                    + "," + score[3] + "," + score[4] + "," + score[5], Toast.LENGTH_SHORT).show();
        } else if (view.getId() == R.id.page7_a2) {
            score[5] = 1;
            intent.putExtra("Page7",score);
            Toast.makeText(getApplicationContext(), "받은 배열:" + score[0] + "," + score[1] + "," + score[2]
                    + "," + score[3] + "," + score[4] + "," + score[5], Toast.LENGTH_SHORT).show();
        }

        startActivity(intent);
        //finish();
        overridePendingTransition(R.anim.anim_slide_out, R.anim.hold);
    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
//        overridePendingTransition(R.anim.hold, R.anim.anim_slide);
    }
}
