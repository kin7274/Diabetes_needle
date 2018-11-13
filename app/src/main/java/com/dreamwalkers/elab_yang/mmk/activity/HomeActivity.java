package com.dreamwalkers.elab_yang.mmk.activity;

import android.app.Fragment;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.dreamwalker.slidedrawer.SlidingRootNav;
import com.dreamwalker.slidedrawer.SlidingRootNavBuilder;
import com.dreamwalkers.elab_yang.mmk.R;
import com.dreamwalkers.elab_yang.mmk.activity.fragment.FragmentA;
import com.dreamwalkers.elab_yang.mmk.activity.fragment.FragmentB;
import com.dreamwalkers.elab_yang.mmk.activity.fragment.FragmentC;
import com.dreamwalkers.elab_yang.mmk.activity.fragment.FragmentD;
import com.dreamwalkers.elab_yang.mmk.activity.select.SelectDrugActivity;
import com.dreamwalkers.elab_yang.mmk.menu.DrawerAdapter;
import com.dreamwalkers.elab_yang.mmk.menu.DrawerItem;
import com.dreamwalkers.elab_yang.mmk.menu.SimpleItem;
import com.dreamwalkers.elab_yang.mmk.menu.SpaceItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import eu.long1.spacetablayout.SpaceTabLayout;
import io.paperdb.Paper;

public class HomeActivity extends AppCompatActivity implements DrawerAdapter.OnItemSelectedListener {


    @BindView(R.id.toolbar)
    Toolbar myToolbar;
    @BindView(R.id.spaceTabLayout)
    SpaceTabLayout tabLayout;

    private static final String TAG = "HomeActivity";

    private static final int POS_DASHBOARD = 0;
    private static final int POS_ACCOUNT = 1;
    private static final int POS_MESSAGES = 2;
    private static final int POS_CART = 3;
    private static final int POS_LOGOUT = 6;

    private String[] screenTitles;
    private Drawable[] screenIcons;

    private SlidingRootNav slidingRootNav;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initSetting();


        setSupportActionBar(myToolbar);

        slidingRootNav = new SlidingRootNavBuilder(this)
                .withToolbarMenuToggle(myToolbar)
                .withMenuOpened(false)
                .withContentClickableWhenMenuOpened(false)
                .withSavedState(savedInstanceState)
                .withMenuLayout(R.layout.menu_left_drawer)
                .inject();

        TextView textView = slidingRootNav.getLayout().findViewById(R.id.welcome_text_view);
        textView.setText("좋은아침입니다.");

        screenIcons = loadScreenIcons();
        screenTitles = loadScreenTitles();

        DrawerAdapter adapter = new DrawerAdapter(Arrays.asList(
                createItemFor(POS_DASHBOARD).setChecked(true),
                createItemFor(POS_ACCOUNT),
                createItemFor(POS_MESSAGES),
                createItemFor(POS_CART),
                new SpaceItem(48),
                createItemFor(POS_LOGOUT)));
        adapter.setListener(this);

        RecyclerView list = findViewById(R.id.list);
        list.setNestedScrollingEnabled(false);
        list.setLayoutManager(new LinearLayoutManager(this));
        list.setAdapter(adapter);

        adapter.setSelected(POS_DASHBOARD);
    }

    private void initSetting() {
        Paper.init(this);
        ButterKnife.bind(this);
        setStatusbar();
        setTapLayout();

    }

    @Override
    public void onItemSelected(int position) {
        Log.d(TAG, "onItemSelected: click postition = " + position);


        if (position == POS_DASHBOARD) {
            Log.d(TAG, "onItemSelected: POS_DASHBOARD");
//            startActivity(new Intent(this, ));

        } else if (position == POS_ACCOUNT) {
            Log.d(TAG, "onItemSelected: POS_ACCOUNT");


        } else if (position == POS_MESSAGES) {
            Log.d(TAG, "onItemSelected: POS_MESSAGES");
            // 투약 설정
            startActivity(new Intent(this, SelectDrugActivity.class));

//            startActivity(new Intent(this, SelectDrugFirstActivity.class));

        } else if (position == POS_CART) {
            Log.d(TAG, "onItemSelected: POS_CART");


        } else if (position == POS_LOGOUT) {
            Log.d(TAG, "onItemSelected: POS_LOGOUT");
            finish();

        }

//        if (position == POS_LOGOUT) {
//            finish();
//        }


        slidingRootNav.closeMenu();
        Log.e(TAG, "onItemSelected: " + position);
//        Fragment selectedScreen = CenteredTextFragment.createFor(screenTitles[position]);
//        showFragment(selectedScreen);
    }

    private void showFragment(Fragment fragment) {
        getFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
    }

    private DrawerItem createItemFor(int position) {
        return new SimpleItem(screenIcons[position], screenTitles[position])
                .withIconTint(color(R.color.textColorSecondary))
                .withTextTint(color(R.color.textColorPrimary))
                .withSelectedIconTint(color(R.color.colorAccent))
                .withSelectedTextTint(color(R.color.colorAccent));
    }

    private String[] loadScreenTitles() {
        return getResources().getStringArray(R.array.ld_activityScreenTitles);
    }

    private Drawable[] loadScreenIcons() {
        TypedArray ta = getResources().obtainTypedArray(R.array.ld_activityScreenIcons);
        Drawable[] icons = new Drawable[ta.length()];
        for (int i = 0; i < ta.length(); i++) {
            int id = ta.getResourceId(i, 0);
            if (id != 0) {
                icons[i] = ContextCompat.getDrawable(this, id);
            }
        }
        ta.recycle();
        return icons;
    }

    @ColorInt
    private int color(@ColorRes int res) {
        return ContextCompat.getColor(this, res);
    }

    public void setStatusbar() {
        View view = getWindow().getDecorView();
        view.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        getWindow().setStatusBarColor(getResources().getColor(R.color.white));
    }

    private void setTapLayout() {

        //add the fragments you want to display in a List == 내가 원하면 추가가능하다~ 이말이야
        List<android.support.v4.app.Fragment> fragmentList = new ArrayList<>();
        // 홈 = 기록보기
        fragmentList.add(new FragmentA());
        // 캘린더
        fragmentList.add(new FragmentB());
        // 장치 관리 + 동기화
        fragmentList.add(new FragmentC());
        // 프로필
        fragmentList.add(new FragmentD());

        // set
//        final CoordinatorLayout coordinatorLayout = (CoordinatorLayout) findViewById(R.id.activity_main);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);

        tabLayout.initialize(viewPager, getSupportFragmentManager(), fragmentList, null);

        tabLayout.setTabOneOnClickListener(v -> {
//            Snackbar.make(coordinatorLayout, "Welcome to SpaceTabLayout", Snackbar.LENGTH_SHORT).show();
        });
        tabLayout.setOnClickListener(v -> {
            Toast.makeText(this, "" + tabLayout.getCurrentPosition(), Toast.LENGTH_SHORT).show();
//            tabLayout.setTabOneOnClickListener(view -> Snackbar.make(coordinatorLayout, "안녕", Snackbar.LENGTH_SHORT).show());
            tabLayout.setOnClickListener(view -> {
                Toast.makeText(getApplication(), "" + tabLayout.getCurrentPosition(), Toast.LENGTH_SHORT).show();
                Log.d(TAG, "set: tabLayout.getCurrentPosition() = " + tabLayout.getCurrentPosition());
                if (tabLayout.getCurrentPosition() == 1) {
                    Log.d(TAG, "set: 여기!!");
                    Intent intent = new Intent(this, SelectDrugActivity.class);
                    startActivity(intent);
                    intent.putExtra("SelectDrugActivity", false);
                }

                if (tabLayout.getCurrentPosition() == 2) {
                    Log.d(TAG, "set: 여기!!");
                    Intent intent = new Intent(this, NeedleScanActivity.class);
                    startActivity(intent);
                    intent.putExtra("flag_toFragment", false);
                }
            });
        });
    }


}
