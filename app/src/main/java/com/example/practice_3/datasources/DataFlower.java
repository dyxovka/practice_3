package com.example.practice_3.datasources;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


import com.example.practice_3.R;
import com.example.practice_3.model.Flower;

import java.util.ArrayList;
import java.util.List;

public class DataFlower{

    public static LiveData<List<Flower>> createRandomList() {
        MutableLiveData<List<Flower>> result = new MutableLiveData<>();
        ArrayList<Flower> randomFlowers = new ArrayList<>();
        ArrayList<Integer> posterPics = flowers_pictures_array();
        for (int i = 1; i <= 200; i++) {
            randomFlowers.add(new Flower("Букет " + i, posterPics.get(i%3)));
        }
        result.setValue(randomFlowers);
        return result;
    }

    private static ArrayList<Integer> flowers_pictures_array() {
        ArrayList<Integer> flowers_pictures = new ArrayList<>();
        flowers_pictures.add(R.drawable.flower_catalog_2);
        flowers_pictures.add(R.drawable.flower_catalog_1);
        flowers_pictures.add(R.drawable.flower_1);
        return flowers_pictures;
    }

}
