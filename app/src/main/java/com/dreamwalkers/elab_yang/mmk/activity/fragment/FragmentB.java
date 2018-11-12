package com.dreamwalkers.elab_yang.mmk.activity.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.RelativeLayout;

import com.dreamwalkers.elab_yang.mmk.R;
import com.dreamwalkers.elab_yang.mmk.activity.NeedleScanActivity;

import butterknife.ButterKnife;

import static android.support.constraint.Constraints.TAG;

public class FragmentB extends Fragment implements View.OnClickListener{

    private Animation fab_open, fab_close;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_b, container, false);
        ButterKnife.bind(this, view);
//        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);

        RelativeLayout scan_device = (RelativeLayout) view.findViewById(R.id.scan_device);
        scan_device.setOnClickListener(v -> {
            Log.d(TAG, "onClick: 띠용");
            startActivity(new Intent(getActivity(), NeedleScanActivity.class));
        });

        return view;
    }

    @Override
    public void onClick(View v) {

    }
}
