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
import com.kuroptev.ivan.mobilestore.adapters.NewsRecyclerAdapter;
import com.kuroptev.ivan.mobilestore.pogo.News;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class NewsFragment extends Fragment {
    private final int LAYOUT = R.layout.fragment_news;
    private View view;
    private RecyclerView recyclerView;
    private List<News> list;
    DatabaseReference mData;

    public NewsFragment(){

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mData = FirebaseDatabase.getInstance().getReference().child("News");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(LAYOUT, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.info_recyler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mData.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                GenericTypeIndicator<Map<String, News>> typeIndicator = new GenericTypeIndicator<Map<String, News>>(){};
                Map<String, News> map = dataSnapshot.getValue(typeIndicator);
                recyclerView.setAdapter(new NewsRecyclerAdapter(getListNews(map), getContext()));

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        return view;
    }

    private List<News> getListNews(Map <String,News> map){
        list = new ArrayList<>();
        for (String keys : map.keySet()){
            list.add(map.get(keys));
        }
        return list;
    }
}
