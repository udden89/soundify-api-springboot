package com.soundify.api.soundifyapi.dto;

import com.soundify.api.soundifyapi.model.Playlist;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class UserDTO {

    private String id;
    private String user_name;
    private List<Playlist> playlists;

    public UserDTO() {
    }

    public UserDTO(String id, String username, List<Playlist> playlists) {
        this.id = id;
        this.user_name = username;
        this.playlists = playlists;
    }

}
