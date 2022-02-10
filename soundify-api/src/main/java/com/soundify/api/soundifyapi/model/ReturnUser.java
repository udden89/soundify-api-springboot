package com.soundify.api.soundifyapi.model;

import java.util.ArrayList;

public class ReturnUser {

    private String userName;
    private ArrayList<Playlist> playlists;
    private String email;

    public ReturnUser() {
    }

    public ReturnUser(String userName, ArrayList<Playlist> playlists, String email) {
        this.userName = userName;
        this.playlists = playlists;
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public ArrayList<Playlist> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(ArrayList<Playlist> playlists) {
        this.playlists = playlists;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "ReturnUser{" +
                "userName='" + userName + '\'' +
                ", playlists=" + playlists +
                ", email='" + email + '\'' +
                '}';
    }
}
