package com.example.hansol.page0_200413_hs;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class page1 extends AppCompatActivity {
    private LinearLayout container;
    private LinearLayout container2;
    private LinearLayout city_container;

    String cat_text = null;   // 카테고리 이름
    String cat_text2 = null;
    String cat_text3 = null;
    String cat_text4 = null;

    Button main_schedule;
    Button main_register;
    Button main_like;

    int[] score = new int[8];
    // 도시 저장할 어레이리스트
//    ArrayList<City> cityArrayList = new ArrayList<City>();
    ArrayList<String> cityList = new ArrayList<String>();   // 모든 데이터 다들어감
    ArrayList<String> real_cityList = new ArrayList<String>();  // 중복제거 찐도시 리스트

    // 사진 저장할 어레이리스트
    ArrayList<Integer> cityPicture = new ArrayList<Integer>();  // 모든 데이터 다 들어감
    ArrayList<Integer> real_cityPicture = new ArrayList<Integer>();     // 중복제거 찐 도시사진 리스트

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page1);

        final Intent intent = getIntent();
        // 나중에 하기 버튼 눌렀을 때 임의의 값 넘겨주기
        if (intent.hasExtra("Main")) {
            score = intent.getIntArrayExtra("Main");
        } else {
            // 설문조사 진행 했을 때
            score = intent.getIntArrayExtra("Page9");
        }

        main_schedule = (Button) findViewById(R.id.main_schedule);
        main_register = (Button) findViewById(R.id.main_register);
        main_like = (Button) findViewById(R.id.main_spot);

        main_schedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(getApplicationContext(), Page1_1_1.class);
                startActivity(intent2);
                Toast.makeText(getApplicationContext(), "받은 배열:" + score[0] + "," + score[1] + "," + score[2]
                        + "," + score[3] + "," + score[4] + "," + score[5] + "," + score[6], Toast.LENGTH_SHORT).show();
            }
        });

        main_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(getApplicationContext(), Page1_1.class);
                startActivity(intent2);
            }
        });

        main_like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(getApplicationContext(), Page2_1_1.class);
                startActivity(intent3);
            }
        });

        // height값 dp로 지정해서 넣고 싶을 때
        int dpValue = 96;
        int dpValue2 = 15;
        final Context context = getApplicationContext();
        float d = context.getResources().getDisplayMetrics().density;
        int height = (int) (dpValue * d);
        int city_padding = (int) (dpValue2 * d);
        int city_margin = (int) (16 * d);
        int cat_margin = (int) (8 * d);

        // 카테고리 노출 기준
        // 2번
        if (score[1] == 0) {
            cat_text = "#체험";
            cityList.add("서울");
            cityList.add("부산");
            cityPicture.add(R.drawable.seoul);
            cityPicture.add(R.drawable.busan);
        } else if (score[1] == 1) {
            cat_text = "#자연";
            cityList.add("가평");
            cityList.add("강릉");
            cityPicture.add(R.drawable.gapyeong);
            cityPicture.add(R.drawable.gangneung);
        } else if (score[1] == 2) {
            cat_text = "#음식점";
            cityList.add("광주");
            cityList.add("대구");
            cityPicture.add(R.drawable.gwangju);
            cityPicture.add(R.drawable.daegu);
        } else if (score[1] == 3) {
            cat_text = "#역사";
            cityList.add("서울");
            cityList.add("경주");
            cityPicture.add(R.drawable.seoul);
            cityPicture.add(R.drawable.gyeongju);
        } else if (score[1] == 4) {
            cityList.add("서울");
            cityList.add("부산");
            cityList.add("강릉");
            cityList.add("순천");
            cityList.add("전주");
            cityList.add("여수");
            cityPicture.add(R.drawable.seoul);
            cityPicture.add(R.drawable.busan);
            cityPicture.add(R.drawable.gangneung);
            cityPicture.add(R.drawable.suncheon);
            cityPicture.add(R.drawable.jeonju);
            cityPicture.add(R.drawable.yeosu);
        }
        // 5번
        if (score[4] == 0) {
            cat_text2 = "#건축/조형";
            cityList.add("서울");
            cityList.add("부산");
            cityPicture.add(R.drawable.seoul);
            cityPicture.add(R.drawable.busan);
        } else if (score[4] == 1) {
            cat_text2 = "#체험";
            cityList.add("서울");
            cityList.add("부산");
            cityPicture.add(R.drawable.seoul);
            cityPicture.add(R.drawable.busan);
        } else if (score[4] == 2) {
            cat_text2 = "#건축/조형";
            cat_text3 = "#체험";
            cityList.add("서울");
            cityList.add("부산");
            cityPicture.add(R.drawable.seoul);
            cityPicture.add(R.drawable.busan);
        }
        // 6번
        if (score[5] == 0) {
            cat_text4 = "#레포츠";
            cityList.add("가평");
            cityList.add("단양");
            cityPicture.add(R.drawable.gapyeong);
            cityPicture.add(R.drawable.danyang);
        } else if (score[5] == 1) {
            cat_text4 = "#휴양";
            cityList.add("울산");
            cityList.add("평창");
            cityPicture.add(R.drawable.ulsan);
            cityPicture.add(R.drawable.pyeonchang);
        }

        // !!!!! 취향 카테고리 동적 생성 !!!!!
        // 부모 뷰 1 -> 첫 번째 줄
        container = (LinearLayout) findViewById(R.id.course_layout2);
        container2 = (LinearLayout) findViewById(R.id.course_layout3);  // 부모 뷰2 -> 두 번째 줄

        // width, height, gravity설정
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT);
        //params.gravity = Gravity.CENTER_VERTICAL;
        params.weight = 1;
        params.rightMargin = cat_margin;

        // 버튼 동적 생성
        // 2번
        if (cat_text != null) {
            Button cat1 = new Button(this);
            cat1.setText(cat_text);
            cat1.setTextSize(16);
            cat1.setTextColor(Color.BLACK);
            cat1.setLayoutParams(params);
            cat1.setGravity(Gravity.CENTER_VERTICAL);
            cat1.setPadding(city_margin,0,0,0);
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
                    cat2.setPadding(city_margin,0,0,0);
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
                        cat3.setPadding(city_margin,0,0,0);
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
                cat2.setPadding(city_margin,0,0,0);
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
                cat3.setPadding(city_margin,0,0,0);
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
                cat4.setPadding(city_margin,0,0,0);
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
            cat4.setPadding(city_margin,0,0,0);
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
                cat4.setPadding(city_margin,0,0,0);
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

        // !!!!! 도시 동적 생성 !!!!!
        // 부모 뷰
        city_container = (LinearLayout) findViewById(R.id.main_city_layout);

        // width, height, gravity설정
        LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(height, height);
        //params.gravity = Gravity.CENTER_VERTICAL;
        params2.weight = 1;
        params2.rightMargin = city_margin;


        // 리스트 속 중복 제거 하나하나 비교
        for (int j = 0 ; j < cityList.size() ; j++) {
            if (!real_cityList.contains(cityList.get(j))) {
                real_cityList.add(cityList.get(j).toString());
            }
        }

        // 사진 리스트 속 중복 제거
        for (int i = 0 ; i < cityPicture.size() ; i++) {
            if (!real_cityPicture.contains(cityPicture.get(i))) {
                real_cityPicture.add(cityPicture.get(i));
            }
        }

        for (int i = 0 ; i < real_cityList.size() ; i++) {
            TextView cityName = new TextView(this);
            cityName.setHeight(height);
            cityName.setWidth(height);

            // 이름 지정 및 가져오기
            City city = new City();
            city.setCityName(real_cityList.get(i).toString());

            cityName.setText(city.getCityName());

            // 백그라운드 사진 가져오기
            city.setCityPic(real_cityPicture.get(i));
            cityName.setBackgroundResource(city.getCityPic());

            Typeface typeface = getResources().getFont(R.font.notosans_bold);
            cityName.setTypeface(typeface);

            cityName.setTextSize(12);
            cityName.setPadding(city_padding,city_padding,city_padding,city_padding);
            cityName.setTextColor(Color.WHITE);
            cityName.setTypeface(cityName.getTypeface(), Typeface.BOLD);
            cityName.setShadowLayer(5, 0, 0, Color.DKGRAY);

//            cityName.setBackgroundResource(R.drawable.round_white);
            cityName.setGravity(Gravity.CENTER | Gravity.BOTTOM);
            cityName.setLayoutParams(params2);
            city_container.addView(cityName);
        }
    }

    public class City {
        private String cityName;
        private int cityPic;

        public String getCityName() {
            return cityName;
        }

        public void setCityName(String cityName) {
            this.cityName = cityName;
        }

        public int getCityPic() {
            return cityPic;
        }

        public void setCityPic(int cityPic) {
            this.cityPic = cityPic;
        }
    }
}