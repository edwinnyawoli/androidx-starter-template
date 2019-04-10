package com.edwinnyawoli.templateapplication.data.local.dao;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Update;

import java.util.List;

/**
 *
 */

public interface BaseDao<T> {
    @Insert
    long insert(T data);

    @Update
    int update(T data);

    @Insert
    List<Long> insertAll(T... args);

    @Delete
    int delete(T data);

    @Delete
    int deleteAll(T... args);
}
