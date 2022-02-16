package com.soundify.api.soundifyapi.controller;

import com.soundify.api.soundifyapi.model.Playlist;
import com.soundify.api.soundifyapi.model.Song;
import com.soundify.api.soundifyapi.model.User;
import com.soundify.api.soundifyapi.service.PlaylistService;
import com.soundify.api.soundifyapi.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/playlist")
public class PlaylistController {

    @Autowired
    private final PlaylistService playlistService;
    private final UserService userService;


    public PlaylistController(PlaylistService playlistService, UserService userService) {
        this.playlistService = playlistService;
        this.userService = userService;

    }

    @PostMapping("/createplaylist")
    public ResponseEntity addPlaylist(@RequestBody Playlist playlist){
        playlistService.addPlaylist(playlist);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    //add a song to a playlist
    @PutMapping("/update/{id}")
    public ResponseEntity<Playlist> updatePlaylist(@PathVariable String id, @RequestBody Song song){
       return ResponseEntity.ok(playlistService.updatePlaylist(id, song));
    }

    //Get all playlists that exists
    @GetMapping("/getall")
    public ResponseEntity<List<Playlist>> getAllPlaylist(){
       return ResponseEntity.ok(playlistService.getAllPlaylists());
    }

    //Unsure if this route has any worth to us.

/*    @GetMapping("/user/{id}")
    public ResponseEntity getUserPlaylist(@PathVariable String id){
        Optional<User> currentUser = userService.findUser(id);
       List<Playlist> currentUserPlaylist = currentUser.get().getPlaylists();

        return ResponseEntity.ok(currentUserPlaylist);
    }*/

    @GetMapping("/{id}")
    public ResponseEntity<Playlist> getPlaylistById(@PathVariable String id){
        return ResponseEntity.ok(playlistService.getPlaylistById(id));
    }

    @DeleteMapping("deleteplaylist/{id}")
    public ResponseEntity deletePlaylist(@PathVariable String id){
        playlistService.deletePlaylist(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
