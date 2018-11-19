package com.dreamwalkers.elab_yang.mmk.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.dreamwalkers.elab_yang.mmk.R;
import com.dreamwalkers.elab_yang.mmk.adapter.appinfo.TimePointAdapter;
import com.dreamwalkers.elab_yang.mmk.model.TimePoint;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SelectDrugFirstActivity extends AppCompatActivity implements IActivityBased, TimePointAdapter.TimePointClickListener {
    private static final String TAG = "SelectDrugFirstActivity";
    Context mContext;


//    1. 투약 시점을 선택
//    2. checkbox.isCheck() -> cardview 표시
    // TODO: 2018-11-13
//    3. click -> activity넘어가 설정
//    4. 완료되면 cardview에 setAdapter

    // 1번 레이아웃
    @BindView(R.id.layout1)
    RelativeLayout layout1;

    // 2번 레이아웃
    @BindView(R.id.layout2)
    RelativeLayout layout2;

    @BindView(R.id.checkbox1)
    CheckBox checkbox1;

    @BindView(R.id.checkbox2)
    CheckBox checkbox2;

    @BindView(R.id.checkbox3)
    CheckBox checkbox3;

    @BindView(R.id.checkbox4)
    CheckBox checkbox4;

    @BindView(R.id.next_btn)
    Button next_btn;

    @BindView(R.id.recycler_view)
    RecyclerView recyclerview;

    @BindView(R.id.set_btn)
    Button set_btn;

    Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_drug_first);
        mContext = this;
        initSetting();
    }

    @Override
    public void bindView() {
        ButterKnife.bind(this);
    }

    @Override
    public void initSetting() {
        bindView();
        setRecyclerview();
        anim();
    }

    // 1번 layout. --다음--> 이동
    @OnClick(R.id.next_btn)
    void onClick() {
        // 이떄 받아오는거야 뭘뭘했는지


//        Log.d(TAG, "onClick: selected_point_cnt = " + selected_point_cnt);

        // 1번 레이아웃 닫고 2번 연다.
        layout1.setVisibility(View.GONE);
        layout2.setVisibility(View.VISIBLE);
        layout2.startAnimation(animation);
        setAdapter();
    }

    public void setRecyclerview() {
        recyclerview.setHasFixedSize(false);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerview.setLayoutManager(layoutManager);
    }

    public void setAdapter() {
        List<TimePoint> timepoints = new ArrayList<>();

        // 선택된 체크박스 확인 -> 리스트에 추가
        if (checkbox1.isChecked())
            timepoints.add(new TimePoint(checkbox1.getText().toString()));
        if (checkbox2.isChecked())
            timepoints.add(new TimePoint(checkbox2.getText().toString()));
        if (checkbox3.isChecked())
            timepoints.add(new TimePoint(checkbox3.getText().toString()));
        if (checkbox4.isChecked())
            timepoints.add(new TimePoint(checkbox4.getText().toString()));

        Log.d(TAG, "setAdapter: 리스트 갯수 = " + timepoints.size());
        TimePointAdapter mTimePointItems = new TimePointAdapter(this, timepoints);
        mTimePointItems.setOnClickListener(this);
        recyclerview.setAdapter(mTimePointItems);
    }

    @Override
    public void onItemClicked(int position) {
        Toast.makeText(getApplicationContext(), "선택값 = " + position, Toast.LENGTH_SHORT).show();
    }

    public void anim() {
        animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_slide_in_left);
    }

    // 2번 layout. 저장할게욥
    @OnClick(R.id.set_btn)
    void onClick1() {
        // TODO: 2018-11-13 흠흠흠 선택화면으로 넘어가자
//        startActivity(new Intent(this, SelectDrugActivity.class));
        finish();
    }
}
