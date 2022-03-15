package com.soundify.api.soundifyapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;


@Service
public class SearchService {

    @Autowired
    private WebClient.Builder webClientBuilder;

    @Value("${spring.data.heroku}")
    String heroku;

    public String fetch(String mediaType, String query, String next) {
        return getFromHeroku(mediaType, query, next);
    }

    public String getFromHeroku(String mediaType, String query, String next) {

        String path = heroku + mediaType + "/";
        path = path + query + next ;

        return webClientBuilder.build()
                .get()
                .uri(path)
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }


}
