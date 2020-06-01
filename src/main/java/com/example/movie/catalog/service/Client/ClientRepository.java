package com.example.movie.catalog.service.Client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

//public interface ClientRepository extends JpaRepository<Client, Integer> {
public interface ClientRepository extends CrudRepository<Client, Integer> {

    Iterable<Client> findByType(String type);
}
