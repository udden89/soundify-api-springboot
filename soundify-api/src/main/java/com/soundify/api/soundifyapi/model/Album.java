package com.soundify.api.soundifyapi.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Reference;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.*;

@Document
@Data
public class Album {

    @Id
    private String _id;
    private String name;
    private Artist artist;
    @Reference
    private ArrayList<Song> songs;

    public Album() {
    }

    public Album(Artist artist, ArrayList<Song> songs, String name) {
        this.artist = artist;
        this.songs = songs;
        this.name = name;
    }

}
