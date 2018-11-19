package com.dreamwalkers.elab_yang.mmk.adapter.appinfo;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dreamwalkers.elab_yang.mmk.R;
import com.dreamwalkers.elab_yang.mmk.activity.select.SelectDrugActivity;
import com.dreamwalkers.elab_yang.mmk.model.TimePoint;

import java.util.List;

public class TimePointAdapter extends RecyclerView.Adapter<TimePointAdapter.ViewHolder> {
    Context context;
    private final List<TimePoint> mDataList;
    private TimePointClickListener mListener;
    private static int TYPE_FOOTER = 4; // max

    public TimePointAdapter(Context context, List<TimePoint> dataList) {
        this.context = context;
        mDataList = dataList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.timepoint_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
//        TimePoint card_view = mDataList.get(position);
        TimePoint item = mDataList.get(position);

        // detail하게 보기, 확대용
        holder.card_view.setOnClickListener((View v) -> {
//            Snackbar.make(v, position + "번 째 카드뷰 클릭하셨습니다", 1000).show();

            // 다이얼로그로 삭제하시겠습니까? 표시
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder
                    .setTitle("title. 삭제")
                    .setMessage("message. 삭제")
                    .setCancelable(false)
                    .setPositiveButton("yes",
                            (dialog, id) -> {
                                // 삭제
                                removeAt(position);
                                dialog.dismiss();
                            })
                    .setNegativeButton("no",
                            (dialog, id) -> {
                                // 안삭제
                                dialog.dismiss();
                            });
            builder.create()
                    .show();
        });

        holder.item_timepoint.setText(item.getTimepoint());
        holder.item_name.setText(item.getName());
        holder.item_unit.setText(item.getUnit());

        // 품명과 단위 추가하러 가기
        holder.add_btn.setOnClickListener(v -> {

            mListener.onAddItemClicked(position, item.getTimepoint(), "a");
//            context.startActivity(new Intent(context, SelectDrugActivity.class));

            // 임시 데이터 추가

        });

//            Snackbar.make(v, position + " 위치의 '+버튼' 클릭하셨습니다", 1000).show();

        // 다이얼로그로 삭제하시겠습니까? 표시
//            AlertDialog.Builder builder = new AlertDialog.Builder(context);
//            builder
//                    .setTitle("title. 추가")
//                    .setMessage("message. 추가")
//                    .setCancelable(false)
//                    .setPositiveButton("yes",
//                            (dialog, id) -> {
        // 인슐린 선택하러
//                                context.startActivity(new Intent(context, SelectDrugActivity.class));
//            dialog.dismiss();
//                            })
//                    .setNegativeButton("no",
//                            (dialog, id) -> {
//            띠용..
//                                dialog.dismiss();
//                            });
//            builder.create()
//                    .show();
//        });


        if (mListener != null) {
            final int pos = holder.getAdapterPosition();
            holder.itemView.setOnClickListener(view -> mListener.onItemClicked(pos));
        }
    }

    @Override
    public int getItemCount () {
        return mDataList.size();
    }

    public void removeAt ( int position){
        mDataList.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, mDataList.size());
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        CardView card_view;
        TextView item_timepoint;
        TextView item_name;
        TextView item_unit;
        ImageView add_btn;

        public ViewHolder(View itemView) {
            super(itemView);
            card_view = (CardView) itemView.findViewById(R.id.card_view);
            item_timepoint = (TextView) itemView.findViewById(R.id.item_timepoint);
            item_name = (TextView) itemView.findViewById(R.id.item_name);
            item_unit = (TextView) itemView.findViewById(R.id.item_unit);
            add_btn = (ImageView) itemView.findViewById(R.id.add_btn);
        }
    }

    public void setOnClickListener (TimePointClickListener listener){
        mListener = listener;
    }

    public interface TimePointClickListener {
        void onItemClicked(int position);
        void onAddItemClicked(int position, String item_timepoint, String str);
    }
}
