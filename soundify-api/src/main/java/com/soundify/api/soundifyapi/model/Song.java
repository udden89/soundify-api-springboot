package com.soundify.api.soundifyapi.model;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Song {

    private String name;
    private ArrayList<Thumbnail> thumbnails = new ArrayList<>();
    private Integer duration;
    private String videoId;

    public Song() {
    }

    public Song(String name, ArrayList<Thumbnail> thumbnails, Integer duration,String videoId) {
        this.name = name;
        this.thumbnails = thumbnails;
        this.videoId = videoId;
        this.duration = duration;

    }


}