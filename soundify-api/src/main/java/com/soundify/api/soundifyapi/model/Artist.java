package com.soundify.api.soundifyapi.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Reference;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Document
@Data
public class Artist {

    @Id
    private String _id;
    private String artistName;
    @Reference
    private ArrayList<Album> albums;
    @Reference
    private ArrayList<Song> songs;

    public Artist() {
    }

    public Artist(String artistName, ArrayList<Album> albums, ArrayList<Song> songs) {
        this.artistName = artistName;
        this.albums = albums;
        this.songs = songs;
    }
}
