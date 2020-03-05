package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DataFragment extends Fragment {
    private ArrayList<String> mFir = new ArrayList<>();
    private ArrayList<String> mTim = new ArrayList<>();
    private ArrayList<String> mLoc = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.data_fragment,container,false);

    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();

    }
    private void initData(){
        mFir.add("#1");
        mTim.add("9 a.m.");
        mLoc.add("Thane");
        mFir.add("#2");
        mTim.add("7 p.m.");
        mLoc.add("Mulund");
        mFir.add("#3");
        mTim.add("4 p.m.");
        mLoc.add("Powai");
        mFir.add("#4");
        mTim.add("11 a.m.");
        mLoc.add("Worli");
        mFir.add("#5");
        mTim.add("6 a.m.");
        mLoc.add("Bandra");
        initRecyclerView();
    }
    private void initRecyclerView(){
        RecyclerView recyclerView = getView().findViewById(R.id.recyclerview);
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(this,mFir,mTim,mLoc);
        recyclerView.setAdapter(recyclerViewAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

}
