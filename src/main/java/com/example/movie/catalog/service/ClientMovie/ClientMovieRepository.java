package com.example.movie.catalog.service.ClientMovie;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ClientMovieRepository extends CrudRepository<ClientMovie, Integer> {

    List<ClientMovie> findByClientId(int id);
}
