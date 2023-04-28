package com.example.practice_3.viewmodels;

import com.example.practice_3.model.Flower;
import com.example.practice_3.repository.FlowerRepository




import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class FilmListViewModel extends ViewModel {
    public LiveData<List<Flower>> films;

    public void init(){
        FlowerRepository flowerRepository = new FlowerRepository();
        films = flowerRepository.getRandomData();
    }

    public FilmListViewModel() {
        init();
    }
}
