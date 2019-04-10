package com.edwinnyawoli.templateapplication.data.local;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.edwinnyawoli.templateapplication.data.local.dao.TestModelDao;
import com.edwinnyawoli.templateapplication.data.model.TestModelEntity;

/**
 *
 */

@Database(entities = {TestModelEntity.class}, version = AppDatabase.VERSION)
public abstract class AppDatabase extends RoomDatabase {
    public static final int VERSION = 1;
    public static final String NAME = "TemplateDB";

    public abstract TestModelDao testModelDao();
}
