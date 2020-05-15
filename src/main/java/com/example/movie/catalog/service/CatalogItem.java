package com.example.movie.catalog.service;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CatalogItem {
    @Id
    public String name;
    public String descr;
    public int rating;

    public CatalogItem(String name, String descr, int rating) {
        this.name = name;
        this.descr = descr;
        this.rating = rating;
    }

    public CatalogItem() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
