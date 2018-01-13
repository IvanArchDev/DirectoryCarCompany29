//package com.example.ivan.mobilestore.adapters;
//
//import android.app.Application;
//import android.content.Context;
//import android.support.v7.widget.CardView;
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.webkit.WebView;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import com.example.ivan.mobilestore.R;
//import com.example.ivan.mobilestore.dto.InfoDealer;
//import com.squareup.picasso.Picasso;
//
//import java.util.List;
//
//
//public class DealersRecyclerAdapter  extends RecyclerView.Adapter<DealersRecyclerAdapter.InformationHolder>{
//
//    private List<InfoDealer> data;
//    Context context;
//
//    public DealersRecyclerAdapter(List<InfoDealer> data, Context ctx) {
//        this.data = data;
//        this.context = ctx;
//    }
//
//    @Override
//    public DealersRecyclerAdapter.InformationHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
//        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_dealers, viewGroup, false);
//        return new DealersRecyclerAdapter.InformationHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(DealersRecyclerAdapter.InformationHolder informationHolder, int position) {
//        informationHolder.title.setText(data.get(position).getTitle());
//        informationHolder.telephoneNumberOp.setText(data.get(position).getTelephoneNumberOp());
//        informationHolder.telephoneNumberSr.setText(data.get(position).getTelephoneNumberSr());
//        informationHolder.webSite.setText(data.get(position).getWebSite());
//        informationHolder.address.setText(data.get(position).getAddress());
//        informationHolder.city.setText(data.get(position).getCity());
//       // informationHolder.setImage(context, data.get(position).getLogo());
//        Picasso.with(context)
//                .load(data.get(position).getLogo())
//                .fit()
//                .into(informationHolder.logo);
//    }
//
//    @Override
//    public int getItemCount() {
//        return data.size();
//    }
//
//    public static class InformationHolder extends RecyclerView.ViewHolder {
//        CardView cardView;
//        TextView title;
//        TextView telephoneNumberOp;
//        TextView telephoneNumberSr;
//        TextView webSite;
//        TextView address;
//        TextView city;
//        ImageView logo;
//        public InformationHolder(View itemView) {
//            super(itemView);
//            title = (TextView) itemView.findViewById(R.id.titleDealers);
//            telephoneNumberOp = (TextView) itemView.findViewById(R.id.telephoneNumberOp);
//            telephoneNumberSr = (TextView) itemView.findViewById(R.id.telephoneNumberSr);
//            webSite = (TextView) itemView.findViewById(R.id.webSiteDealers);
//            address = (TextView) itemView.findViewById(R.id.addressDealers);
//            city = (TextView) itemView.findViewById(R.id.cityDealers);
//            logo = (ImageView) itemView.findViewById(R.id.imageView3);
//            cardView =(CardView) itemView.findViewById(R.id.dealers_card);
//        }
//
//        public void setImage(Context ctx, String uri){
//            Picasso.with(ctx)
//                    .load(uri)
//                    .error(R.drawable.ic_chery_logo)
//                    .fit()
//                    .into(logo);
//        }
//    }
//}

