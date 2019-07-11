package com.edwinnyawoli.templateapplication.data.local;

import android.content.Context;

import com.edwinnyawoli.templateapplication.data.local.dao.TestModelDao;
import com.edwinnyawoli.templateapplication.data.model.TestModelEntity;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

/**
 *
 */

@Database(entities = {TestModelEntity.class}, version = AppDatabase.VERSION)
public abstract class AppDatabase extends RoomDatabase {
    public static final int VERSION = 1;
    public static final String NAME = "TemplateDB";
    private static volatile AppDatabase INSTANCE;

    public static AppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, AppDatabase.NAME)
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }

        return INSTANCE;
    }

    public abstract TestModelDao testModelDao();
}
