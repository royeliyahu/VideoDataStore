package com.example.movie.catalog.service.Client;

import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client, Integer> {

    Iterable<Client> findByType(String type);
}
