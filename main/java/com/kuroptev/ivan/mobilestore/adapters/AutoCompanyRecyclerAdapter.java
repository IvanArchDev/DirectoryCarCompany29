package com.kuroptev.ivan.mobilestore.adapters;


import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kuroptev.ivan.mobilestore.R;
import com.kuroptev.ivan.mobilestore.pogo.AttributeCompany;

import java.util.List;

public class AutoCompanyRecyclerAdapter extends RecyclerView.Adapter<AutoCompanyRecyclerAdapter.InformationHolder> {
    private List<AttributeCompany> data;

    public AutoCompanyRecyclerAdapter(List<AttributeCompany> data) {
        this.data = data;
    }

    @Override
    public InformationHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_chem_co, parent,false);
        return new InformationHolder(view);
    }

    @Override
    public void onBindViewHolder(InformationHolder holder, int position) {
        holder.title.setText(data.get(position).getTitle());

        if (data.get(position).getWebsite() != null){
            holder.website.setText(data.get(position).getWebsite());
        } else {
            holder.website.setVisibility(View.GONE);
        }
        if (data.get(position).getAddress1() != null){
            holder.address1.setText(data.get(position).getAddress1());
            holder.telephone1.setText(data.get(position).getTelephone1());
        } else {
            holder.address1.setVisibility(View.GONE);
            holder.telephone1.setVisibility(View.GONE);
        }
        if (data.get(position).getAddress2() != null){
            holder.address2.setText(data.get(position).getAddress2());
            holder.telephone2.setText(data.get(position).getTelephone2());
         } else {
            holder.address2.setVisibility(View.GONE);
            holder.telephone2.setVisibility(View.GONE);
        }
        if (data.get(position).getAddress3() != null){
            holder.address3.setText(data.get(position).getAddress3());
            holder.telephone3.setText(data.get(position).getTelephone3());
        } else {
            holder.address3.setVisibility(View.GONE);
            holder.telephone3.setVisibility(View.GONE);
        }
        if (data.get(position).getAddress4() != null){
            holder.address4.setText(data.get(position).getAddress4());
            holder.telephone4.setText(data.get(position).getTelephone4());
        } else {
            holder.address4.setVisibility(View.GONE);
            holder.telephone4.setVisibility(View.GONE);
        }
        if (data.get(position).getAddress5() != null){
            holder.address5.setText(data.get(position).getAddress5());
            holder.telephone5.setText(data.get(position).getTelephone5());
        } else {
            holder.address5.setVisibility(View.GONE);
            holder.telephone5.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class InformationHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        TextView address1, address2, address3,  address4, address5;
        TextView telephone1, telephone2, telephone3, telephone4, telephone5;
        TextView website;
        TextView title;
        public InformationHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.card_chem_co);
            title = (TextView) itemView.findViewById(R.id.titleChem);
            website = (TextView) itemView.findViewById(R.id.chemWebsite);
            address1 = (TextView) itemView.findViewById(R.id.address1);
            address2 = (TextView) itemView.findViewById(R.id.address2);
            address3 = (TextView) itemView.findViewById(R.id.address3);
            address4 = (TextView) itemView.findViewById(R.id.address4);
            address5 = (TextView) itemView.findViewById(R.id.address5);
            telephone1 = (TextView) itemView.findViewById(R.id.telephone1);
            telephone2 = (TextView) itemView.findViewById(R.id.telephone2);
            telephone3 = (TextView) itemView.findViewById(R.id.telephone3);
            telephone4 = (TextView) itemView.findViewById(R.id.telephone4);
            telephone5 = (TextView) itemView.findViewById(R.id.telephone5);
        }
    }
}
