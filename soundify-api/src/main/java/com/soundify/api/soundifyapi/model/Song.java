package com.soundify.api.soundifyapi.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Reference;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.ArrayList;

@Data
public class Song {


    private String name;
  //private ArrayList<Thumbnail> thumbnails;
    private Integer duration;
    private String videoId;

    public Song() {
    }

    public Song(String name,Integer duration,String videoId) {
        this.name = name;

        //this.thumbnails = thumbnails;
        this.videoId = videoId;
        this.duration = duration;

    }


}