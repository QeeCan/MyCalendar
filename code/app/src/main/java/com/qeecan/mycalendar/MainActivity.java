package com.qeecan.mycalendar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.othershe.calendarview.bean.DateBean;
import com.othershe.calendarview.listener.OnPagerChangeListener;
import com.othershe.calendarview.listener.OnSingleChooseListener;
import com.othershe.calendarview.utils.CalendarUtil;
import com.othershe.calendarview.weiget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private CalendarView calendarView;
    private TextView chooseDate, title;
    //将当前的日期存放到数组中
    private int[] cDate = CalendarUtil.getCurrentDate();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chooseDate = findViewById(R.id.choose_date);
        calendarView = findViewById(R.id.calview);
        toolbar= findViewById(R.id.tb_main);
        title = findViewById(R.id.tv_cal_title);

        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.menu_add:
                        Intent intent1 =new Intent();
                        intent1.setClass(MainActivity.this,EditActivity.class);
                        startActivity(intent1);
                        break;

                    case R.id.menu_list:
                        Intent intent2 =new Intent();
                        intent2.setClass(MainActivity.this,ScheduleActivity.class);
                        startActivity(intent2);
                        break;

                    case R.id.menu_more:
                        Intent intent3 =new Intent();
                        intent3.setClass(MainActivity.this,MoreActivity.class);
                        startActivity(intent3);
                        break;
                }
                return true;
            }
        });
        //初始化日历起始范围
        calendarView.setStartEndDate("2016.1", "2028.12")
                //禁用范围
                .setDisableStartEndDate("2015.10.10", "2029.10.10")
                //初始显示的年月
                .setInitDate(cDate[0] + "." + cDate[1])
                //单选时默认的选中日期
                .setSingleDate(cDate[0] + "." + cDate[1] + "." + cDate[2])
                //根据设定的日期范围计算日历的页数
                .init();

        //显示日历头的年月
        title.setText(cDate[0] + "年" + cDate[1] + "月");
   //     chooseDate.setText("当前选中的日期：" + cDate[0] + "年" + cDate[1] + "月" + cDate[2] + "日");
        //设置月份切换的显示
        calendarView.setOnPagerChangeListener(new OnPagerChangeListener() {
            @Override
            public void onPagerChanged(int[] date) {
                title.setText(date[0] + "年" + date[1] + "月");
            }
        });

        calendarView.setOnSingleChooseListener(new OnSingleChooseListener() {
            @Override
            public void onSingleChoose(View view, DateBean date) {
                //如果当前类型为本月
                if (date.getType() == 1) {
                    chooseDate.setText("当前选中的日期：" + date.getSolar()[0] + "年" + date.getSolar()[1] + "月" + date.getSolar()[2] + "日");
                }

            }
        });

    }



}