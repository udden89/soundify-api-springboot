package com.soundify.api.soundifyapi.model;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Song {

    private String name;
    private ArrayList<Thumbnail> thumbnails = new ArrayList<>();
    private Integer duration;
    private String videoId;
    private Object artist;

    public Song() {
    }

    public Song(String name, Object artist, ArrayList<Thumbnail> thumbnails, Integer duration,String videoId) {
        this.name = name;
        this.thumbnails = thumbnails;
        this.videoId = videoId;
        this.duration = duration;
        this.artist = artist;

    }
}