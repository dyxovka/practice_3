package com.example.practice_3;

import android.app.Application;

import com.example.practice_3.datasources.room.FlowerRoomDatabase;
import com.example.practice_3.repository.FlowerRepository;


public class FlowerApp extends Application {
    private FlowerRoomDatabase roomDatabase;
    private FlowerRepository flowerRepository;
    public static FlowerApp instance;
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        roomDatabase = FlowerRoomDatabase.getDatabase(this);
        flowerRepository = new FlowerRepository();

    }

    public FlowerRepository getFlowerRepository(){
        return flowerRepository;
    }

    public FlowerRoomDatabase getRoomDatabase(){
        return roomDatabase;
    }

}
