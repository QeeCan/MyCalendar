package com.qeecan.mycalendar.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.qeecan.mycalendar.R;
import com.qeecan.mycalendar.typebean.RcylvBean;


import java.util.List;

public class LuckRecyclerAdapter extends RecyclerView.Adapter<LuckRecyclerAdapter.LuckViewHolder> {
    private Context context;
    private LayoutInflater layoutInflater;
    private List<RcylvBean> rcylvBeanList;

    public LuckRecyclerAdapter(Context context, List<RcylvBean> rcylvBeanList) {
        this.context = context;
        this.rcylvBeanList = rcylvBeanList;
        layoutInflater=LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public LuckViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_luck,parent,false);
        LuckViewHolder luckViewHolder = new LuckViewHolder(view);
        return luckViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull LuckViewHolder holder, int position) {
        RcylvBean rcylvBean = rcylvBeanList.get(position);
        holder.tvLKtype.setText(rcylvBean.getType());
        holder.tvLkcontent.setText(rcylvBean.getContent());
    }

    @Override
    public int getItemCount() {
        return rcylvBeanList == null ? 0: rcylvBeanList.size();
    }

    public static class LuckViewHolder extends RecyclerView.ViewHolder{
        TextView tvLKtype;
        TextView tvLkcontent;

        public LuckViewHolder(@NonNull View itemView) {
            super(itemView);
            this.tvLKtype=itemView.findViewById(R.id.item_luck_tv_title);
            this.tvLkcontent=itemView.findViewById(R.id.item_luck_tv_content);
        }
    }
}
