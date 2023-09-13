package com.qeecan.mycalendar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.qeecan.mycalendar.bean.SchedBean;

public class EditActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private EditText editText;
    private TextView dateTv, timeTv;
    private Button dateBtn, timeBtn;
    private RadioGroup radioGroup;
    private RadioButton personRbtn, workRbtn;
    private String persontag,worktag;
    private DatePickerDialog.OnDateSetListener dateSetListener;
    private TimePickerDialog.OnTimeSetListener timeSetListener;
    private int[] dateArray = new int[3];
    private int[] timeArray = new int[2];
    private SchedBean sc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        initView();
        listenerEvent();

    }

    private void listenerEvent() {
        //RadioBtn的监听，负责传递tag类型方便下页进行显示区分
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (personRbtn.isChecked()) {
                    persontag = personRbtn.getText().toString();
                    Toast.makeText(EditActivity.this, persontag, Toast.LENGTH_SHORT).show();
                } else {
                    worktag = workRbtn.getText().toString();
                    Toast.makeText(EditActivity.this, worktag, Toast.LENGTH_SHORT).show();
                }


            }
        });

        //toolbar确认按键监听
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId() == R.id.edit_check) {
                    Toast.makeText(EditActivity.this, "check it！ Good job!", Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        });
        //toolbar回退控件
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void initView() {
        toolbar = findViewById(R.id.tb_edit);
        editText = findViewById(R.id.et_edit);
        dateTv = findViewById(R.id.tv_set_date);
        timeTv = findViewById(R.id.tv_set_time);
        dateBtn = findViewById(R.id.btn_set_date);
        timeBtn = findViewById(R.id.btn_set_time);
        radioGroup = findViewById(R.id.rg_schedule_type);
        personRbtn = findViewById(R.id.rb_type_personal);
        workRbtn = findViewById(R.id.rb_type_work);
        sc = new SchedBean();
        dateArray[0] = sc.getYear();
        dateArray[1] = sc.getMonth() + 1;
        dateArray[2] = sc.getDay();
        timeArray[0] = sc.getHour();
        timeArray[1] = sc.getMinute();

    }
}