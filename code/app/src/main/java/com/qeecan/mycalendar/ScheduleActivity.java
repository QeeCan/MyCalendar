package com.qeecan.mycalendar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.qeecan.mycalendar.adapter.ScheRecyclerAdapter;
import com.qeecan.mycalendar.bean.SchedBean;

import java.util.ArrayList;
import java.util.List;

public class ScheduleActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<SchedBean> schedBeanList;
    private ScheRecyclerAdapter scheRecyclerAdapter;
    private Toolbar toolbar;
    private SearchView searchView;
    private FloatingActionButton floatingActionButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);
        initView();
        initData();
        initEvent();

    }


    private void initView() {
        recyclerView = findViewById(R.id.recyc_sche);
        toolbar =  findViewById(R.id.tb_sche);

        floatingActionButton =findViewById(R.id.fbtn_sche);
        searchView=findViewById(R.id.sv_sche);
        getSearch();
    }


    private void initData() {
        schedBeanList = new ArrayList<>();
        SchedBean schedBean1 = new SchedBean();
        schedBean1.setSchecontent("一个内容");
        schedBean1.setClock("10/4 89:48");
        schedBean1.setSchetag("个人");

        schedBeanList.add(schedBean1);
        SchedBean schedBean2 = new SchedBean();
        schedBean2.setSchecontent("下一个内容");
        schedBean2.setClock("10/4 89:48");
        schedBean2.setSchetag("工作");

        schedBeanList.add(schedBean2);

    }

    private void getSearch() {
        searchView.setQueryHint("search");
        searchView.setOnQueryTextListener(new androidx.appcompat.widget.SearchView.OnQueryTextListener() {

            /*
             * 输入后提交实现搜索
             * */
            @Override
            public boolean onQueryTextSubmit(String query) {
                Toast.makeText(ScheduleActivity.this, "this is submit", Toast.LENGTH_SHORT).show();
                return true;
            }

            /*
             * 实时搜索
             * */
            @Override
            public boolean onQueryTextChange(String newText) {
              //  Log.d("shishi", "nizuihaoshi");
                Toast.makeText(ScheduleActivity.this, "this is change", Toast.LENGTH_SHORT).show();
                return true;

            }
        });
    }


    private void initEvent() {
        scheRecyclerAdapter = new ScheRecyclerAdapter(this, schedBeanList);
        recyclerView.setAdapter(scheRecyclerAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        //LinearLayout样式-----ListView样式
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ScheduleActivity.this,EditActivity.class);
                startActivity(intent);
            }
        });


        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


}