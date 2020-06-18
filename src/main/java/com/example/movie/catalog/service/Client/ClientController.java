package com.example.movie.catalog.service.Client;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClientController {

    @Autowired
    ClientService clientService;

    @ApiOperation(value = "value", notes = "notes", response = Client.class) //Swagger html info
    @RequestMapping("/clients")
    List<Client> getAllClients(){
        return clientService.getAllClients();
    }

    @RequestMapping("/clients/{id}")
    Client getClientById(@PathVariable int id){
        return clientService.getClientById(id);
    }

    @RequestMapping("/clients/type/{type}")
    List<Client> getClientsByType(@PathVariable String type){
        return clientService.getClientsByType(type);
    }

    @RequestMapping("/")
    String root(){
        return "Hi there, Rating Data Service is online!<br>please check swagger-ui.html# for available commands";
    }
}
