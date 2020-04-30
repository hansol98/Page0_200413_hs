package com.example.hansol.page0_200413_hs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Page0_3 extends AppCompatActivity implements View.OnClickListener {
    TextView a1_city;
    TextView a2_nature;
    TextView a3_food;
    TextView a4_history;
    TextView a5_all;

    TextView page3_later;
    Button page3_back;

    int[] score = new int[8];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page0_3);

        a1_city = (TextView)findViewById(R.id.page3_a1);
        a2_nature = (TextView)findViewById(R.id.page3_a2);
        a3_food = (TextView)findViewById(R.id.page3_a3);
        a4_history = (TextView)findViewById(R.id.page3_a4);
        a5_all = (TextView)findViewById(R.id.page3_a5);

        page3_later = (TextView)findViewById(R.id.page3_later);
        page3_back = (Button) findViewById(R.id.page3_back);

        a1_city.setOnClickListener(this);
        a2_nature.setOnClickListener(this);
        a3_food.setOnClickListener(this);
        a4_history.setOnClickListener(this);
        a5_all.setOnClickListener(this);

        page3_later.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Page0_3.this, MainActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.hold, R.anim.anim_slide);
            }
        });

        page3_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(Page0_3.this, Page0_2.class);
//                startActivity(intent);
                // 첫 번째 인자: 새로 불러오는 activity효과
                // 두 번째 인자: 현재 activity효과
                finish();
                overridePendingTransition(R.anim.hold, R.anim.anim_slide);
            }
        });

        Intent intent = getIntent();
        score = intent.getIntArrayExtra("Page2");
    }

    public void onClick(View view) {
        Intent intent = new Intent(getApplicationContext(), Page0_4.class);

        if (view.getId() == R.id.page3_a1){
            score[1] = 0;
            intent.putExtra("Page3",score);
            Toast.makeText(getApplicationContext(), "받은 배열:" + score[0] + "," + score[1], Toast.LENGTH_SHORT).show();
        } else if (view.getId() == R.id.page3_a2) {
            score[1] = 1;
            intent.putExtra("Page3",score);
            Toast.makeText(getApplicationContext(), "받은 배열:" + score[0] + "," + score[1], Toast.LENGTH_SHORT).show();
        } else if (view.getId() == R.id.page3_a3) {
            score[1] = 2;
            intent.putExtra("Page3",score);
            Toast.makeText(getApplicationContext(), "받은 배열:" + score[0] + "," + score[1], Toast.LENGTH_SHORT).show();
        } else if (view.getId() == R.id.page3_a4) {
            score[1] = 3;
            intent.putExtra("Page3", score);
            Toast.makeText(getApplicationContext(), "받은 배열:" + score[0] + "," + score[1], Toast.LENGTH_SHORT).show();
        }else if (view.getId() == R.id.page3_a5) {
            score[1] = 4;
            intent.putExtra("Page3", score);
            Toast.makeText(getApplicationContext(), "받은 배열:" + score[0] + "," + score[1], Toast.LENGTH_SHORT).show();
        }

        startActivity(intent);
        overridePendingTransition(R.anim.anim_slide_out, R.anim.hold);
    }

    @Override
    public void onBackPressed() {
        // super.onBackPressed();
    }
}
