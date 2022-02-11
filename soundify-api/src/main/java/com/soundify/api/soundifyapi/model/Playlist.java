package com.soundify.api.soundifyapi.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;
import java.util.Date;

@Document(collection = "playlists")
@Data
public class Playlist {

    @Id
    private String _id;
    @Field(name="playlist_name")
    private String playlistName;
    private ArrayList<Song> songs;
    @CreatedDate
    private Date createdAt;
    @LastModifiedDate
    private Date modifiedAt;


    public Playlist() {
    }

    public Playlist(String playlistName, ArrayList<Song> songs) {
        this.playlistName = playlistName;
        this.songs = songs;

    }
}
