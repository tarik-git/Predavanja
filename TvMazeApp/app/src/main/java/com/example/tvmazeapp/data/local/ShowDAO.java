package com.example.tvmazeapp.data.local;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.tvmazeapp.models.Show;

import java.util.List;

@Dao
public interface ShowDAO {

    @Insert
    public long insertShow(Show show);

    @Delete
    public void deleteShow(Show show);

    @Query("SELECT * FROM show_table")
    public List<Show> getAllShows();

    @Query("SELECT show_id FROM show_table WHERE show_id = :showId")
    public long isShowPresent(long showId);

}
