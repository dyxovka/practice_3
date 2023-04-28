package com.ctacekscompany.cinemateque.datasources;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.ctacekscompany.cinemateque.R;
import com.ctacekscompany.cinemateque.model.Film;

import java.util.ArrayList;
import java.util.List;

public class DataFilm {

    public static LiveData<List<Film>> createRandomList() {
        MutableLiveData<List<Film>> result = new MutableLiveData<>();
        ArrayList<Film> randomFilms = new ArrayList<>();
        ArrayList<Integer> posterPics = createPosterPics();
        for (int i = 1; i <= 200; i++) {
            randomFilms.add(new Film("Avatar " + i, posterPics.get(i % 4)));
        }
        result.setValue(randomFilms);
        return result;
    }

    private static ArrayList<Integer> createPosterPics() {
        ArrayList<Integer> posterPics = new ArrayList<>();
        posterPics.add(R.drawable.back_to_the_future);
        posterPics.add(R.drawable.harry_potter);
        posterPics.add(R.drawable.hobbit);
        posterPics.add(R.drawable.star_wars);
        return posterPics;
    }

}
