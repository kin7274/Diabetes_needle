package com.dreamwalkers.elab_yang.mmk.activity;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.dreamwalkers.elab_yang.mmk.R;

public class BottomBarActivity extends AppCompatActivity {
    private static final String TAG = "BottomBarActivity";

    final Fragment fragment1 = new AddDeviceFragment();
    final Fragment fragment2 = new SetInsulinFragment();
    final Fragment fragment3 = new ConnectFragment();
    final Fragment fragment4 = new TodayDataFragment();
    final Fragment fragment5 = new TotalDataFragment();
    final FragmentManager fm = getSupportFragmentManager();
    Fragment active = fragment1;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_bar);
        setToolbar();
        setBottomNavi();


    }

    private void setToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }







}
//        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_nav);
//        bottomNavigationView.setOnNavigationItemSelectedListener(
//                item -> {
//                    switch (item.getItemId()) {
//                        case R.id.action_add_device:
//                            Log.d(TAG, "onCreate: 0번 클릭");
//                            switchFragment(0, "tag_frag_add_device");
//                            return true;
//
//                        case R.id.action_set_insulin:
//                            Log.d(TAG, "onCreate: 1번 클릭");
//                            switchFragment(1, "tag_frag_set_insulin");
//                            return true;
//
//                        case R.id.action_connect:
//                            Log.d(TAG, "onCreate: 2번 클릭");
//                            switchFragment(2, "tag_frag_connect");
//                            return true;
//
//                        case R.id.action_data_today:
//                            Log.d(TAG, "onCreate: 3번 클릭");
//                            switchFragment(3, "tag_frag_data_today");
//                            return true;
//
//                        case R.id.action_data_total:
//                            Log.d(TAG, "onCreate: 4번 클릭");
//                            switchFragment(4, "tag_frag_data_total");
//                            return true;
//                    }
//                    return false;
//                });
//        buildFragmentsList();
//
//        // Set the 0th Fragment to be displayed by default.
//        switchFragment(0, "tag_frag_add_device");
//    }
//
//    // 화면 전환
//    private void switchFragment(int pos, String tag) {
//        getSupportFragmentManager()
//                .beginTransaction()
//                .replace(R.id.frame_fragmentholder, fragments.get(pos), tag)
//                .commit();
//    }
//
//    // 빌드
//    private void buildFragmentsList() {
////        BottomBarFragment addDeviceFragment = buildFragment(0);
//        BottomBarFragment addDeviceFragment = buildFragment("Add_device");
////        BottomBarFragment setInsulinFragment = buildFragment(1);
//        BottomBarFragment setInsulinFragment = buildFragment("Set_insulin");
////        BottomBarFragment connectFragment = buildFragment(2);
//        BottomBarFragment connectFragment = buildFragment("Connect");
////        BottomBarFragment todatDataFragment = buildFragment(3);
//        BottomBarFragment todatDataFragment = buildFragment("Today_data");
////        BottomBarFragment totalDataFragment = buildFragment(4);
//        BottomBarFragment totalDataFragment = buildFragment("Total_data");
//
//        fragments.add(addDeviceFragment);
//        fragments.add(setInsulinFragment);
//        fragments.add(connectFragment);
//        fragments.add(todatDataFragment);
//        fragments.add(totalDataFragment);
//    }
//
//    /**
//     * Creates a {@link BottomBarFragment} with corresponding Item title.
//     *
//     * @param title
//     * @return
//     */
//    private BottomBarFragment buildFragment(String title) {
//        Log.d(TAG, "buildFragment: 클릭");
//        BottomBarFragment fragment = new BottomBarFragment();
//        Bundle bundle = new Bundle();
//        bundle.putString(BottomBarFragment.ARG_TITLE, title);
//        // ARG_TITLE에 pos값 넣어서 전달
////        switch (pos) {
////            case 0:
////                // pos == 0 : add device;
////                Log.d(TAG, "buildFragment: 000");
////                break;
////
////            case 1:
////                // pos == 1 : set insulin;
////                Log.d(TAG, "buildFragment: 111");
////                break;
////
////            case 2:
////                // pos == 2 : connect;
////                Log.d(TAG, "buildFragment: 222");
////                break;
////
////            case 3:
////                // pos == 3 : today_data;
////                Log.d(TAG, "buildFragment: 333");
////                break;
////
////            case 4:
////                // pos == 4 : total_data;
////                Log.d(TAG, "buildFragment: 444");
////                break;
////        }
//
//        fragment.setArguments(bundle);
//        return fragment;
//    }
//}