package com.qeecan.mycalendar.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qeecan.mycalendar.R;
import com.qeecan.mycalendar.adapter.ConsRecyclerAdapter;
import com.qeecan.mycalendar.bean.ConsBean;

import java.util.ArrayList;
import java.util.List;

public class ConsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private RecyclerView recyclerView;
    private ConsRecyclerAdapter consRecyclerAdapter;
    private List<ConsBean> consBeanList;
    private Toolbar toolbar;
    int[] consimageId = {R.drawable.cons1, R.drawable.cons2, R.drawable.cons3, R.drawable.cons4,
            R.drawable.cons5, R.drawable.cons6, R.drawable.cons7, R.drawable.cons8,
            R.drawable.cons9, R.drawable.cons10, R.drawable.cons11, R.drawable.cons12};
    String[] consnames = {"白羊座", "金牛座", "双子座", "巨蟹座", "狮子座", "处女座",
            "天秤座", "天蝎座", "射手座", "摩羯座", "水瓶座", "双鱼座"};

    public ConsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ConsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ConsFragment newInstance(String param1, String param2) {
        ConsFragment fragment = new ConsFragment();
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
        return inflater.inflate(R.layout.fragment_cons, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.rcy_cons);
        toolbar = view.findViewById(R.id.tb_cons);
        initData();

        consRecyclerAdapter = new ConsRecyclerAdapter(view.getContext(), consBeanList);
        recyclerView.setAdapter(consRecyclerAdapter);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this.getContext(), 3, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });


    }


    private void initData() {
        consBeanList = new ArrayList<>();

        for (int i = 0; i < consimageId.length; i++) {
            consBeanList.add(new ConsBean(consnames[i], consimageId[i]));
        }


    }
}