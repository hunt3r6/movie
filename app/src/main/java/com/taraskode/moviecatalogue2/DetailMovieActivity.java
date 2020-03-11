package com.taraskode.moviecatalogue2;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailMovieActivity extends AppCompatActivity {
    public static final String EXTRA_DETAIL = "extra_movie";
    TextView tvTitle, tvDate, tvDes;
    ImageView imgDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);

        tvTitle = findViewById(R.id.tv_title);
        imgDetail = findViewById(R.id.img_detail);
        tvDate = findViewById(R.id.tv_date);
        tvDes = findViewById(R.id.tv_des);
        ActionBar actionBar = getSupportActionBar();


        MovieCatalogue movieCatalogue = getIntent().getParcelableExtra(EXTRA_DETAIL);

        if (movieCatalogue.getTitleMovie() != null) {
            tvTitle.setText(movieCatalogue.getTitleMovie());
            if (actionBar != null) {
                actionBar.setTitle(movieCatalogue.getTitleMovie());
            }
            imgDetail.setImageResource(movieCatalogue.getPosterMovie());
            tvDate.setText(movieCatalogue.getDateMovie());
            tvDes.setText(movieCatalogue.getDesMovie());
        } else {
            tvTitle.setText(movieCatalogue.getTitleTvShow());
            tvDes.setText(movieCatalogue.getDesTvShow());
            tvDate.setText(movieCatalogue.getDateTvShow());
            imgDetail.setImageResource(movieCatalogue.getPosterTvShow());
            if (actionBar != null) {
                actionBar.setTitle(movieCatalogue.getTitleTvShow());
            }

        }


    }
}
