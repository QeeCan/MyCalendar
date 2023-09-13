package com.qeecan.mycalendar.fragment;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.qeecan.mycalendar.LuckActivity;
import com.qeecan.mycalendar.R;
import com.qeecan.mycalendar.adapter.OldsRecyclerAdapter;
import com.qeecan.mycalendar.bean.LuckBean;
import com.qeecan.mycalendar.oldnetbean.OldBaseResponse;
import com.qeecan.mycalendar.oldnetbean.Result;
import com.qeecan.mycalendar.networkapi.WebApiService;
import com.qeecan.mycalendar.typebean.TestBean;
import com.qeecan.mycalendar.weanetbean.WeaBaseResponse;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link OldsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OldsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String key = "1fc923ee1e2fbc256bf0f98fe6bacad9";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private RecyclerView recyclerView;
    private OldsRecyclerAdapter oldsRecyclerAdapter;
    private List<TestBean> testBeanList;
    private Retrofit retrofit;
    private WebApiService webApiService;
    private Toolbar toolbar;


    public OldsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment OldFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static OldsFragment newInstance(String param1, String param2) {
        OldsFragment fragment = new OldsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_olds, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.rcy_olds);
        toolbar = view.findViewById(R.id.tb_olds);
        testBeanList = new ArrayList<>();
        retrofitpostmsg();
        oldsRecyclerAdapter = new OldsRecyclerAdapter(view.getContext(), testBeanList);

        recyclerView.setAdapter(oldsRecyclerAdapter);
        RecyclerView.LayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new GridItemDecoration());

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });

    }

    private void retrofitpostmsg() {
        retrofit = new Retrofit.Builder().baseUrl("http://v.juhe.cn/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        webApiService = retrofit.create(WebApiService.class);
        Call<OldBaseResponse> call = webApiService.getOldInfo(getDate(), key);
        call.enqueue(new Callback<OldBaseResponse>() {
            @Override
            public void onResponse(Call<OldBaseResponse> call, Response<OldBaseResponse> response) {
                if (response.body() != null) {
                    String result = response.body().toString();
                    Log.i("lealuck", result);
                    //使用LuckBean对象拿到body()
                    OldBaseResponse oldBaseResponse = response.body();
                    //将得到的data按照RcylLuckBean的形式注入
                    initData(oldBaseResponse);
                    //设置适配器
                    recyclerView.setAdapter(oldsRecyclerAdapter);

                } else {
                    //失败抛出异常，用toast提醒用户是网络连接的问题
                    Toast.makeText(getContext(), "Network Connection Error!", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<OldBaseResponse> call, Throwable t) {
                Toast.makeText(getContext(), "Network Connection Error!", Toast.LENGTH_SHORT).show();

            }
        });

    }


    private String getDate() {
        @SuppressLint("SimpleDateFormat")
        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
        Date date = new Date(System.currentTimeMillis());
        String today = dateFormat.format(date);
        Log.i("lea", today);
        return today;
    }

    private static class GridItemDecoration extends RecyclerView.ItemDecoration {
        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            outRect.set(10, 20, 10, 10);
        }
    }

    private void initData(OldBaseResponse oldBaseResponse) {

        TestBean yangli = new TestBean("阳历", oldBaseResponse.getResult().getYangli().toString());
        TestBean yinli = new TestBean("阴历", oldBaseResponse.getResult().getYinli());
        TestBean wuxing = new TestBean("五行", oldBaseResponse.getResult().getWuxing());
        TestBean chongsha = new TestBean("冲杀", oldBaseResponse.getResult().getChongsha());
        TestBean baiji = new TestBean("拜祭", oldBaseResponse.getResult().getBaiji());
        TestBean jishen = new TestBean("祭神", oldBaseResponse.getResult().getJishen());
        TestBean yi = new TestBean("宜", oldBaseResponse.getResult().getYi());
        TestBean xiongshen = new TestBean("凶神", oldBaseResponse.getResult().getXiongshen());
        TestBean ji = new TestBean("忌", oldBaseResponse.getResult().getJi());


        testBeanList.add(yangli);
        testBeanList.add(yinli);
        testBeanList.add(wuxing);
        testBeanList.add(chongsha);
        testBeanList.add(baiji);
        testBeanList.add(jishen);
        testBeanList.add(yi);
        testBeanList.add(xiongshen);
        testBeanList.add(ji);
        Log.i("leaadd", testBeanList.toString());

    }


}