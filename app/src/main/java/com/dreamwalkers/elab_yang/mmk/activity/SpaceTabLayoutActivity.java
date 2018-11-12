package com.dreamwalkers.elab_yang.mmk.activity;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.dreamwalkers.elab_yang.mmk.R;
import com.dreamwalkers.elab_yang.mmk.activity.IActivityBased;
import com.dreamwalkers.elab_yang.mmk.activity.fragment.FragmentA;
import com.dreamwalkers.elab_yang.mmk.activity.fragment.FragmentB;
import com.dreamwalkers.elab_yang.mmk.activity.fragment.FragmentC;
import com.dreamwalkers.elab_yang.mmk.activity.fragment.FragmentD;

import java.util.ArrayList;
import java.util.List;

import eu.long1.spacetablayout.SpaceTabLayout;

public class SpaceTabLayoutActivity extends AppCompatActivity implements IActivityBased {
    SpaceTabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        initSetting();
    }

    @Override
    public void bindView() {
    }

    @Override
    public void initSetting() {
//        bindView();
        setStatusbar();
        set();
    }

    public void setStatusbar() {
        View view = getWindow().getDecorView();
        view.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        getWindow().setStatusBarColor(getResources().getColor(R.color.background));
    }

    private void set() {
        //add the fragments you want to display in a List == 내가 원하면 추가가능하다~ 이말이야
        List<Fragment> fragmentList = new ArrayList<>();
        // 홈 = 기록보기
        fragmentList.add(new FragmentA());
        // 장치 관리 + 동기화
        fragmentList.add(new FragmentB());
        //
        fragmentList.add(new FragmentC());
        // 프로필
        fragmentList.add(new FragmentD());

        // set
        final CoordinatorLayout coordinatorLayout = (CoordinatorLayout) findViewById(R.id.activity_main);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        tabLayout = (SpaceTabLayout) findViewById(R.id.spaceTabLayout);

        tabLayout.initialize(viewPager, getSupportFragmentManager(), fragmentList, null);

        tabLayout.setTabOneOnClickListener(v -> {
            Snackbar snackbar = Snackbar
                    .make(coordinatorLayout, "Welcome to SpaceTabLayout", Snackbar.LENGTH_SHORT);
            snackbar.show();
        });
        tabLayout.setOnClickListener(v -> Toast.makeText(getApplication(), "" + tabLayout.getCurrentPosition(), Toast.LENGTH_SHORT).show());
    }
}
