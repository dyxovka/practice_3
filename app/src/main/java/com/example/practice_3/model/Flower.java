package com.example.practice_3.model;

public class Flower {
    private String name;
    private final int image_flower;

    public Flower(String name, int pic) {

        this.name = name;
        this.image_flower = pic;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int get_pic() {
        return this.image_flower;
    }
}
