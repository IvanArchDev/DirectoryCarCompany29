//package com.example.ivan.mobilestore.fragments;
//
//import android.content.Context;
//import android.os.Bundle;
//import android.support.annotation.Nullable;
//import android.support.v4.app.Fragment;
//import android.support.v7.widget.LinearLayoutManager;
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//
//import com.example.ivan.mobilestore.R;
//import com.example.ivan.mobilestore.adapters.AutoCompanyRecyclerAdapter;
//import com.example.ivan.mobilestore.adapters.DealersRecyclerAdapter;
//import com.example.ivan.mobilestore.dto.InfoAutoDto;
//import com.example.ivan.mobilestore.dto.InfoDealer;
//import com.google.firebase.database.DataSnapshot;
//import com.google.firebase.database.DatabaseError;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//import com.google.firebase.database.GenericTypeIndicator;
//import com.google.firebase.database.ValueEventListener;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
//public class AutoOfficialDealers extends Fragment {
//    private static final int LAYOUT = R.layout.fragment_official_dealers;
//    private View mView;
//    private RecyclerView mRecyclerView;
//    DatabaseReference mData;
//    List<InfoDealer> dealersList;
//    Context ctx;
//
//    public AutoOfficialDealers(){
//
//    }
//
//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        mData= FirebaseDatabase.getInstance().getReference().child("Dealers");
//        ctx = getActivity().getApplicationContext();
//    }
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        mView = inflater.inflate(LAYOUT, container, false);
//        mRecyclerView = (RecyclerView) mView.findViewById(R.id.info_recyler);
//        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
//        mData.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                GenericTypeIndicator<Map<String,InfoDealer>> dto = new GenericTypeIndicator<Map<String, InfoDealer>>(){};
//                Map<String, InfoDealer> map = dataSnapshot.getValue(dto);
//                mRecyclerView.setAdapter(new DealersRecyclerAdapter(getDealersList(map), getContext()));
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });
//        return mView;
//    }
//
//    private List<InfoDealer> getDealersList(Map<String,InfoDealer> map){
//        dealersList = new ArrayList<>();
//        for (String keys : map.keySet()){
//            dealersList.add(map.get(keys));
//        }
//        return dealersList;
//    }
//
//}