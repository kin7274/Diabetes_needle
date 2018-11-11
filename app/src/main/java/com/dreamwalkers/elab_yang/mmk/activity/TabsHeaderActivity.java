package com.dreamwalkers.elab_yang.mmk.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.dreamwalkers.elab_yang.mmk.R;
import com.dreamwalkers.elab_yang.mmk.adapter.DessertAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TabsHeaderActivity extends AppCompatActivity implements IActivityBased {

    @BindView(R.id.htab_toolbar)
    Toolbar toolbar;
    @BindView(R.id.htab_viewpager)
    ViewPager viewPager;
    @BindView(R.id.htab_tabs)
    TabLayout tabLayout;


//    final Fragment fragment1 = new AddDeviceFragment();
//    final Fragment fragment2 = new SetInsulinFragment();
//    final Fragment fragment3 = new ConnectFragment();
//    final Fragment fragment4 = new TodayDataFragment();
//    final Fragment fragment5 = new TotalDataFragment();

//    final FragmentManager fm = getSupportFragmentManager();
    // default;
//    Fragment active = fragment1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabs_header);

        initSetting();


    }

    @Override
    public void bindView() {
        ButterKnife.bind(this);

    }

    @Override
    public void initSetting() {
        bindView();
        setToolbar();
        set();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    // 툴바
    private void setToolbar() {
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("대한민국의 어머니들");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    private void set() {
        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);

//        final CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.htab_collapse_toolbar);
    }

    // 뷰페이저 설정(5)
    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new DummyFragment(
                ContextCompat.getColor(this, R.color.ergo_colorPrimary)), "Add device");
        adapter.addFrag(new DummyFragment(
                ContextCompat.getColor(this, R.color.weaker_blue)), "Set insulin");
        adapter.addFrag(new DummyFragment(
                ContextCompat.getColor(this, R.color.colorAccent)), "Connect");
        adapter.addFrag(new DummyFragment(
                ContextCompat.getColor(this, R.color.lime)), "Recent");
        adapter.addFrag(new DummyFragment(
                ContextCompat.getColor(this, R.color.weaker_yellow)), "Database");
        viewPager.setAdapter(adapter);
    }


    private static class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        // 추가
        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        // pos 반환
        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

    public static class DummyFragment extends Fragment {
        int color;

        public DummyFragment() {
        }

        @SuppressLint("ValidFragment")
        public DummyFragment(int color) {
            this.color = color;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.dummy_fragment, container, false);

            final FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.dummyfrag_bg);
            frameLayout.setBackgroundColor(color);

            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.dummyfrag_scrollableview);

            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity().getBaseContext());
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setHasFixedSize(true);

            DessertAdapter adapter = new DessertAdapter(getContext());
            recyclerView.setAdapter(adapter);

            return view;
        }
    }

}
