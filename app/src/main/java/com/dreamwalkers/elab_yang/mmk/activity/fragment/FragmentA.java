package com.dreamwalkers.elab_yang.mmk.activity.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dreamwalkers.elab_yang.mmk.R;
import com.dreamwalkers.elab_yang.mmk.adapter.appinfo.DashboardAdapter;
import com.dreamwalkers.elab_yang.mmk.model.Dashboard;

import java.util.ArrayList;
import java.util.List;

public class FragmentA extends Fragment implements DashboardAdapter.DashboardClickListener {
    private final static String TAG = FragmentA.class.getSimpleName();
    RecyclerView recyclerview;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_a, container, false);
        recyclerview = (RecyclerView) view.findViewById(R.id.recycler_view);
        setRecyclerView();
        return view;
    }

    public void setRecyclerView() {
        recyclerview.setHasFixedSize(false);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerview.setLayoutManager(layoutManager);
        setAdapter();
    }

    public void setAdapter() {
        List<Dashboard> dashboards = new ArrayList<>();

        // 지난 7일간의 내역
        dashboards.add(new Dashboard("지난 7일간의 내역 title", "지난 7일간의 내역 content"));

        dashboards.add(new Dashboard("현재 복용 중인 약", "ㅅㅅ"));  // 복용중이신 약

        DashboardAdapter mDashboardItems = new DashboardAdapter(dashboards);
        mDashboardItems.setOnClickListener(this);
        recyclerview.setAdapter(mDashboardItems);
    }

    @Override
    public void onItemClicked(int position) {

    }

    @Override
    public void onAddItemClicked(int position) {

    }

}

