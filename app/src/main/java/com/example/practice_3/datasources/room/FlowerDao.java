package com.example.practice_3.datasources.room;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.practice_3.model.FlowerEntity;

import java.util.List;


@Dao
public interface FlowerDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(FlowerEntity flower);

    @Query("DELETE FROM flower_table")
    void deleteAll();

    @Query("SELECT * FROM flower_table ORDER BY id")
    LiveData<List<FlowerEntity>> getAllFlowers();
}