package com.qeecan.mycalendar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.qeecan.mycalendar.adapter.LuckRecyclerAdapter;
import com.qeecan.mycalendar.bean.LuckBean;
import com.qeecan.mycalendar.typebean.RcylvBean;
import com.qeecan.mycalendar.networkapi.WebApiService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class LuckActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private LuckRecyclerAdapter luckRecyclerAdapter;
    private List<RcylvBean> rcylvBeanList;
    private final String type = "today";
    private final String key = "62a5851b6fddfbbe3e316066992f5408";
    private String name;
    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_luck);
        recyclerView =findViewById(R.id.rcy_luck);
        toolbar = findViewById(R.id.tb_luck);

        //通过Intent获取从上个页面点击事件获取的星座的名称作为参数name传入网络请求中
        Intent intent = getIntent();
        name = intent.getStringExtra("name");

        try {
            retrofitgetmsg(name);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //将适配器设置给RcylLuckBean样式的ArrayList对象
        rcylvBeanList = new ArrayList<>();
        luckRecyclerAdapter = new LuckRecyclerAdapter(this, rcylvBeanList);
        //使用RecyclerView下的管理类是其以LinearLayout的形式显示
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
       recyclerView.setLayoutManager(layoutManager);

        //监听toolbar中的返回键操作
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



    }

    private void retrofitgetmsg(String name)throws IOException {
        //使用底层okhttp网络操作获得的responseBody以Gson格式将json转为java类
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://web.juhe.cn/")
                .addConverterFactory(GsonConverterFactory.create())
              .build();
       WebApiService webApiService = retrofit.create(WebApiService.class);
        Call<LuckBean> call = webApiService.getLuckInfo(name, type, key);
        call.enqueue(new Callback<LuckBean>() {

            @Override
            public void onResponse(Call<LuckBean> call, Response<LuckBean> response) {

                //如果回传结果不为空
                if (response.body() != null) {
                    String result = response.body().toString();
                    Log.i("lealuck",result);
                    //使用LuckBean对象拿到body()
                    LuckBean luckBean = response.body();
                    //将得到的data按照RcylLuckBean的形式注入
                    initData(luckBean);
                    //设置适配器
                    recyclerView.setAdapter(luckRecyclerAdapter);

                }else {
                    //失败抛出异常，用toast提醒用户是网络连接的问题
                    Toast.makeText(LuckActivity.this, "Network Connection Error!", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<LuckBean> call, Throwable t) {
                //失败抛出异常，用toast提醒用户是网络连接的问题
                Toast.makeText(LuckActivity.this, "Network Connection Error!", Toast.LENGTH_SHORT).show();

            }
        });
    }


    private void initData(LuckBean luckBean) {
        RcylvBean name = new RcylvBean("星座名称",luckBean.getName());
        RcylvBean day = new RcylvBean("日期", luckBean.getDatetime());
        RcylvBean all = new RcylvBean("综合指数", luckBean.getAll());
        RcylvBean health = new RcylvBean("健康指数", luckBean.getHealth());
        RcylvBean money = new RcylvBean("财运指数", luckBean.getMoney());
        RcylvBean love = new RcylvBean("爱情指数", luckBean.getLove());
        RcylvBean work = new RcylvBean("工作指数", luckBean.getWork());
        RcylvBean color = new RcylvBean("幸运色", luckBean.getColor());
        RcylvBean num = new RcylvBean("幸运数字", luckBean.getNumber());
        RcylvBean qfriend = new RcylvBean("速配星座", luckBean.getQFriend());
        RcylvBean summary = new RcylvBean("今日概述", luckBean.getSummary());

        rcylvBeanList.add(name);
        rcylvBeanList.add(day);
        rcylvBeanList.add(all);
        rcylvBeanList.add(health);
        rcylvBeanList.add(money);
        rcylvBeanList.add(love);
        rcylvBeanList.add(work);
        rcylvBeanList.add(color);
        rcylvBeanList.add(num);
        rcylvBeanList.add(qfriend);
        rcylvBeanList.add(summary);
    }

}
