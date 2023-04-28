package com.ctacekscompany.cinemateque.model;

public class Film {
    private String name;
    private final int posterImage;

    public Film(String name, int pic) {

        this.name = name;
        this.posterImage = pic;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPictureResource() {
        return this.posterImage;
    }
}
