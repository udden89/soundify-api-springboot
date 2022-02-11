package com.soundify.api.soundifyapi.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;

@Document
@Data
public class Song {

    @DBRef
    private String name;
    private ArrayList<Artist> artist;
    private ArrayList<String> thumbnails;
    private Album album;
    private Integer duration;
    private String params;
    private String type;

    public Song() {
    }

    public Song(String name, ArrayList<Artist> artists, ArrayList<String> thumbnails, Album album, Integer duration, String params, String type) {
        this.name = name;
        this.artist = artists;
        this.thumbnails = thumbnails;
        this.album = album;
        this.duration = duration;
        this.params = params;
        this.type = type;
    }
}