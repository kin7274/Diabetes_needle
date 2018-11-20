package com.dreamwalkers.elab_yang.mmk.activity;

import android.app.Dialog;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.dreamwalkers.elab_yang.mmk.R;
import com.dreamwalkers.elab_yang.mmk.adapter.MyRecyclerAdapter;
import com.dreamwalkers.elab_yang.mmk.adapter.appinfo.TimePointAdapter;
import com.dreamwalkers.elab_yang.mmk.model.CardItem;
import com.dreamwalkers.elab_yang.mmk.model.TimePoint;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SelectDrugFirstActivity extends AppCompatActivity implements IActivityBased, TimePointAdapter.TimePointClickListener {
    private static final String TAG = "SelectDrugFirstActivity";

    @BindView(R.id.my_toolbar)
    Toolbar myToolbar;

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

    @BindView(R.id.recycler_view)
    RecyclerView recyclerview;

    Animation animation;

    List<TimePoint> timepoints;
    private TimePointAdapter mTimePointItems;

    // 메뉴 2가지 동작을 위해
    boolean flag = false;

    String[] set_data = new String[4];

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
        setRecyclerview();
        anim();
        setSupportActionBar(myToolbar);
    }

    public void setRecyclerview() {
        recyclerview.setHasFixedSize(false);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerview.setLayoutManager(layoutManager);
    }

    public void setAdapter() {
        timepoints = new ArrayList<>();

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
        mTimePointItems = new TimePointAdapter(this, timepoints);
        mTimePointItems.setOnClickListener(this);
        recyclerview.setAdapter(mTimePointItems);
    }

    @Override
    public void onItemClicked(int position) {
        Toast.makeText(getApplicationContext(), "선택값 = " + position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAddItemClicked(int position, String item_timepoint) {
        //        Snackbar.make(getWindow().getDecorView().getRootView(), position + "번째 " + tp + "에 장치를 추가하려해욧!", Toast.LENGTH_SHORT).show();

        // 종류, 품명, z;
        timepoints.set(position, new TimePoint(item_timepoint, "노보래피트"));
        mTimePointItems.notifyDataSetChanged();
    }

    public void anim() {
        animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_slide_in_left);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_drug_select, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
//        return super.onOptionsItemSelected(item);
        switch (item.getItemId()) {
            case R.id.select:
                //
                if (!flag) {
                    // next btn
                    // 1번 레이아웃 닫고 2번 연다.
                    layout1.setVisibility(View.GONE);
                    layout2.setVisibility(View.VISIBLE);
                    layout2.startAnimation(animation);
                    setAdapter();
                    //
                    flag = true;
                    break;
                }
                if (flag) {
                    // set btn
                    // 현 데이터를 저장 후 종료
                    Snackbar.make(getWindow().getDecorView().getRootView(), "저장", Snackbar.LENGTH_SHORT).show();

                    String message = "";

                    Log.d(TAG, "onOptionsItemSelected: timepoints.size() = " + timepoints.size());
                    // 리스트 갯수만큼 반복
                    for (int i = 0; i < timepoints.size(); i++) {
                        set_data[i] = timepoints.get(i).getTimepoint() + "/" + timepoints.get(i).getName() + "/" + timepoints.get(i).getUnit();
                        Log.d(TAG, "onOptionsItemSelected: set_data[i] = " + set_data[i]);
                        message += set_data[i];
                    }

                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setTitle("title. 최종 확인")
                            .setMessage("message. 최종 확인" + message)
                            .setPositiveButton("yes",
                                    (dialog, id) -> {
                                        finish();
                                    });
                    builder.create()
                            .show();
//                    finish();
                    //
                    flag = false;
                    break;
                }
                break;
        }
        return true;
    }
}
