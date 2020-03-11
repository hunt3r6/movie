package com.taraskode.moviecatalogue2;


import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Movie;
import android.media.midi.MidiOutputPort;
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
public class MoviesFragment extends Fragment {

    private RecyclerView rvCategory;
    private ArrayList<MovieCatalogue> movies = new ArrayList<>();
    private String[] titleMovie, dateMovie, desMovie;
    TypedArray posterMovie;
    MovieAdapter adapter;


    public MoviesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_movies, container, false);

        adapter = new MovieAdapter(getContext());
        rvCategory = view.findViewById(R.id.rv_movie);
        rvCategory.setHasFixedSize(true);
        movies = new ArrayList<>();
        prepare();
        addItem();
        showRecycler();

        return view;
    }

    private void showRecycler() {
        rvCategory.setLayoutManager(new LinearLayoutManager(getContext()));
        MovieAdapter movieAdapter = new MovieAdapter(getContext());
        movieAdapter.setListMovie(movies);
        rvCategory.setAdapter(movieAdapter);
        ItemClickSupport.addTo(rvCategory).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                showDetailMovie(movies.get(position));
            }
        });

    }

    public void showDetailMovie(MovieCatalogue movieCatalogue) {
        /*Toast.makeText`(getContext(), "kamu memilih " + movieCatalogue.getTitleMovie(), Toast.LENGTH_SHORT).show();*/
        Intent detailIntent = new Intent(getContext(), DetailMovieActivity.class);
        detailIntent.putExtra(DetailMovieActivity.EXTRA_DETAIL, movieCatalogue);
        startActivity(detailIntent);
    }

    private void prepare() {
        titleMovie = getResources().getStringArray(R.array.title_movies);
        dateMovie = getResources().getStringArray(R.array.date_movies);
        desMovie = getResources().getStringArray(R.array.descriptions_movies);
        posterMovie = getResources().obtainTypedArray(R.array.poster_movie);
    }

    private void addItem() {

        for (int i = 0; i < titleMovie.length; i++) {
            MovieCatalogue movieCatalogue = new MovieCatalogue();
            movieCatalogue.setTitleMovie(titleMovie[i]);
            movieCatalogue.setDateMovie(dateMovie[i]);
            movieCatalogue.setDesMovie(desMovie[i]);
            movieCatalogue.setPosterMovie(posterMovie.getResourceId(i, -1));
            movies.add(movieCatalogue);

        }
        adapter.setListMovie(movies);

    }


}
