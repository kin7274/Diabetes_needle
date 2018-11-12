package com.dreamwalkers.elab_yang.mmk.activity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
<<<<<<< HEAD
=======
import android.util.Log;
>>>>>>> refs/remotes/kin7274/master
import android.view.View;
import android.widget.Toast;

import com.dreamwalkers.elab_yang.mmk.R;
import com.dreamwalkers.elab_yang.mmk.activity.fragment.FragmentA;
import com.dreamwalkers.elab_yang.mmk.activity.fragment.FragmentB;
import com.dreamwalkers.elab_yang.mmk.activity.fragment.FragmentC;
import com.dreamwalkers.elab_yang.mmk.activity.fragment.FragmentD;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import eu.long1.spacetablayout.SpaceTabLayout;

public class SpaceTabLayoutActivity extends AppCompatActivity implements IActivityBased {
<<<<<<< HEAD

    @BindView(R.id.spaceTabLayout)
=======
    private static final String TAG = "SpaceTabLayoutActivity";
>>>>>>> refs/remotes/kin7274/master
    SpaceTabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        initSetting();
    }

    @Override
    public void bindView() {
        ButterKnife.bind(this);
    }

    @Override
    public void initSetting() {
        bindView();
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
        //
        fragmentList.add(new FragmentB());
        // 장치 관리 + 동기화
        fragmentList.add(new FragmentC());
        // 프로필
        fragmentList.add(new FragmentD());

        // set
        final CoordinatorLayout coordinatorLayout = (CoordinatorLayout) findViewById(R.id.activity_main);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);


        tabLayout.initialize(viewPager, getSupportFragmentManager(), fragmentList, null);

<<<<<<< HEAD
        tabLayout.setTabOneOnClickListener(v -> {
            Snackbar.make(coordinatorLayout, "Welcome to SpaceTabLayout", Snackbar.LENGTH_SHORT).show();
        });
        tabLayout.setOnClickListener(v -> {
            Toast.makeText(this, "" + tabLayout.getCurrentPosition(), Toast.LENGTH_SHORT).show();
=======
        tabLayout.setTabOneOnClickListener(v -> Snackbar.make(coordinatorLayout, "안녕", Snackbar.LENGTH_SHORT).show());
        tabLayout.setOnClickListener((View v) -> {
            Toast.makeText(getApplication(), "" + tabLayout.getCurrentPosition(), Toast.LENGTH_SHORT).show();
            Log.d(TAG, "set: tabLayout.getCurrentPosition() = " + tabLayout.getCurrentPosition());
            if (tabLayout.getCurrentPosition() == 2) {
                Log.d(TAG, "set: 여기!!");
                Intent intent = new Intent(this, NeedleScanActivity.class);
                startActivity(intent);
                intent.putExtra("flag_toFragment", false);

            }
>>>>>>> refs/remotes/kin7274/master
        });
    }
}
