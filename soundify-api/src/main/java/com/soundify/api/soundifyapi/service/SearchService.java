package com.soundify.api.soundifyapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.soundify.api.soundifyapi.security.services.UserDetailsImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Component;
import org.springframework.web.util.WebUtils;
import io.jsonwebtoken.*;

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
        System.out.println(path);
        path = path + query + next ;

        String responseJson = webClientBuilder.build()
                .get()
                .uri(path)
                .retrieve()
                .bodyToMono(String.class)
                .block();
        return responseJson;
    }


}
