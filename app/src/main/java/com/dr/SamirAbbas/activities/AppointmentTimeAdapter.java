package com.dr.SamirAbbas.activities;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.dr.SamirAbbas.R;
import com.dr.SamirAbbas.models.AppointmentSlot;

import java.util.ArrayList;

/**
 * Created by Anurag on 4/8/2018.
 */

public class AppointmentTimeAdapter extends RecyclerView.Adapter<AppointmentTimeAdapter.TimeViewHolder>{

    private ArrayList<AppointmentSlot.Morning> list;
    private Context mContext;
    private int initialPos;
    private int type;

    public AppointmentTimeAdapter(ArrayList<AppointmentSlot.Morning> list, Context mContext, int type) {
        this.list = list;
        this.mContext = mContext;
        initialPos = -1;
        this.type = type;
    }

    @Override
    public TimeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.schelude_timings_layout, parent, false);
        TimeViewHolder timeViewHolder = new TimeViewHolder(view);
        return timeViewHolder;
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(final TimeViewHolder holder, final int position) {
            holder.timeScheduleButton.setText(list.get(position).getStartTime() + "");
            holder.timeScheduleButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    ((AppointmentTimeSlotActivity) mContext).updateOthersSlotUponSelection();

                    if (list.get(position).isSelected()) {
                       initialPos = position;
                    }
                    for(int i = 0 ; i < list.size() ; ++i){
                        list.get(i).setSelected(false);
                        notifyItemChanged(i);
                    }
                    list.get(position).setSelected(true);
                }
            });


            if (list.get(position).isSelected()) {
                if (position == initialPos) {
                    holder.timeScheduleButton.setTextColor(mContext.getResources().getColor(R.color.black));
                    holder.timeScheduleButton.setBackgroundResource(R.drawable.btn_border_color);
                    list.get(position).setSelected(false);
                    initialPos = 50;
                }else {
                    holder.timeScheduleButton.setBackgroundColor(mContext.getResources().getColor(R.color.orange));
                    holder.timeScheduleButton.setTextColor(mContext.getResources().getColor(R.color.white));
                }
            } else {
                holder.timeScheduleButton.setTextColor(mContext.getResources().getColor(R.color.black));
                holder.timeScheduleButton.setBackgroundResource(R.drawable.btn_border_color);
            }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class TimeViewHolder extends RecyclerView.ViewHolder{

        private Button timeScheduleButton;

        public TimeViewHolder(View itemView) {
            super(itemView);
            timeScheduleButton = itemView.findViewById(R.id.timeScheduleButton);
        }
    }

}
