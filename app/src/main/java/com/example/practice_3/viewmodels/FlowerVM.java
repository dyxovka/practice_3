package com.example.practice_3.viewmodels;

import android.app.Activity;
import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;


import com.example.practice_3.datasources.DataFlower;
import com.example.practice_3.model.Flower;
import com.example.practice_3.repository.FlowerRepository;

import java.util.List;

public class FlowerVM extends ViewModel {
    public LiveData<List<Flower>> flower;


    public void init(){
        FlowerRepository flowerRepository = new FlowerRepository();
        flower = flowerRepository.getAllFlowers();
    }
    FlowerRepository flowerRepository = new FlowerRepository();
    public FlowerRepository getter(){
        return flowerRepository;
    }
    public void setAddress(Context context, String filename, String fileContent){
        flowerRepository.setAddress(context, filename, fileContent);
    }
    public void setAddress_1(Activity activity, String filename, String fileContent){
        flowerRepository.setAddress_1(activity, filename, fileContent);
    }

    public void setAddress_2(Context context, String filename, String fileContent){
        flowerRepository.setAddress_2(context, filename, fileContent);
    }


    public FlowerVM() {
        init();
    }
}
