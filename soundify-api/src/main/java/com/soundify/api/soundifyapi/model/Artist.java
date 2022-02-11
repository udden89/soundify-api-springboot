package com.soundify.api.soundifyapi.model;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Document
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

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public ArrayList<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(ArrayList<Album> albums) {
        this.albums = albums;
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }

    public void setSongs(ArrayList<Song> songs) {
        this.songs = songs;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "artistName='" + artistName + '\'' +
                ", albums=" + albums +
                ", songs=" + songs +
                '}';
    }
}
