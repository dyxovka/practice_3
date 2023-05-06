package com.example.practice_3.repository;

import android.app.Activity;
import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;


import com.example.practice_3.FlowerApp;
import com.example.practice_3.datasources.DataFlower;
import com.example.practice_3.datasources.room.FlowerDao;
import com.example.practice_3.datasources.room.FlowerRoomDatabase;
import com.example.practice_3.model.Flower;
import com.example.practice_3.model.FlowerEntity;

import java.util.List;
import java.util.stream.Collectors;

public class FlowerRepository {
    public FlowerDao flowerDao;

    private LiveData<List<Flower>> all_flowers;
    FlowerRoomDatabase db;

    FlowerRoomDatabase roomDatabase;
    public FlowerRepository(Context context) {
        db = FlowerRoomDatabase.getDatabase(context);
    }
    DataFlower dataFlower = new DataFlower();
    public DataFlower getter(){
        return dataFlower;
    }

    public FlowerRepository() {
        roomDatabase = FlowerApp.instance.getRoomDatabase();
        all_flowers = Transformations.map(
                db.flowerDao().getAllFlowers(),
                (values) -> values.stream().map(FlowerEntity::toDomainModel).collect(Collectors.toList())
        );
    }

    public LiveData<List<Flower>> getAllFlowers() {
        return all_flowers;
    }

    public  void setAddress(Context context, String filename, String fileContent){
        dataFlower.createFileAppSpecific(context, filename, fileContent);
    }
    public  void setAddress_1(Activity activity, String filename, String fileContent){
        dataFlower.createFileExtWithToast(activity, filename, fileContent);
    }
    public  void setAddress_2(Context context, String filename, String fileContent){
        dataFlower.createFileSharedPref(context, filename, fileContent);
    }


    public LiveData<List<Flower>> getRandomData(){return DataFlower.createRandomList();}
}
