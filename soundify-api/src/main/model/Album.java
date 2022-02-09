package model;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import model.Song;
import java.lang.annotation.Documented;
import java.util.*;

@Document
public class Album {

    @DBRef
    private Artist artist;
    private ArrayList<Song> songs = new ArrayList<Song>();

    public Album() {
    }

    public Album(Artist artist, ArrayList<Song> songs) {
        this.artist = artist;
        this.songs = songs;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }

    public void setSongs(ArrayList<Song> songs) {
        this.songs = songs;
    }

    @Override
    public String toString() {
        return "Album{" +
                "artist=" + artist +
                ", songs=" + songs +
                '}';
    }
}
