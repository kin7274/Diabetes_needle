/*
 * Copyright (c) 2016 Lung Razvan
 *
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 */

package com.dreamwalkers.elab_yang.mmk.activity.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dreamwalkers.elab_yang.mmk.R;
import com.dreamwalkers.elab_yang.mmk.adapter.appinfo.ProfileAdapter;
import com.dreamwalkers.elab_yang.mmk.adapter.appinfo.TimePointAdapter;
import com.dreamwalkers.elab_yang.mmk.model.Profile;
import com.dreamwalkers.elab_yang.mmk.model.TimePoint;

import java.util.ArrayList;
import java.util.List;

// 프로필
public class FragmentD extends Fragment implements ProfileAdapter.ProfileClickListener {
    RecyclerView recyclerview;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_d, container, false);
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
        List<Profile> profiles = new ArrayList<>();

        profiles.add(new Profile("신체정보", "신장은 어쩌구 몸무게는 어쩌구 최소혀당 최대혈당"));  // 신체정보
        profiles.add(new Profile("현재 복용 중인 약", "아침 : 휴머로그, 10단위"));  // 복용중이신 약
        profiles.add(new Profile("마지막 투약일", "2018. 11. 12 07:52 10단위 투약"));  // 최근 투약일(횟수?)

        ProfileAdapter mProfileItems = new ProfileAdapter(profiles);
        mProfileItems.setOnClickListener(this);
        recyclerview.setAdapter(mProfileItems);
    }

    @Override
    public void onItemClicked(int position) {

    }
}
