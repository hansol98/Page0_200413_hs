package com.example.hansol.page0_200413_hs;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class page1 extends AppCompatActivity {
    private LinearLayout container;
    private LinearLayout container2;

    String cat_text = null;   // 카테고리 이름
    String cat_text2 = null;
    String cat_text3 = null;
    String cat_text4 = null;

    Button main_schedule;

    int[] score = new int[8];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page1);

        Intent intent = getIntent();
        if (intent.hasExtra("Main")) {
            score = intent.getIntArrayExtra("Main");
        } else {
            score = intent.getIntArrayExtra("Page9");
        }

        main_schedule = (Button) findViewById(R.id.main_schedule);
        main_schedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "받은 배열:" + score[0] + "," + score[1] + "," + score[2]
                        + "," + score[3] + "," + score[4] + "," + score[5] + "," + score[6], Toast.LENGTH_SHORT).show();
            }
        });
        // 카테고리 노출 기준
        // 2번
        if (score[1] == 0) {
            cat_text = "#문화";
        } else if (score[1] == 1) {
            cat_text = "#자연";
        } else if (score[1] == 2) {
            cat_text = "#음식점";
        } else if (score[1] == 3) {
            cat_text = "#역사";
        }
        // 5번
        if (score[4] == 0) {
            cat_text2 = "#건축/조형";
        } else if (score[4] == 1) {
            cat_text2 = "#문화";
        } else if (score[4] == 2) {
            cat_text2 = "#건축/조형";
            cat_text3 = "#문화";
        }
        // 6번
        if (score[5] == 0) {
            cat_text4 = "#레포츠";
        } else if (score[5] == 1) {
            cat_text4 = "#휴양";
        }

        // 부모 뷰 1 -> 첫 번째 줄
        container = (LinearLayout) findViewById(R.id.course_layout2);
        container2 = (LinearLayout) findViewById(R.id.course_layout3);  // 부모 뷰2 -> 두 번째 줄

        // width, height, gravity설정
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT);
        //params.gravity = Gravity.CENTER_VERTICAL;
        params.weight = 1;
        params.rightMargin = 8;

        // 버튼 동적 생성
        // 2번
        if (cat_text != null) {
            Button cat1 = new Button(this);
            cat1.setText(cat_text);
            cat1.setTextSize(16);
            cat1.setTextColor(Color.BLACK);
            cat1.setLayoutParams(params);
            cat1.setGravity(Gravity.CENTER_VERTICAL);
            cat1.setPadding(16,0,0,0);
            cat1.setHeight(46);
            cat1.setBackgroundResource(R.drawable.box_white);
            container.addView(cat1);    // 부모뷰에 추가

            // 5번
            if (cat_text2 != null) {
                // 문화 겹치면 안뜸
                if (cat_text != cat_text2) {
                    Button cat2 = new Button(this);
                    cat2.setText(cat_text2);
                    cat2.setTextSize(16);
                    cat2.setTextColor(Color.BLACK);
                    cat2.setLayoutParams(params);
                    cat2.setBackgroundResource(R.drawable.box_white);
                    cat2.setHeight(46);
                    cat2.setGravity(Gravity.CENTER_VERTICAL);
                    cat2.setPadding(16,0,0,0);
                    container.addView(cat2);    // 부모뷰에 추가
                }
                if (cat_text != cat_text3) {
                    if (cat_text3 != null) {
                        // cat_text에 값이 있고 cat_text3에 값이 있을 때
                        Button cat3 = new Button(this);
                        cat3.setText(cat_text3);
                        cat3.setTextSize(16);
                        cat3.setTextColor(Color.BLACK);
                        cat3.setLayoutParams(params);
                        cat3.setBackgroundResource(R.drawable.box_white);
                        cat3.setHeight(46);
                        cat3.setGravity(Gravity.CENTER_VERTICAL);
                        cat3.setPadding(16,0,0,0);
                        container2.addView(cat3);    // 부모뷰2에 추가
                    }
                }
            }
        } else { // 2번에 5번 선택했을 때
            if (cat_text2 != null) {
                Button cat2 = new Button(this);
                cat2.setText(cat_text2);
                cat2.setTextSize(16);
                cat2.setTextColor(Color.BLACK);
                cat2.setLayoutParams(params);
                cat2.setBackgroundResource(R.drawable.box_white);
                cat2.setHeight(46);
                cat2.setGravity(Gravity.CENTER_VERTICAL);
                cat2.setPadding(16,0,0,0);
                container.addView(cat2);    // 부모뷰에 추가
            }
            if (cat_text3 != null) {
                Button cat3 = new Button(this);
                cat3.setText(cat_text3);
                cat3.setTextSize(16);
                cat3.setTextColor(Color.BLACK);
                cat3.setLayoutParams(params);
                cat3.setBackgroundResource(R.drawable.box_white);
                cat3.setHeight(46);
                cat3.setGravity(Gravity.CENTER_VERTICAL);
                cat3.setPadding(16,0,0,0);
                container.addView(cat3);    // 부모뷰2에 추가
            }
        }
        // 6번
        // 첫번째 부모뷰에 들어가는 경우
        if (cat_text == null && cat_text3 == null) {
            if (cat_text4 != null) {
                Button cat4 = new Button(this);
                cat4.setText(cat_text4);
                cat4.setTextSize(16);
                cat4.setTextColor(Color.BLACK);
                cat4.setLayoutParams(params);
                cat4.setBackgroundResource(R.drawable.box_white);
                cat4.setHeight(46);
                cat4.setGravity(Gravity.CENTER_VERTICAL);
                cat4.setPadding(16,0,0,0);
                container.addView(cat4);    // 부모뷰에 추가
            }
        } else if (cat_text == cat_text2) {
            Button cat4 = new Button(this);
            cat4.setText(cat_text4);
            cat4.setTextSize(16);
            cat4.setTextColor(Color.BLACK);
            cat4.setLayoutParams(params);
            cat4.setBackgroundResource(R.drawable.box_white);
            cat4.setHeight(46);
            cat4.setGravity(Gravity.CENTER_VERTICAL);
            cat4.setPadding(16,0,0,0);
            container.addView(cat4);    // 부모뷰에 추가
        }
        // 두 번째 부모뷰에 들어가는 경우
        else if (cat_text != null || cat_text3 != null) {
            if (cat_text4 != null) {
                Button cat4 = new Button(this);
                cat4.setText(cat_text4);
                cat4.setTextSize(16);
                cat4.setTextColor(Color.BLACK);
                cat4.setLayoutParams(params);
                cat4.setBackgroundResource(R.drawable.box_white);
                cat4.setHeight(46);
                cat4.setGravity(Gravity.CENTER_VERTICAL);
                cat4.setPadding(16,0,0,0);
                container2.addView(cat4);    // 부모뷰에 추가

                if (cat_text != null && cat_text2 != null && cat_text3 != null && cat_text4 != null) {

                } else {
                    // 빈 버튼 만들기
                        Button cat3_1 = new Button(this);
                        cat3_1.setVisibility(View.INVISIBLE);
                        cat3_1.setLayoutParams(params);
                        container2.addView(cat3_1);
                }
                if (cat_text != cat_text3) {

                } else {
                    // 빈 버튼 만들기
                    Button cat3_1 = new Button(this);
                    cat3_1.setVisibility(View.INVISIBLE);
                    cat3_1.setLayoutParams(params);
                    container2.addView(cat3_1);
                }
            }
        }
    }
}
