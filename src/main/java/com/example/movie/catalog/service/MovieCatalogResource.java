package com.example.movie.catalog.service;

import com.example.movie.catalog.service.CatalogItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private WebClient.Builder webClientBuilder;

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){

        //get all rated movies id
//        restTemplate.getForObject()

//        webClientBuilder.build()
//                .get()
//                .uri()
//                .retrieve()
//                .bodyToMono(class)
//                .block();
        //for each movie id call info service and get data

        //put them all together
        return Collections.singletonList(
                new CatalogItem("Transformers", "Transformers desc", 4)
        );
    }

}
