package com.soundify.api.soundifyapi.model;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.ArrayList;
import java.util.Date;

@Document(collection = "users")
public class User {

    @Id
    private String _id;
    private String user_name;
    private String email;
    private String password;
    private ArrayList<Token> tokens;
    private ArrayList<String> playlists;
    @CreatedDate
    private Date createdAt;
    @LastModifiedDate
    private Date modifiedAt;

    public User(String user_name, String email, String password) {
        this.user_name = user_name;
        this.email = email;
        this.password = password;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getModifiedAt() { return modifiedAt; }

    public String get_id() {
        return _id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Token> getTokens() {
        return tokens;
    }

    public void setTokens(ArrayList<Token> tokens) {
        this.tokens = tokens;
    }

    public ArrayList<String> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(ArrayList<String> playlists) {
        this.playlists = playlists;
    }

    @Override
    public String toString() {
        return "User{" +
                "_id='" + _id + '\'' +
                ", user_name='" + user_name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", tokens=" + tokens +
                ", playlists=" + playlists +
                '}';
    }
}

