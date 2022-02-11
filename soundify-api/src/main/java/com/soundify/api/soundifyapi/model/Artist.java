package com.soundify.api.soundifyapi.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Document
@Data
public class Artist {

    @DBRef
    private String artistName;
    private ArrayList<Album> albums;
    private ArrayList<Song> songs;

    public Artist() {
    }

    public Artist(String artistName, ArrayList<Album> albums, ArrayList<Song> songs) {
        this.artistName = artistName;
        this.albums = albums;
        this.songs = songs;
    }
}
