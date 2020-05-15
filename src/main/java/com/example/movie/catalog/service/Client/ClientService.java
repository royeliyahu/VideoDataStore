package com.example.movie.catalog.service.Client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepository;

    List<Client> getAllClients(){
       List<Client> clients = new ArrayList<>();
       clientRepository.findAll().forEach(clients::add);

       return clients;
    }

    Client getClientById(int id){
        return clientRepository.findById(id).get();
    }

    List<Client> getClientsByType(String type){
        List<Client> clients = new ArrayList<>();
        clientRepository.findByType(type).forEach(clients::add);
        return clients;
    }

}
