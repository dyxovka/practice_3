package com.example.practice_3.repository;

import android.content.Context;

import androidx.lifecycle.LiveData;


import com.example.practice_3.FlowerApp;
import com.example.practice_3.datasources.DataFlower;
import com.example.practice_3.datasources.room.FlowerDao;
import com.example.practice_3.datasources.room.FlowerRoomDatabase;
import com.example.practice_3.model.Flower;
import com.example.practice_3.model.FlowerEntity;

import java.util.List;

public class FlowerRepository {
    public FlowerDao flowerDao;

    private LiveData<List<FlowerEntity>> all_flowers;

    FlowerRoomDatabase roomDatabase;
    public FlowerRepository(Context context) {
        FlowerRoomDatabase db = FlowerRoomDatabase.getDatabase(context);
        flowerDao = db.flowerDao();
    }

    public FlowerRepository() {
        roomDatabase = FlowerApp.instance.getRoomDatabase();
        flowerDao = FlowerApp.instance.getRoomDatabase().flowerDao();
        all_flowers = flowerDao.getAllFlowers();
    }
    public LiveData<List<FlowerEntity>> getAllFlowers() {
        return all_flowers;
    }
    public LiveData<List<Flower>> getRandomData(){return DataFlower.createRandomList();}
}
