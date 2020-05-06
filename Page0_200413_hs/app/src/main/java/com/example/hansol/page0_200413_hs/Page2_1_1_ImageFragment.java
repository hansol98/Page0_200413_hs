package com.example.hansol.page0_200413_hs;

import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class Page2_1_1_ImageFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.page2_1_1_fragment_image, container, false);

        ImageView imageView = view.findViewById(R.id.page2_1_1_imageView);

        if (getArguments() != null) {
            Bundle args = getArguments();
            // Page2_1_1에서 받아온 리소스 이미지뷰에 셋팅
            imageView.setImageResource(args.getInt("imgRes"));
        }

        return view;
    }
}
