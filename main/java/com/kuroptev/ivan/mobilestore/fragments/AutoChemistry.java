package com.kuroptev.ivan.mobilestore.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kuroptev.ivan.mobilestore.R;
import com.kuroptev.ivan.mobilestore.adapters.AutoCompanyRecyclerAdapter;
import com.kuroptev.ivan.mobilestore.pogo.AttributeCompany;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AutoChemistry extends Fragment {
    private static final int LAYOUT = R.layout.fragment_chemistry_auto;
    private View mView;
    private RecyclerView mRecyclerView;
    DatabaseReference data;
    List<AttributeCompany> list;

    public AutoChemistry() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        data = FirebaseDatabase.getInstance().getReference().child("AutoChemistry");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(LAYOUT, container, false);
        mRecyclerView = (RecyclerView) mView.findViewById(R.id.info_recyler);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        data.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                GenericTypeIndicator<Map<String, AttributeCompany>> mapType = new GenericTypeIndicator<Map<String, AttributeCompany>>(){};
                Map<String, AttributeCompany> map = dataSnapshot.getValue(mapType);
                mRecyclerView.setAdapter(new AutoCompanyRecyclerAdapter(getListAutoCompany(map)));
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        return mView;
    }

    private List<AttributeCompany> getListAutoCompany(Map <String,AttributeCompany> map){
        list = new ArrayList<>();
        for (String keys : map.keySet()){
            list.add(map.get(keys));
        }
        return list;
    }

}
