package com.kuroptev.ivan.mobilestore.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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

import static android.content.ContentValues.TAG;

public class Wheels extends Fragment {
    DatabaseReference mData;
    private static final int LAYOUT = R.layout.fragment_wheels;
    private View mView;
    private RecyclerView mRecyclerView;
    private List<AttributeCompany> attributeList;

    public Wheels() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mData = FirebaseDatabase.getInstance().getReference().child("Wheels");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_wheels, container, false);
        mRecyclerView = (RecyclerView) mView.findViewById(R.id.info_recyler);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mData.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                GenericTypeIndicator<Map<String,AttributeCompany>> dto = new GenericTypeIndicator<Map<String, AttributeCompany>>(){};
                Map<String, AttributeCompany> map = dataSnapshot.getValue(dto);
                mRecyclerView.setAdapter(new AutoCompanyRecyclerAdapter(getListAutoCompany(map)));
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w(TAG, "Failed to read value.", databaseError.toException());
            }
        });
        return mView;
    }

    private List<AttributeCompany> getListAutoCompany(Map<String, AttributeCompany> map) {
        attributeList = new ArrayList<>();
        for (String keys : map.keySet()){
            attributeList.add(map.get(keys));
        }
        return attributeList;
    }


}
