package com.dreamwalkers.elab_yang.mmk.activity.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.applikeysolutions.cosmocalendar.view.CalendarView;
import com.dreamwalkers.elab_yang.mmk.R;

public class FragmentB extends Fragment {

    private CalendarView calendar_view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_b, container, false);
        //        ButterKnife.bind(this, view);
        calendar_view = (CalendarView) view.findViewById(R.id.calendar_view);

//        calendar_view.getDate();
        return view;
    }
}
