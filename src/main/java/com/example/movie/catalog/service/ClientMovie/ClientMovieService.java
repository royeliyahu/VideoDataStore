package com.example.movie.catalog.service.ClientMovie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientMovieService {

    @Autowired
    ClientMovieRepository clientMovieRepository;

    @Autowired
    // allowas an async calls  new way
    private WebClient.Builder webClientBuilder;

    public List<ClientMovie> getAllClientMovies() {
        List<ClientMovie> clientMovies = new ArrayList<>();

        clientMovieRepository.findAll().forEach(clientMovies::add);

        String str;

        str = clientMovies.stream().map(clientMovie -> Integer.valueOf(clientMovie.getMovieId()).toString())
                .collect(Collectors.joining(","));

        //add movie data from movie info service from movie list
        MovieListObj movieListObj = webClientBuilder.build()
                .get()//use get method (post, update...)
                .uri("http://localhost:8082/movies/list/" + str)//not using Eureka
                .retrieve()//get the data
                .bodyToMono(MovieListObj.class)//its an async call
                .block();//wait until data will be fulfiled an async call, WO it it was a sync call

        List<Movie> movieInfo = movieListObj.getMovies();

        clientMovies.forEach(clientMovie -> {
            Movie movie = movieInfo.stream().filter(movie1 -> movie1.getMovieId() == clientMovie.getMovieId()).findFirst().get();
            clientMovie.setDescription(movie.getDescription());
            clientMovie.setName(movie.getName());
        });
        return clientMovies;
    }

    public List<ClientMovie> getClientMoviesForClient(int id) {
        List<ClientMovie> clientMovies = new ArrayList<>();

        clientMovieRepository.findByClientId(id).forEach(clientMovies::add);

        //add movie data from movie info service one movie at a time

        clientMovies.forEach(clientMovie -> {
            Movie movieInfo = webClientBuilder.build()
                    .get()//use get method (post, update...)
                    .uri("http://localhost:8082/movies/" + clientMovie.getMovieId())//not using Eureka
                    .retrieve()//get the data
                    .bodyToMono(Movie.class)//its an async call
                    .block();//waite until data will be fulfiled an async call, WO it it was a sync call
            clientMovie.setDescription(movieInfo.getDescription());
            clientMovie.setName(movieInfo.getName());
        });


        return clientMovies;
    }
}
