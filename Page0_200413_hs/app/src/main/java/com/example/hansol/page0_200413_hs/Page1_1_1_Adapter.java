package com.example.hansol.page0_200413_hs;

import android.animation.ValueAnimator;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Page1_1_1_Adapter extends RecyclerView.Adapter<Page1_1_1_Adapter.ItemViewHolder> {
    private Context context;

    // 어댑터에 들어갈 리스트
    private ArrayList<Data> listData = new ArrayList<>();

    // 아이템 클릭 상태 저장하는 array
    private SparseBooleanArray selectedItems = new SparseBooleanArray();
    //직전에 클릭됐던 Item의 position
    private int prePosition = -1;

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        // item뷰 inflate 시키기
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_page1_1_1_item, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        // 아이템 하나하나 바인딩해줌
        holder.onBind(listData.get(position), position);
    }

    @Override
    public int getItemCount() {
        // 리스트의 총 개수
        return listData.size();
    }

    // 외부에서 데이터 저장 가능
    void addItem(Data data) {
        listData.add(data);
    }

    class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView city;
        private TextView cityNum;
        private TextView imageView2;
        private TextView togle;

        private Data data;
        private int position;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);

            city = itemView.findViewById(R.id.page1_1_1_city);
            cityNum = itemView.findViewById(R.id.page1_1_1_city_number);
            togle = itemView.findViewById(R.id.page1_1_1_togle);
            imageView2 = itemView.findViewById(R.id.imageView2);
        }

        void onBind(Data data, int position) {
            this.data = data;
            this.position = position;

            city.setText(data.getCity());
            cityNum.setText(data.getCityNum());

            changeVisibility(selectedItems.get(position));

            itemView.setOnClickListener(this);
            cityNum.setOnClickListener(this);
            city.setOnClickListener(this);
            imageView2.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.linearItem:
                    Toast.makeText(context, data.getCity() + "선택됨", Toast.LENGTH_SHORT).show();
                    if (selectedItems.get(position)) {
                        // item 클릭 시
                        selectedItems.delete(position);
                    } else {
                        // 직전에 클릭 된 item의 클릭 삭제
                        selectedItems.delete(prePosition);
                        // 클릭한 item position 저장
                        selectedItems.put(position, true);
                    }

                    // 해당 포지션의 변화 알림
                    if (prePosition != -1) notifyItemChanged(prePosition);
                    notifyItemChanged(position);

                    // 클릭된 포지션 저장
                    prePosition = position;
                    break;
            }
        }

        // 클릭된 아이템 상태 변경
        // 펼칠 것 인지 아닌지
        private void changeVisibility (final boolean isExpanded) {
            // height값 dp로 지정해서 넣고 싶을 때
            int dpValue = 150;
            float d = context.getResources().getDisplayMetrics().density;
            int height = (int) (dpValue * d);

            // ValueAnimator.ofInt(int... values)는 View가 변할 값을 지정, 인자는 int 배열
            ValueAnimator va = isExpanded ? ValueAnimator.ofInt(0, height) : ValueAnimator.ofInt(height, 0);
            va.setDuration(600);
            va.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    // value는 height 값
                    int value = (int) animation.getAnimatedValue();
                    // imageView의 높이 변경
                    imageView2.getLayoutParams().height = value;
                    imageView2.requestLayout();
                    // imageView가 실제로 사라지게하는 부분
                    imageView2.setVisibility(isExpanded ? View.VISIBLE : View.GONE);
                }
            });
            // Animation start
            va.start();
        }
    }
}
