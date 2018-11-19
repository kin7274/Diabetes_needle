package com.dreamwalkers.elab_yang.mmk.activity.sync.needle.v1;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.dreamwalkers.elab_yang.mmk.R;

public class page1 extends android.support.v4.app.Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.page1, container, false);

        CardView card_view = (CardView) view.findViewById(R.id.card_view);

        ImageView emptyLayout = (ImageView) view.findViewById(R.id.emptyLayout);

        TextView dataLayout = (TextView) view.findViewById(R.id.dataLayout);

        card_view.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
            builder.setTitle("title")
                    .setMessage("content")
                    .setPositiveButton("YES", (dialog, which) -> {
                        Toast.makeText(getContext(), "thanks", Toast.LENGTH_SHORT).show();
                        emptyLayout.setVisibility(View.GONE);
                        dataLayout.setVisibility(View.VISIBLE);
                    })
                    .create()
                    .show();
        });
        return view;
    }
}