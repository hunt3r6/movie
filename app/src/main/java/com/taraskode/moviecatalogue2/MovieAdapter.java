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

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.CardViewHolder> {
    private Context context;
    private ArrayList<MovieCatalogue> listMovie;

    public ArrayList<MovieCatalogue> getListMovie() {
        return listMovie;
    }

    public void setListMovie(ArrayList<MovieCatalogue> listMovie) {
        this.listMovie = listMovie;
    }

    public MovieAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie, parent, false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        MovieCatalogue p = getListMovie().get(position);
        Glide.with(context)
                .load(p.getPosterMovie())
                .apply(new RequestOptions().override(400, 600))
                .into(holder.imgMovie);

        holder.tvTitleMovie.setText(p.getTitleMovie());
        holder.tvDateMovie.setText(p.getDateMovie());
        holder.tvDesMovie.setText(p.getDesMovie());

    }

    @Override
    public int getItemCount() {
        return getListMovie().size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder {
        ImageView imgMovie;
        TextView tvTitleMovie, tvDateMovie, tvDesMovie;

        public CardViewHolder(@NonNull View itemView) {
            super(itemView);

            imgMovie = itemView.findViewById(R.id.img_movie);
            tvTitleMovie = itemView.findViewById(R.id.tv_movie);
            tvDateMovie = itemView.findViewById(R.id.tv_date_movie);
            tvDesMovie = itemView.findViewById(R.id.tv_desMovie);

        }
    }
}
