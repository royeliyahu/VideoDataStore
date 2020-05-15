package com.example.movie.catalog.service.ClientMovie;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "client_movie")
public class ClientMovie {
    @Id
    @Column(name = "client_movie_id")
    private int clientMovieId;
    @Column(name = "client_id")
    private int clientId;
    @Column(name = "movie_id")
    private int movieId;
    private int rating;
    private String description;
    private String name;

    public ClientMovie(int clientMovieId, int clientId, int movieId, int rating) {
        this.clientMovieId = clientMovieId;
        this.clientId = clientId;
        this.movieId = movieId;
        this.rating = rating;
        this.description = "No description inserted";
        this.name = "No name inserted";
    }

    public ClientMovie(int clientMovieId, int clientId, int movieId, int rating, String description, String name) {
        this.clientMovieId = clientMovieId;
        this.clientId = clientId;
        this.movieId = movieId;
        this.rating = rating;
        this.description = description;
        this.name = name;
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

    public void setDescription(String description) {
        this.description = description;
    }

    public ClientMovie() {
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getClientMovieId() {
        return clientMovieId;
    }

    public void setClientMovieId(int clientMovieId) {
        this.clientMovieId = clientMovieId;
    }

    @Override
    public String toString() {
        return "ClientMovie{" +
                "clientMovieId=" + clientMovieId +
                ", clientId=" + clientId +
                ", movieId=" + movieId +
                ", rating=" + rating +
                ", description='" + description + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
