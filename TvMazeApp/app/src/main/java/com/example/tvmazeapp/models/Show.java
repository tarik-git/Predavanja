package com.example.tvmazeapp.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "show_table")
public class Show {
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "show_id")
    public long showId;
    @ColumnInfo(name = "poster_url")
    public String posterUrl;
    @ColumnInfo(name = "show_name")
    public String showName;
    @ColumnInfo(name = "original_poster_url")
    public String originalPosterUrl;
    @ColumnInfo(name = "show_rating")
    public double showRating;
    @ColumnInfo(name = "show_premiered")
    public String showPremiered;
    @ColumnInfo(name = "show_site")
    public String showSite;
    @ColumnInfo(name = "show_summary")
    public String showSummary;

    @Override
    public String toString() {
        return "Show{" +
                "showId=" + showId +
                ", posterUrl='" + posterUrl + '\'' +
                ", showName='" + showName + '\'' +
                ", originalPosterUrl='" + originalPosterUrl + '\'' +
                ", showRating=" + showRating +
                ", showPremiered='" + showPremiered + '\'' +
                ", showSite='" + showSite + '\'' +
                ", showSummary='" + showSummary + '\'' +
                '}';
    }
}
