package com.example.movie.catalog.service.ClientMovie;

import com.example.movie.catalog.service.Client.Client;
import com.netflix.discovery.DiscoveryClient;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
//import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.springframework.web.reactive.function.client.ExchangeFilterFunctions.basicAuthentication;

@Service
public class ClientMovieService {

    //you can load a relevant repository acording to your profile look at: https://www.youtube.com/watch?v=JSdy9Q8Uk34&list=PLqq-6Pq4lTTaoaVoQVfRJPqvNTCjcTvJB&index=8
    @Autowired
    private ClientMovieRepository clientMovieRepository;

    @Autowired
    // allowas an async calls  new way
    private WebClient.Builder webClientBuilder;

    @Value("${api.key}")//injected value from properties file
    private String apiKey;

    @Value("${api.key}")//injected value from properties file
    private List<String> strList;

    @Value("${martin.id}")
    private String mid;
    @Value("${martin.name}")
    private String mname;
    @Value("${martin.type}")
    private String mType;

    Logger logger = LoggerFactory.getLogger(ClientMovieService.class);

    public List<ClientMovie> getAllClientMovies() {
        logger.debug("getAllClientMovies  - log");
        List<ClientMovie> clientMovies = new ArrayList<>();

        System.err.println("api key: " + apiKey);
        strList.forEach(System.err::println);

        clientMovieRepository.findAll().forEach(clientMovies::add);


        String str;
        str = clientMovies.stream().map(clientMovie -> Integer.valueOf(clientMovie.getMovieId()).toString())
                .collect(Collectors.joining(","));

        //add movie data from movie info service from movie list
        MovieListObj movieListObj = null;
        try{
            movieListObj = webClientBuilder.filter(basicAuthentication("roy", "roy"))
                    .build()
                    .get()//use get method (post, update...)
//                .uri("http://localhost:8082/movies/list/" + str)//not using Eureka
                    .uri("http://movie-info-service/movies/list/" + str)//using Eureka. must add @LoadBalanced to WebClient.Builder bean
                    .retrieve()//get the data

                    //.filter(basicAuthentication("user", "password"))
                    .bodyToMono(MovieListObj.class)//its an async call
                    .timeout(Duration.ofSeconds(3))//adding timeout to manage threads in service
                    .block();//wait until data will be fulfilled an async call, WO it it was a sync call
        }
        catch (Exception e){
            System.err.println("Eureka is not working");
            System.err.println(e.getMessage());
            return clientMovies;
        }

        List<Movie> movieInfo = movieListObj.getMovies();

        clientMovies.forEach(clientMovie -> {
            Movie movie = movieInfo.stream().filter(movie1 -> movie1.getMovieId() == clientMovie.getMovieId()).findFirst().get();
            clientMovie.setDescription(movie.getDescription());
            clientMovie.setName(movie.getName());
        });
        clientMovies.forEach(System.out::println);
        return clientMovies;
    }

    public List<ClientMovie> getClientMoviesForClient(int id) {

        List<ClientMovie> clientMovies = new ArrayList<>();

        clientMovieRepository.findByClientId(id).forEach(clientMovies::add);

        //add movie data from movie info service one movie at a time

        clientMovies.forEach(clientMovie -> {
            Movie movieInfo = webClientBuilder.build()
                    .get()//use get method (post, update...)
//                    .uri("http://localhost:8082/movies/" + clientMovie.getMovieId())//not using Eureka
                    .uri("http://movie-info-service/movies/" + clientMovie.getMovieId())//using Eureka. must add @LoadBalanced to WebClient.Builder bean
                    .retrieve()//get the data
                    .bodyToMono(Movie.class)//its an async call
                    .block();//waite until data will be fulfiled an async call, WO it it was a sync call
            clientMovie.setDescription(movieInfo.getDescription());
            clientMovie.setName(movieInfo.getName());
        });


        return clientMovies;
    }
}
