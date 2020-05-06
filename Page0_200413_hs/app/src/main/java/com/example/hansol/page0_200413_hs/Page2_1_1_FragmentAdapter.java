package com.example.hansol.page0_200413_hs;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class Page2_1_1_FragmentAdapter extends FragmentPagerAdapter {

    // 뷰페이져에 들어갈 프레그먼트들 담을 어레이리스트
    private ArrayList<Fragment> fragments = new ArrayList<>();

    // 필수 생성자
    public Page2_1_1_FragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    // 어레이에 추가 할 수 있는 함수
    void addItem(Fragment fragment) {
        fragments.add(fragment);
    }
}
