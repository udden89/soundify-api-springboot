package com.soundify.api.soundifyapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class SearchService {

    @Autowired
    private WebClient.Builder webClientBuilder;

    public String fetch(String mediaType, String query, String next) {
        return getFromHeroku(mediaType, query, next);
    }

    public String getFromHeroku(String mediaType, String query, String next) {
        String path = "https://yt-music-api.herokuapp.com/api/yt/" + mediaType + "/";
        path = path + query + next  ;

        String responseJson = webClientBuilder.build()
                .get()
                .uri(path)
                .retrieve()
                .bodyToMono(String.class)
                .block();

        return responseJson;
    }


}
