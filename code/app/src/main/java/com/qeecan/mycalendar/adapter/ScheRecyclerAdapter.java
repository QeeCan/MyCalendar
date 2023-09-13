package com.qeecan.mycalendar.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.qeecan.mycalendar.R;
import com.qeecan.mycalendar.bean.SchedBean;


import java.util.List;

public class ScheRecyclerAdapter extends RecyclerView.Adapter<ScheRecyclerAdapter.ScheViewHolder> {
    private Context context;
    private LayoutInflater layoutInflater;
    private List<SchedBean> schedBeanArrayList;


    public ScheRecyclerAdapter(Context context, List<SchedBean> schedBeanArrayList) {
        this.context = context;
        this.schedBeanArrayList = schedBeanArrayList;
        layoutInflater = LayoutInflater.from(context);
    }


    @NonNull
    @Override
    public ScheViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_schelist, parent, false);
        ScheViewHolder scheViewHolder = new ScheViewHolder(view);
        return scheViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ScheViewHolder holder, int position) {
        SchedBean schedBean = schedBeanArrayList.get(position);
        holder.scontent.setText(schedBean.getSchecontent());
        holder.sdatatime.setText(schedBean.getClock());
        holder.stag.setText(schedBean.getSchetag());
        //在加载时判断tag内容是“个人”还是“工作”，针对不同的tag设置不同的背景颜色作为标识
        String s=(String) holder.stag.getText();
        if(TextUtils.equals(s,"个人")){

            holder.stag.setBackgroundResource(R.drawable.tag_personal_shape);
        }else {
            holder.stag.setBackgroundResource(R.drawable.tag_work_shape);

        }

    }

    @Override
    public int getItemCount() {
        return schedBeanArrayList == null ? 0 : schedBeanArrayList.size();
    }

    public class ScheViewHolder extends RecyclerView.ViewHolder {
        private TextView scontent;
        private TextView sdatatime;
        private TextView stag;


        public ScheViewHolder(@NonNull View itemView) {
            super(itemView);
            this.scontent = itemView.findViewById(R.id.item_tv_schecontent);
            this.sdatatime = itemView.findViewById(R.id.item_tv_schedatetime);
            this.stag = itemView.findViewById(R.id.item_tv_schetag);

           /* if(TextUtils.equals(stag.getText(),"个人")){
                String sflag= (String) stag.getText();
                Log.d("lea",sflag);
                stag.setBackgroundResource(R.drawable.tag_personal_shape);
            }else {
                stag.setBackgroundResource(R.drawable.tag_work_shape);

        }*/
    }}
}
