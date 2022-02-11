package com.soundify.api.soundifyapi.model;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.ArrayList;
import java.util.Date;

@Document(collection = "users")
@Data
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
}

