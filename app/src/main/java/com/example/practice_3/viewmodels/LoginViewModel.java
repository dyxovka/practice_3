package com.example.practice_3.viewmodels;


import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.lifecycle.ViewModel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class LoginViewModel extends ViewModel {

    private static final int REQUEST_EXTERNAL_STORAGE = 1;

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
                Toast.makeText(context, "Файл в " + filePath+ "/" + fileName + ".tx t", Toast.LENGTH_SHORT).show();
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

    public void createFileSharedPreferences(Context context, String fileName, String fileContent) {
        SharedPreferences settings = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString( "loginInfo", fileContent);
        editor.apply();
        Toast.makeText(context, "Файл создан " + settings + fileName, Toast.LENGTH_SHORT).show();
        System.out.println("fiiiiile");
    }



}

