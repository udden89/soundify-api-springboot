package com.soundify.api.soundifyapi.controller;

import com.soundify.api.soundifyapi.model.Playlist;
import com.soundify.api.soundifyapi.service.PlaylistService;
import com.soundify.api.soundifyapi.service.UserService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/playlist")
public class PlaylistController {

    @Autowired
    private final PlaylistService playlistService;


    public PlaylistController(PlaylistService playlistService) {
        this.playlistService = playlistService;

    }

    @PostMapping("/add")
    public ResponseEntity addPlaylist(@RequestBody Playlist playlist){
        playlistService.addPlaylist(playlist);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/update")
    public ResponseEntity updatePlaylist(@RequestBody Playlist playlist){
    playlistService.updatePlaylist(playlist);
    return ResponseEntity.ok().build();
    }

    @GetMapping("/getall")
    public ResponseEntity<List<Playlist>> getAllPlaylist(){
       return ResponseEntity.ok(playlistService.getAllPlaylists());
    }

    public void getPlaylist(){ }

    public void deletePlaylist(){ }

}
