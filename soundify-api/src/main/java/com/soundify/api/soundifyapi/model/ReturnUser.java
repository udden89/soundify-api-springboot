package com.soundify.api.soundifyapi.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.ArrayList;

@Data
public class ReturnUser {

    @DBRef
    private String userName;
    private ArrayList<Playlist> playlists;
    private String email;

    public ReturnUser() {
    }

    public ReturnUser(String userName, ArrayList<Playlist> playlists, String email) {
        this.userName = userName;
        this.playlists = playlists;
        this.email = email;
    }
}
