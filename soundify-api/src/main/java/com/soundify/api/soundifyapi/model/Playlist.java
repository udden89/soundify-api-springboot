package com.soundify.api.soundifyapi.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;

@Document(collection = "playlists")
public class Playlist {

    @Id
    private String _id;
    private String playlist_name;
    private ArrayList<Song> songs;
    private Date createdAt;
    private Date modifiedAt;


    public Playlist() {
    }

    public Playlist(String playlistName, ArrayList<Song> songs, Date createdAt, Date modifiedAt) {
        this.playlist_name = playlistName;
        this.songs = songs;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    public String get_id() {
        return _id;
    }

    public String getPlaylistName() {
        return playlist_name;
    }

    public void setPlaylistName(String playlistName) {
        this.playlist_name = playlistName;
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }

    public void setSongs(ArrayList<Song> songs) {
        this.songs = songs;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(Date modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    @Override
    public String toString() {
        return "Playlist{" +
                "_id=" + _id +
                ", playlistName='" + playlist_name + '\'' +
                ", songs=" + songs +
                ", createdAt=" + createdAt +
                ", modifiedAt=" + modifiedAt +
                '}';
    }
}
