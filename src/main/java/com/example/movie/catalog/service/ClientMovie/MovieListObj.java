package com.example.movie.catalog.service.ClientMovie;

import java.util.List;

public class MovieListObj {

    private List<Movie> movies;

    public MovieListObj(List<Movie> movies) {
        this.movies = movies;
    }

    public MovieListObj() {
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
}
