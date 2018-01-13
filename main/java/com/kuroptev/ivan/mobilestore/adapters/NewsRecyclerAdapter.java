package com.kuroptev.ivan.mobilestore.adapters;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.kuroptev.ivan.mobilestore.R;
import com.kuroptev.ivan.mobilestore.pogo.News;
import com.squareup.picasso.Picasso;

import java.util.List;

public class NewsRecyclerAdapter extends RecyclerView.Adapter<NewsRecyclerAdapter.NewsHolder>{
    List<News> listNews;
    Context context;

    public NewsRecyclerAdapter(List<News> listNews, Context context){
       this.listNews = listNews;
        this.context = context;
    }
    @Override
    public NewsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_news, parent,false);
        return new NewsHolder(view);
    }

    @Override
    public void onBindViewHolder(NewsHolder holder, int position) {
        holder.titleNews.setText(listNews.get(position).getTitleNews());
        holder.textNews.setText(listNews.get(position).getTextNews());
        holder.linkNews.setText(listNews.get(position).getLinkNews());
        Picasso.with(context).load(listNews.get(position).getImage()).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return listNews.size();
    }

    public static class NewsHolder extends RecyclerView.ViewHolder {
        TextView titleNews;
        TextView textNews;
        TextView linkNews;
        ImageView image;


        public NewsHolder(View itemView) {
            super(itemView);
            titleNews = (TextView) itemView.findViewById(R.id.titleNews);
            textNews = (TextView) itemView.findViewById(R.id.textNews);
            linkNews = (TextView) itemView.findViewById(R.id.linkNews);
            image = (ImageView) itemView.findViewById(R.id.imageNews);


        }
    }

}
