package com.soundify.api.soundifyapi.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Token {

    @Id
    private String _id;
    private String token;

    public Token(String token) {

        this.token = token;
    }
}
