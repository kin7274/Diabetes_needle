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

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.airbnb.lottie.LottieAnimationView;
import com.dreamwalkers.elab_yang.mmk.R;
import com.dreamwalkers.elab_yang.mmk.activity.MainActivity;
import com.dreamwalkers.elab_yang.mmk.activity.navi.EditProfileActivity;
import com.dreamwalkers.elab_yang.mmk.activity.navi.ProfileActivity;

import butterknife.BindView;

import static android.content.Context.MODE_PRIVATE;

// 프로필
public class FragmentD extends Fragment {

    //    @BindView(R.id.animation_view)
//    LottieAnimationView animation_view;

    //    @BindView(R.id.normallayout)
//    ConstraintLayout normallayout;

    //    @BindView(R.id.lottielayout)
//    RelativeLayout lottielayout;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_d, container, false);
        // set
//        animation_view = (LottieAnimationView) view.findViewById(R.id.animation_view);
//        normallayout = (ConstraintLayout) view.findViewById(R.id.normallayout);
//        lottielayout = (RelativeLayout) view.findViewById(R.id.lottielayout);
//        setLottie();
//        getProfile();

        return view;
//        return inflater.inflate(R.layout.fragment_d, container, false);
    }

//    public void setLottie() {
//        animation_view.setAnimation("man_and_phone.json");
//        animation_view.loop(true);
//        animation_view.playAnimation();
//    }

//    public void getProfile() {
//        SharedPreferences pref;
//        pref = getContext().getSharedPreferences("pref", MODE_PRIVATE);
//        String cache_user_data = pref.getString("user_data0", "");
//        if (cache_user_data.equals("")) {
//            // 비어있다면 로티를 열자
//            normallayout.setVisibility(View.GONE);
//            lottielayout.setVisibility(View.VISIBLE);
//
//        } else {
//            normallayout.setVisibility(View.VISIBLE);
//            lottielayout.setVisibility(View.GONE);
//        }
//    }
}
