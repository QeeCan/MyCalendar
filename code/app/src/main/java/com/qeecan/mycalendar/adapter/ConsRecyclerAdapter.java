package com.qeecan.mycalendar.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.qeecan.mycalendar.LuckActivity;
import com.qeecan.mycalendar.R;
import com.qeecan.mycalendar.bean.ConsBean;
import com.qeecan.mycalendar.utils.DpnPx;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ConsRecyclerAdapter extends RecyclerView.Adapter<ConsRecyclerAdapter.ConsViewHodler> {
    private Context context;
    private List<ConsBean> consBeanList;
    private LayoutInflater layoutInflater;
    private String name;

    public ConsRecyclerAdapter(Context context, List<ConsBean> consBeanList) {
        this.context = context;
        this.consBeanList = consBeanList;
        layoutInflater = LayoutInflater.from(context);
    }


    @NonNull
    @Override
    public ConsViewHodler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_cons, parent, false);
        ConsViewHodler consViewHodler = new ConsViewHodler(view);
        return consViewHodler;
    }

    @Override
    public void onBindViewHolder(@NonNull ConsViewHodler holder, final int position) {
        //将对应的数据类型添加到显示当中
        final ConsBean consBean =consBeanList.get(position);
        holder.circleImageView.setImageResource(consBean.getConsimgResId());
        holder.textView.setText(consBean.getConsname());
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                consBean.setConsimgResId(position);
                name = consBean.getConsname();
                Intent intent = new Intent(context,  LuckActivity.class);
                intent.putExtra("name",name);
                context.startActivity(intent);
            }
        });

        //遍历获取两个数组中的资源，载入相应的图和文字
    /*    for (int i = 0; i < 12; i++) {
            consTypeBeanArrayList.add(new ConsTypeBean(consimageId[i], consnames[i]));
        }*/
/*        Glide.with(context)
                .load(consimageId[position])
                .error(R.drawable.ic_baseline_autorenew_24)
                .centerCrop()
                .fitCenter()
                .into(holder.imageView);*/

    }

    @Override
    public int getItemCount() {
        return consBeanList == null ? 0 : consBeanList.size();
    }

    class ConsViewHodler extends RecyclerView.ViewHolder {

        private TextView textView;
        CircleImageView circleImageView;
        private RelativeLayout relativeLayout;

        public ConsViewHodler(@NonNull View itemView) {
            super(itemView);
            this.circleImageView = itemView.findViewById(R.id.item_cons_iv);
            this.textView = itemView.findViewById(R.id.item_cons_tv);
            this.relativeLayout = itemView.findViewById(R.id.rl_cons);
        }
    }


}
