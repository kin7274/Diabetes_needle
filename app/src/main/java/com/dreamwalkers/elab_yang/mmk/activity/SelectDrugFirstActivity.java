package com.dreamwalkers.elab_yang.mmk.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RelativeLayout;

import com.dreamwalkers.elab_yang.mmk.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SelectDrugFirstActivity extends AppCompatActivity implements IActivityBased {

    @BindView(R.id.timepoint_first)
    RelativeLayout timepoint_first;

    @BindView(R.id.timepoint_second)
    RelativeLayout timepoint_second;

    @BindView(R.id.timepoint_third)
    RelativeLayout timepoint_third;

    @BindView(R.id.timepoint_forth)
    RelativeLayout timepoint_forth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_drug_first);
        initSetting();
    }

    @Override
    public void bindView() {
        ButterKnife.bind(this);
    }

    @Override
    public void initSetting() {
        bindView();
    }

    @OnClick(R.id.timepoint_first)
    void onClick() {
        // 공복전

        }
}
