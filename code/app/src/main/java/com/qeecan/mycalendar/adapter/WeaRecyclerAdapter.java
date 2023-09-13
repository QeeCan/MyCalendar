package com.qeecan.mycalendar.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.qeecan.mycalendar.R;
import com.qeecan.mycalendar.typebean.TypeBean;

import java.util.List;

public class WeaRecyclerAdapter extends RecyclerView.Adapter<WeaRecyclerAdapter.WeaViewHolder> {
    private Context context;
    private LayoutInflater layoutInflater;
    private List<TypeBean>typeBeanList;

    public WeaRecyclerAdapter(Context context, List<TypeBean>typeBeanList) {
        this.context = context;
        this.typeBeanList = typeBeanList;
        layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public WeaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_wea,parent,false);
        WeaViewHolder viewHolder = new WeaViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull WeaViewHolder holder, int position) {
        TypeBean typeBean = typeBeanList.get(position);
        holder.textTitle.setText(typeBean.getType());
        holder.textContent.setText(typeBean.getContent());

    }

    @Override
    public int getItemCount() {
        return typeBeanList == null?0:typeBeanList.size();
    }

    class WeaViewHolder extends RecyclerView.ViewHolder {
        TextView textTitle;
        TextView textContent;
        public WeaViewHolder(@NonNull View itemView) {
            super(itemView);
            this.textTitle=itemView.findViewById(R.id.item_wea_tv_title);
            this.textContent = itemView.findViewById(R.id.item_wea_tv_content);
        }
    }
}
