package com.dreamwalkers.elab_yang.mmk.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.dreamwalkers.elab_yang.mmk.R;

import java.util.ArrayList;
import java.util.List;

public class BottomBarActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;

    /**
     * Maintains a list of Fragments for {@link BottomNavigationView}
     */
    private List<BottomBarFragment> fragments = new ArrayList<>(5);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_bar);

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_nav);

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.action_add_device:
                                switchFragment(0, "tag_frag_add_device");
                                return true;
                            case R.id.action_set_insulin:
                                switchFragment(1, "tag_frag_set_insulin");
                                return true;
                            case R.id.action_connect:
                                switchFragment(2, "tag_frag_connect");
                                return true;
                            case R.id.action_data_today:
                                switchFragment(3, "tag_frag_data_today");
                                return true;
                            case R.id.action_data_total:
                                switchFragment(4, "tag_frag_data_total");
                                return true;
                        }
                        return false;
                    }
                });

        buildFragmentsList();

        // Set the 0th Fragment to be displayed by default.
        switchFragment(0, "tag_frag_add_device");

    }

    private void switchFragment(int pos, String tag) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_fragmentholder, fragments.get(pos), tag)
                .commit();
    }


    private void buildFragmentsList() {
        BottomBarFragment addDeviceFragment = buildFragment("Add_device");
        BottomBarFragment setInsulinFragment = buildFragment("Set_insulin");
        BottomBarFragment connectFragment = buildFragment("Connect");
        BottomBarFragment todatDataFragment = buildFragment("Today_data");
        BottomBarFragment totalDataFragment = buildFragment("Total_data");

        fragments.add(addDeviceFragment);
        fragments.add(setInsulinFragment);
        fragments.add(connectFragment);
        fragments.add(todatDataFragment);
        fragments.add(totalDataFragment);
    }

    /**
     * Creates a {@link BottomBarFragment} with corresponding Item title.
     *
     * @param title
     * @return
     */
    private BottomBarFragment buildFragment(String title) {
        BottomBarFragment fragment = new BottomBarFragment();
        Bundle bundle = new Bundle();
        bundle.putString(BottomBarFragment.ARG_TITLE, title);
        fragment.setArguments(bundle);
        return fragment;
    }

}
