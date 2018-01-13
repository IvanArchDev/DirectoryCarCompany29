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
import com.kuroptev.ivan.mobilestore.adapters.FuelStationRecyclerAdapter;
import com.kuroptev.ivan.mobilestore.pogo.InfoFuel;
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

public class FuelDT extends Fragment {
    private DatabaseReference mData;
    private List<InfoFuel> listFuelStation;
    private RecyclerView recyclerView;
    private View view;

    public FuelDT(){}

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mData = FirebaseDatabase.getInstance().getReference().child("FuelOctanNumer").child("DT");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_fuel92, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.fuel_recyler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mData.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                GenericTypeIndicator<Map<String, InfoFuel>> dto = new GenericTypeIndicator<Map<String, InfoFuel>>() {
                };
                Map<String, InfoFuel> map = dataSnapshot.getValue(dto);
                recyclerView.setAdapter(new FuelStationRecyclerAdapter(getListFuelCompany(map), getContext()));
                Log.d(TAG, "Value is: " + map);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w(TAG, "Failed to read value.", databaseError.toException());
            }
        });

        return view;
    }

    private List<InfoFuel> getListFuelCompany(Map<String,InfoFuel> map){
        listFuelStation = new ArrayList<>();
        for (String keys : map.keySet()){
            listFuelStation.add(map.get(keys));
        }
        return listFuelStation;
    }
}
