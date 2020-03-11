package com.taraskode.moviecatalogue2;


import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class TvShowFragment extends Fragment {

    private RecyclerView rvCategory;
    private ArrayList<MovieCatalogue> tv = new ArrayList<>();
    private String[] titleTv, dateTv, desTv;
    TypedArray posterTv;
    TvAdapter adapter;


    public TvShowFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tv_show, container, false);

        adapter = new TvAdapter(getContext());
        rvCategory = view.findViewById(R.id.rv_tv);
        rvCategory.setHasFixedSize(true);
        tv = new ArrayList<>();

        prepare();
        addItem();
        showTvRecycler();

        return view;
    }

    private void showTvRecycler() {
        rvCategory.setLayoutManager(new LinearLayoutManager(getContext()));
        TvAdapter tvAdapter = new TvAdapter(getContext());
        tvAdapter.setListTv(tv);
        rvCategory.setAdapter(tvAdapter);
        ItemClickSupport.addTo(rvCategory).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                showDetailTv(tv.get(position));

            }
        });

    }

    public void showDetailTv(MovieCatalogue movieCatalogue) {

        /*Toast.makeText(getContext(), "kamu memilih " + movieCatalogue.getTitleTvShow(), Toast.LENGTH_SHORT).show();*/
        MovieCatalogue detail = new MovieCatalogue();
        detail.setTitleTvShow(movieCatalogue.getTitleTvShow());
        detail.setPosterTvShow(movieCatalogue.getPosterTvShow());
        detail.setDateTvShow(movieCatalogue.getDateTvShow());
        detail.setDesTvShow(movieCatalogue.getDesTvShow());

        Intent detailIntent = new Intent(getContext(), DetailMovieActivity.class);
        detailIntent.putExtra(DetailMovieActivity.EXTRA_DETAIL, detail);
        startActivity(detailIntent);
    }

    private void prepare() {
        titleTv = getResources().getStringArray(R.array.title_tvshow);
        dateTv = getResources().getStringArray(R.array.date_tvshow);
        desTv = getResources().getStringArray(R.array.descriptions_tvshow);
        posterTv = getResources().obtainTypedArray(R.array.poster_tvshow);
    }

    private void addItem() {

        for (int i = 0; i < titleTv.length; i++) {
            MovieCatalogue tvCatalogue = new MovieCatalogue();
            tvCatalogue.setTitleTvShow(titleTv[i]);
            tvCatalogue.setDateTvShow(dateTv[i]);
            tvCatalogue.setDesTvShow(desTv[i]);
            tvCatalogue.setPosterTvShow(posterTv.getResourceId(i, -1));
            tv.add(tvCatalogue);

        }
        adapter.setListTv(tv);

    }

}
