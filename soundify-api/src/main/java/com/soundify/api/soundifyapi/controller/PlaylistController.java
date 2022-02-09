package com.soundify.api.soundifyapi.controller;

import com.soundify.api.soundifyapi.model.Playlist;
import com.soundify.api.soundifyapi.service.PlaylistService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/playlist")
public class PlaylistController {

    private final PlaylistService playlistService;
    public PlaylistController(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }

    @PostMapping
    public ResponseEntity addPlaylist(@RequestBody Playlist playlist){
        playlistService.addPlaylist(playlist);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    public void updatePlaylist(){ }

    @GetMapping
    public ResponseEntity<List<Playlist>> getAllPlaylist(){
        System.out.println("From getmapping!");
       return ResponseEntity.ok(playlistService.getAllPlaylist());
    }

    public void getPlaylist(){ }

    public void deletePlaylist(){ }

}
