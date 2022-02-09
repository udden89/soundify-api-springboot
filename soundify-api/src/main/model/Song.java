package model;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Document
public class Song {

    @DBRef
    private String name;
    private ArrayList<Artist> artists = new ArrayList<Artist>();
    private ArrayList<String> thumbnails;
    private Album album;
    private Integer duration;
    private String params;
    private String type;

    public Song() {
    }

    public Song(String name, ArrayList<Artist> artists, ArrayList<String> thumbnails, Album album, Integer duration, String params, String type) {
        this.name = name;
        this.artists = artists;
        this.thumbnails = thumbnails;
        this.album = album;
        this.duration = duration;
        this.params = params;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Artist> getArtists() {
        return artists;
    }

    public void setArtists(ArrayList<Artist> artists) {
        this.artists = artists;
    }

    public ArrayList<String> getThumbnails() {
        return thumbnails;
    }

    public void setThumbnails(ArrayList<String> thumbnails) {
        this.thumbnails = thumbnails;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Song{" +
                "name='" + name + '\'' +
                ", artists=" + artists +
                ", thumbnails=" + thumbnails +
                ", album=" + album +
                ", duration=" + duration +
                ", params='" + params + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
