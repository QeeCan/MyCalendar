package com.qeecan.mycalendar.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.qeecan.mycalendar.R;
import com.qeecan.mycalendar.typebean.TestBean;
import com.qeecan.mycalendar.typebean.TypeBean;
import com.qeecan.mycalendar.utils.DpnPx;

import java.util.List;
import java.util.Random;

public class OldsRecyclerAdapter extends RecyclerView.Adapter<OldsRecyclerAdapter.OldsViewHolder> {
    private Context context;
    private LayoutInflater layoutInflater;
    private List<TestBean>testBeanList;

    public OldsRecyclerAdapter(Context context, List<TestBean>testBeanList) {
        this.context = context;
        this.testBeanList = testBeanList;
        layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public OldsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_olds,parent,false);
        OldsViewHolder viewHolder = new OldsViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull OldsViewHolder holder, int position) {
        TestBean testBean = testBeanList.get(position);
        holder.textTitle.setText(testBean.getType());
        holder.textContent.setText(testBean.getContent());
        Random random = new Random();
        int ran = random.nextInt(40)-10;
        holder.relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(DpnPx.Dp2Px(context,200),DpnPx.Dp2Px(context,200+ran)));
    }

    @Override
    public int getItemCount() {
        return testBeanList == null?0:testBeanList.size();
    }

    class OldsViewHolder extends RecyclerView.ViewHolder {
        TextView textTitle;
        TextView textContent;
        RelativeLayout relativeLayout;
        public OldsViewHolder(@NonNull View itemView) {
            super(itemView);
            this.textTitle=itemView.findViewById(R.id.item_olds_tv_title);
            this.textContent = itemView.findViewById(R.id.item_olds_tv_content);
            this.relativeLayout = itemView.findViewById(R.id.rl_olds);
        }
    }
}
