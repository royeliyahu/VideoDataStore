package com.example.movie.catalog.service.ClientMovie;

import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClientMovieController {
    @Autowired
    ClientMovieService clientMovieService;

    @Autowired
    Environment environment;

    @RequestMapping("/clientMovies")
    public List<ClientMovie> getAllClientMovies(){
        return clientMovieService.getAllClientMovies();
    }

    @RequestMapping("/client/{id}/movies")
    public List<ClientMovie> getClientMoviesForClient(@PathVariable int id){
        return clientMovieService.getClientMoviesForClient(id);
    }

    @RequestMapping("/envdetails")
    public String getEnvDetails(){
        return environment.toString();
    }
}
