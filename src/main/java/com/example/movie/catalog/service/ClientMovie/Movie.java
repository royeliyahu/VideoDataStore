package com.example.movie.catalog.service.ClientMovie;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

public class Movie {

    int movieId;
    String name;
    String description;

    public Movie(int movieId, String name, String description) {
        this.movieId = movieId;
        this.name = name;
        this.description = description;
    }

    public Movie() {
    }

    public Movie(int movieId) {
        this.movieId = movieId;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String desdription) {
        this.description = desdription;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieId=" + movieId +
                ", name='" + name + '\'' +
                ", desdription='" + description + '\'' +
                '}';
    }
}
