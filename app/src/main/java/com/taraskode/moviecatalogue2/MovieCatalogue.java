package com.taraskode.moviecatalogue2;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.app.FragmentActivity;

public class MovieCatalogue implements Parcelable {
    private String titleMovie;
    private String dateMovie;
    private String desMovie;
    private int posterMovie;
    private String titleTvShow;
    private String dateTvShow;
    private String desTvShow;
    private int posterTvShow;

    public String getTitleMovie() {
        return titleMovie;
    }

    public void setTitleMovie(String titleMovie) {
        this.titleMovie = titleMovie;
    }

    public String getDateMovie() {
        return dateMovie;
    }

    public void setDateMovie(String dateMovie) {
        this.dateMovie = dateMovie;
    }

    public String getDesMovie() {
        return desMovie;
    }

    public void setDesMovie(String desMovie) {
        this.desMovie = desMovie;
    }

    public int getPosterMovie() {
        return posterMovie;
    }

    public void setPosterMovie(int posterMovie) {
        this.posterMovie = posterMovie;
    }

    public String getTitleTvShow() {
        return titleTvShow;
    }

    public void setTitleTvShow(String titleTvShow) {
        this.titleTvShow = titleTvShow;
    }

    public String getDateTvShow() {
        return dateTvShow;
    }

    public void setDateTvShow(String dateTvShow) {
        this.dateTvShow = dateTvShow;
    }

    public String getDesTvShow() {
        return desTvShow;
    }

    public void setDesTvShow(String desTvShow) {
        this.desTvShow = desTvShow;
    }

    public int getPosterTvShow() {
        return posterTvShow;
    }

    public void setPosterTvShow(int posterTvShow) {
        this.posterTvShow = posterTvShow;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.titleMovie);
        dest.writeString(this.dateMovie);
        dest.writeString(this.desMovie);
        dest.writeInt(this.posterMovie);
        dest.writeString(this.titleTvShow);
        dest.writeString(this.dateTvShow);
        dest.writeString(this.desTvShow);
        dest.writeInt(this.posterTvShow);
    }

    public MovieCatalogue() {
    }

    protected MovieCatalogue(Parcel in) {
        this.titleMovie = in.readString();
        this.dateMovie = in.readString();
        this.desMovie = in.readString();
        this.posterMovie = in.readInt();
        this.titleTvShow = in.readString();
        this.dateTvShow = in.readString();
        this.desTvShow = in.readString();
        this.posterTvShow = in.readInt();
    }

    public static final Parcelable.Creator<MovieCatalogue> CREATOR = new Parcelable.Creator<MovieCatalogue>() {
        @Override
        public MovieCatalogue createFromParcel(Parcel source) {
            return new MovieCatalogue(source);
        }

        @Override
        public MovieCatalogue[] newArray(int size) {
            return new MovieCatalogue[size];
        }
    };
}
