package com.dreamwalkers.elab_yang.mmk.activity.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dreamwalkers.elab_yang.mmk.R;
import com.shrikanthravi.collapsiblecalendarview.data.Day;
import com.shrikanthravi.collapsiblecalendarview.widget.CollapsibleCalendar;

import static android.support.constraint.Constraints.TAG;

public class FragmentB extends Fragment {

//    private CalendarView calendar_view;

    private CollapsibleCalendar calendarView;
    private TextView textview;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_b, container, false);
        //        ButterKnife.bind(this, view);
//        calendar_view = (CalendarView) view.findViewById(R.id.calendar_view);
//        calendar_view.getDate();

        calendarView = (CollapsibleCalendar) view.findViewById(R.id.calendarView);
        textview = (TextView) view.findViewById(R.id.textview);


        calendarView.setCalendarListener(new CollapsibleCalendar.CalendarListener() {
            @Override
            public void onDaySelect() {
                // 날짜 선택 시
                Day day = calendarView.getSelectedDay();
                Log.d(TAG, "onDaySelect: 날짜 선택 = "
                        + day.getYear() + "/" + (day.getMonth() + 1) + "/" + day.getDay());

                textview.setText((day.getYear() + "/" + (day.getMonth() + 1) + "/" + day.getDay()).toString());
            }

            @Override
            public void onItemClick(View view) {

            }

            @Override
            public void onDataUpdate() {

            }

            @Override
            public void onMonthChange() {

            }

            @Override
            public void onWeekChange(int i) {

            }
        });

        return view;
    }
}
