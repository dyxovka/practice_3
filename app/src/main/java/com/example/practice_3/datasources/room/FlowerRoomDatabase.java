package com.example.practice_3.datasources.room;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.practice_3.R;
import com.example.practice_3.model.FlowerEntity;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;



@Database(entities = {FlowerEntity.class}, version = 1, exportSchema = false)
public abstract class FlowerRoomDatabase extends RoomDatabase {
    public abstract FlowerDao flowerDao();
    private static volatile FlowerRoomDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static FlowerRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (FlowerRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    FlowerRoomDatabase.class, "flower_db")
                            .allowMainThreadQueries()
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }
    public static final RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            ArrayList<Integer> pictures = doPictures();
            databaseWriteExecutor.execute(() -> {
                FlowerDao dao = INSTANCE.flowerDao();
                for (int i = 0; i < 200; i++) {
                    FlowerEntity flower = new FlowerEntity("Flower1" + i, pictures.get(i % 3));
                    dao.insert(flower);
                }
            });
        }
    };
    private static ArrayList<Integer> doPictures() {
        ArrayList<Integer> posterPics = new ArrayList<>();
        posterPics.add(R.drawable.flower_catalog_1);
        posterPics.add(R.drawable.flower_catalog_2);
        posterPics.add(R.drawable.flower_catalog_1);
        return posterPics;
    }
}
