package com.dreamwalkers.elab_yang.mmk.model.drugselect;


import com.dreamwalkers.elab_yang.mmk.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Artem Kholodnyi on 9/6/16.
 */
public class TrackList {
    public final static List<Track> TRACKS = new ArrayList<Track>() {{

        add(new Track("휴머로그", "초속효성", R.drawable.ic_syringe_rrpid));
        add(new Track("노보래피드", "초속효성", R.drawable.ic_syringe_rrpid));
        add(new Track("애피드라", "초속효성", R.drawable.ic_syringe_rrpid));
        add(new Track("휴먼인슐린", "속효성", R.drawable.ic_syringe_mix));
        add(new Track("노보린", "중간형", R.drawable.ic_syringe_rrpid));
        add(new Track("노보렛", "중간형", R.drawable.ic_syringe_mix));
        add(new Track("휴불린", "중간형", R.drawable.ic_syringe_rrpid));
        add(new Track("인슈라타드", "중간형", R.drawable.ic_syringe_mix));

    }};
}
