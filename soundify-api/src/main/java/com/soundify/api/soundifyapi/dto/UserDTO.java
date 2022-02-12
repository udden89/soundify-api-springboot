package com.soundify.api.soundifyapi.dto;

import lombok.Data;

import java.util.ArrayList;

@Data
public class UserDTO {

    private String id;
    private String user_name;
    private ArrayList<String> playlists;

    public UserDTO() {
    }

    public UserDTO(String id, String username, ArrayList<String> playlists) {
        this.id = id;
        this.user_name = username;
        this.playlists = playlists;
    }

}
