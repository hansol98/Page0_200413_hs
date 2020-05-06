package com.example.hansol.page0_200413_hs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Page0_9 extends AppCompatActivity {
    TextView result_name, result_sub_name;
    TextView edit_profile, course;

    int[] score = new int[8];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page0_9);

        result_name = (TextView)findViewById(R.id.result);
        result_sub_name = (TextView)findViewById(R.id.type1) ;
        edit_profile = (TextView)findViewById(R.id.edit_profile);
        course = (TextView)findViewById(R.id.course);

        edit_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "프로필 편집 버튼 눌림", Toast.LENGTH_SHORT).show();
            }
        });

        course.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "여행지 입력 버튼 눌림", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), page1.class);
                intent.putExtra("Page9",score);
                startActivity(intent);
            }
        });

        Intent intent = getIntent();
        score = intent.getIntArrayExtra("Page8");

        resultScore();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.hold, R.anim.anim_slide);
    }

    public void resultScore() {
        // 유형 2
        if (score[2] == 0) {
            if (score[3] == 0) {
                result_name.setText("열정 개미 입니다.");
            }
        }

        if (score[2] == 1 && score[3] == 1) {
            result_name.setText("평화로운 나무늘보2 입니다.");
        }

        if (score[2] != score[3]) {
            if (score[6] == 0) {
                result_name.setText("포토그래퍼 수달 입니다.");
            } else if (score[2] == 1) {
                 if (score[2] == 1) {
                    result_name.setText("자유로운 영혼 입니다.");
                }
            } else if (score[2] == 0) {
                result_name.setText("엑셀 인간 입니다.");
            }
        }

        // 유형 1
        if (score[1] == 0) {
            if (score[5] == 0) {
                result_sub_name.setText("액티비티에 관심이 많은");
            }

            if (score[4] == 0 && score[5] == 1) {
                result_sub_name.setText("미지의 세계가 아직 낯선");
                result_name.setText("여행 초심자 - 새싹 입니다.");
            }
            if (score[4] == 1) {
                result_sub_name.setText("트렌드스팟은 꼭 가보는");

                if (score[5] == 0) {
                    result_sub_name.setText("이것저것 궁금한 게 많은");
                    result_name.setText("여행 초심자 - 병아리 입니다.");
                }
            }
            if (score[4] == 2) {
                if (score[5] == 1) {
                    result_sub_name.setText("어디든지 다 좋은");
                }
            }
//            if (score[4] == 1) {
//                result_sub_name.setText("트렌드스팟은 꼭 가보는");
//            }
        }

        if (score[1] == 4) {
            if (score[5] == 0) {
                result_sub_name.setText("액티비티에 관심이 많은");
            }
            if (score[4] == 1) {
                result_sub_name.setText("트렌드스팟은 꼭 가보는");

                if (score[5] == 0) {
                    result_sub_name.setText("이것저것 궁금한 게 많은");
                    result_name.setText("여행 초심자 - 병아리 입니다.");
                }
            }
            if (score[4] == 0 || score[4] == 2) {
                if (score[5] == 1) {
                    result_sub_name.setText("어디든지 다 좋은");
                }
            }
//            if (score[4] == 1) {
//                result_sub_name.setText("트렌드스팟은 꼭 가보는");
//            }
        } else if (score[1] == 1) {
            result_sub_name.setText("자연속에서 힐링하기 좋아하는");
        } else if (score[1] == 3) {
            result_sub_name.setText("역사와 전통에 관심이 많은");
        } else if (score[1] == 2) {
            result_sub_name.setText("금강산도 식후경! 전국 맛집 찾아다니는");
        }

//        // 유형 3
//        if (score[4] == 1 && score[5] == 0) {
//            result_sub_name.setText("이것저것 궁금한 게 많은");
//            result_name.setText("여행 초심자 - 병아리 입니다.");
//        }
     }
}
