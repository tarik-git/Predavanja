package com.example.tvmazeapp.data.local;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.tvmazeapp.models.Show;

@Database(entities = {Show.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ShowDAO showDAO();

    private static final String DATABASE_NAME = "show_database";
    private static AppDatabase instance;

    public static AppDatabase getInstance(Context applicationContext) {
        if (instance == null) {
            instance = Room.databaseBuilder(
                    applicationContext,
                    AppDatabase.class,
                    DATABASE_NAME
            ).allowMainThreadQueries().build();
        }
        return instance;
    }

}
