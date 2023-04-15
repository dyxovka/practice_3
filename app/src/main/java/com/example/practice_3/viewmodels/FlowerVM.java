package com.example.practice_3.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;


import com.example.practice_3.model.Flower;
import com.example.practice_3.repository.FlowerRepository;

import java.util.List;

public class FlowerVM extends ViewModel {
    public LiveData<List<Flower>> flower;

    public void init(){
        FlowerRepository flowerRepository = new FlowerRepository();
        flower = flowerRepository.getRandomData();
    }

    public FlowerVM() {
        init();
    }
}
