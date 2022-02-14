package com.soundify.api.soundifyapi.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Reference;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;

@Document
@Data
public class Song {

    @Id
    private String _id;
    private String name;
    @Reference
    private Artist artist;
    private ArrayList<Thumbnail> thumbnails;
    @Reference
    private Album album;
    private Integer duration;
    private String params;
    private String type;

    public Song() {
    }

    public Song(String name, Artist artists, ArrayList<Thumbnail> thumbnails, Album album, Integer duration, String params, String type) {
        this.name = name;
        this.artist = artists;
        this.thumbnails = thumbnails;
        this.album = album;
        this.duration = duration;
        this.params = params;
        this.type = type;
    }


}