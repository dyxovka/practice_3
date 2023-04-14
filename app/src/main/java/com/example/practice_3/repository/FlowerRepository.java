package com.example.practice_3.repository;

import androidx.lifecycle.LiveData;


import com.example.practice_3.datasources.DataFlower;
import com.example.practice_3.model.Flower;

import java.util.List;

public class FlowerRepository {
    public LiveData<List<Flower>> getRandomData(){
        return DataFlower.createRandomList();
    }
}
