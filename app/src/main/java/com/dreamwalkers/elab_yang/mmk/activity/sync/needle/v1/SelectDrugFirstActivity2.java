package com.dreamwalkers.elab_yang.mmk.activity.sync.needle.v1;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.dreamwalkers.elab_yang.mmk.R;
import com.dreamwalkers.elab_yang.mmk.activity.IActivityBased;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SelectDrugFirstActivity2 extends AppCompatActivity implements IActivityBased {
    int PAGE_MAX = 4;
    Fragment current_fragment = new Fragment();

    @BindView(R.id.viewPager)
    ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_drug_first2);
        initSetting();
    }

    @Override
    public void bindView() {
        ButterKnife.bind(this);
    }

    @Override
    public void initSetting() {
        bindView();
        viewPager.setAdapter(new adapter(getSupportFragmentManager()));
    }

    private class adapter extends FragmentPagerAdapter {
        public adapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if (position < 0 || PAGE_MAX <= position) return null;
            switch (position) {
                case 0:
                    current_fragment = new page1();
                    break;

                case 1:
                    current_fragment = new page2();
                    break;

                case 2:
                    current_fragment = new page3();
                    break;

                case 3:
                    current_fragment = new page4();
                    break;
            }

            return current_fragment;
        }

        @Override
        public int getCount() {
            return PAGE_MAX;
        }
    }
}


