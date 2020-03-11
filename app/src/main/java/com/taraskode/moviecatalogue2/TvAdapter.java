package com.taraskode.moviecatalogue2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class TvAdapter extends RecyclerView.Adapter<TvAdapter.TvViewHolder> {
    private Context context;
    private ArrayList<MovieCatalogue> listTv;

    public ArrayList<MovieCatalogue> getListTv() {
        return listTv;
    }

    public void setListTv(ArrayList<MovieCatalogue> listTv) {
        this.listTv = listTv;
    }

    public TvAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public TvViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tv, parent, false);
        return new TvViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TvViewHolder holder, int position) {
        MovieCatalogue a = getListTv().get(position);
        Glide.with(context)
                .load(a.getPosterTvShow())
                .apply(new RequestOptions().override(350, 550))
                .into(holder.imgTv);
        holder.tvTitleTv.setText(a.getTitleTvShow());
        holder.tvDateTv.setText(a.getDateTvShow());
        holder.tvDesTv.setText(a.getDesTvShow());

    }

    @Override
    public int getItemCount() {
        return getListTv().size();
    }

    public class TvViewHolder extends RecyclerView.ViewHolder {
        ImageView imgTv;
        TextView tvTitleTv, tvDateTv, tvDesTv;

        public TvViewHolder(@NonNull View itemView) {
            super(itemView);

            imgTv = itemView.findViewById(R.id.img_tv);
            tvTitleTv = itemView.findViewById(R.id.tv_tv);
            tvDateTv = itemView.findViewById(R.id.tv_date_tv);
            tvDesTv = itemView.findViewById(R.id.tv_desTv);


        }
    }
}
