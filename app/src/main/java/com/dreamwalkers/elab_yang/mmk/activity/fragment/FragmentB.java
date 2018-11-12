package com.dreamwalkers.elab_yang.mmk.activity.fragment;

<<<<<<< HEAD
import android.content.Intent;
=======
>>>>>>> refs/remotes/kin7274/master
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dreamwalkers.elab_yang.mmk.R;

<<<<<<< HEAD
import butterknife.ButterKnife;

import static android.support.constraint.Constraints.TAG;

public class FragmentB extends Fragment implements View.OnClickListener{

    private Animation fab_open, fab_close;
=======
>>>>>>> refs/remotes/kin7274/master

public class FragmentB extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
<<<<<<< HEAD
        View view = inflater.inflate(R.layout.fragment_b, container, false);
        ButterKnife.bind(this, view);
//        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);

        RelativeLayout scan_device = (RelativeLayout) view.findViewById(R.id.scan_device);
        scan_device.setOnClickListener(v -> {
            Log.d(TAG, "onClick: 띠용");
            startActivity(new Intent(getActivity(), NeedleScanActivity.class));
        });

        return view;
=======
        return inflater.inflate(R.layout.fragment_b, container, false);
>>>>>>> refs/remotes/kin7274/master
    }

}
