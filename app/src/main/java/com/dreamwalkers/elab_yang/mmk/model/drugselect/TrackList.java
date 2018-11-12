package com.dreamwalkers.elab_yang.mmk.model.drugselect;


import android.content.res.Resources;

import com.dreamwalkers.elab_yang.mmk.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Artem Kholodnyi on 9/6/16.
 */
public class TrackList {
    public final static List<Track> TRACKS = new ArrayList<Track>(){{
        add(new Track(Resources.getSystem().getString(R.string.insulin_name0_0), Resources.getSystem().getString(R.string.insulin_name), R.drawable.ic_syringe_rrpid));
        add(new Track(Resources.getSystem().getString(R.string.insulin_name0_1),  Resources.getSystem().getString(R.string.insulin_name), R.drawable.ic_syringe_rrpid));
        add(new Track(Resources.getSystem().getString(R.string.insulin_name0_2),  Resources.getSystem().getString(R.string.insulin_name), R.drawable.ic_syringe_rrpid));
//        add(new Track("Born This Way", "Thousand Foot Krunch", R.drawable.ic_syringe_rrpid));
//        add(new Track("Light Up the Sky", "Thousand Foot Krunch", R.drawable.ic_syringe_rrpid));
//        add(new Track("Rolling Stone", "Hurts", R.drawable.ic_syringe_rrpid));
//        add(new Track("Hater", "Korn", R.drawable.ic_syringe_rrpid));
//        add(new Track("Siberian Knights", "The Kills", R.drawable.ic_syringe_rrpid));
//        add(new Track("Hard As a Rock", "AC/DC", R.drawable.ic_syringe_rrpid));
//        add(new Track("Hells Bells", "AC/DC", R.drawable.ic_syringe_rrpid));
//        add(new Track("Way Down We Go", "Kaleo", R.drawable.ic_syringe_rrpid));
//        add(new Track("Psycho", "Muse", R.drawable.ic_syringe_rrpid));
//        add(new Track("Obstacles", "Syd Matters", R.drawable.ic_syringe_rrpid));
//        add(new Track("Guilty All the Same", "Linking Park", R.drawable.ic_syringe_rrpid));
//        add(new Track("Jesus Walks", "Kanye West", R.drawable.ic_syringe_rrpid));
//        add(new Track("Bad Blood", "Black Pistol Fire", R.drawable.ic_syringe_rrpid));
//        add(new Track("Black Skinhead", "Kanye West", R.drawable.ic_syringe_rrpid));
//        add(new Track("Someone to Love Me", "Diddy", R.drawable.ic_syringe_rrpid));
//        add(new Track("The Fire", "The Roots", R.drawable.ic_syringe_rrpid));
//        add(new Track("Shook Ones, Pt II", "Mobb Deep", R.drawable.ic_syringe_rrpid));
//        add(new Track("We Don't Care", "Kanye West", R.drawable.ic_syringe_rrpid));
    }};

}
