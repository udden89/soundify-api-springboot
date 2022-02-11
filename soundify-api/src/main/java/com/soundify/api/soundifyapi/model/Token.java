package com.soundify.api.soundifyapi.model;

import org.springframework.data.annotation.Id;

public class Token {

    @Id
    private String _id;
    private String token;

    public Token(String token) {

        this.token = token;
    }

    public String get_id() {
        return _id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
