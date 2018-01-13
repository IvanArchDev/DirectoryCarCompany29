package com.kuroptev.ivan.mobilestore.adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.kuroptev.ivan.mobilestore.R;
import com.kuroptev.ivan.mobilestore.pogo.InfoFuel;
import com.squareup.picasso.Picasso;

import java.util.List;

public class FuelStationRecyclerAdapter extends RecyclerView.Adapter<FuelStationRecyclerAdapter.InformationHolder> {

    private List<InfoFuel> data;
    private Context context;

    public FuelStationRecyclerAdapter(List<InfoFuel> data, Context context) {

        this.data = data;
        this.context = context;
    }

    @Override
    public InformationHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_fuel_st, viewGroup, false);
        return new InformationHolder(view);
    }

    @Override
    public void onBindViewHolder(InformationHolder informationHolder, int position) {
//        informationHolder.title.setText(data.get(position).getTitle());
        informationHolder.price.setText(data.get(position).getPrice());
        informationHolder.typeStation.setText(data.get(position).getTypeStation());
        Picasso.with(context).load(data.get(position).getLogoStation()).into(informationHolder.logoStation);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class InformationHolder extends RecyclerView.ViewHolder {
        CardView cardView;
       // TextView title;
        TextView price;
        TextView typeStation;
        ImageView logoStation;

        public InformationHolder(View itemView) {
            super(itemView);
           // title = (TextView) itemView.findViewById(R.id.title_st);
            price = (TextView) itemView.findViewById(R.id.price);
            typeStation = (TextView) itemView.findViewById(R.id.typeStation);
            logoStation = (ImageView) itemView.findViewById(R.id.logoStation);
            cardView = (CardView) itemView.findViewById(R.id.card_info_fuel);
        }
    }
}
