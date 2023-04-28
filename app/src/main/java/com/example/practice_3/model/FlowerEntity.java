package com.example.practice_3.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "flower_table")
public class FlowerEntity {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "flower_name")
    private String name;
    private int picture;
    public FlowerEntity(@NonNull String name, int pic) {
        this.name = name;
        this.picture = pic;
    }
    public FlowerEntity() {
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getPicture() {
        return picture;
    }
    public void setPicture(int picture) {
        this.picture = picture;
    }
    @NonNull
    public String getName() {
        return this.name;
    }
    public void setName(@NonNull String name) {
        this.name = name;
    }
    public int getPictureResource() {
        return this.picture;
    }
}