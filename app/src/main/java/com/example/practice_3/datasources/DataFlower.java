package com.example.practice_3.datasources;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


import com.example.practice_3.R;
import com.example.practice_3.model.Flower;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataFlower{
    private static final int REQUEST_EXTERNAL_STORAGE = 1;

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
        flowers_pictures.add(R.drawable.flower_catalog_1);

        return flowers_pictures;
    }

    public void createFileAppSpecific(Context context, String fileName, String fileContent) {
        try (FileOutputStream fos = context.openFileOutput(fileName + ".txt", Context.MODE_PRIVATE)) {
            fos.write(fileContent.getBytes());
            File filePath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
            File file = new File(filePath, fileName + ".txt");
            Toast.makeText(context, "Файл в  " + context.getDataDir() + "/userName.txt", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void createFileExtWithToast(Activity activity, String fileName, String fileContent) {
        Context context = activity.getApplicationContext();
        if (context.getApplicationContext().checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                == PackageManager.PERMISSION_GRANTED) {
            File filePath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
            File file = new File(filePath, fileName + ".txt");
            FileOutputStream outputStream;
            try {
                outputStream = new FileOutputStream(file);
                outputStream.write(fileContent.getBytes());
                Toast.makeText(context, "Файл в:" + filePath+ "/" + fileName + ".txt", Toast.LENGTH_SHORT).show();
                System.out.println("fiiiiile");
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            ActivityCompat.requestPermissions(activity, new String[] {Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    REQUEST_EXTERNAL_STORAGE);
        }
    }

    public void createFileSharedPref(Context context, String fileName, String fileContent) {
        SharedPreferences settings = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString( "nothing", fileContent);
        editor.apply();
        Toast.makeText(context, "Файл создан " + settings + fileName, Toast.LENGTH_SHORT).show();
        System.out.println("fiiiiile");
    }

}
