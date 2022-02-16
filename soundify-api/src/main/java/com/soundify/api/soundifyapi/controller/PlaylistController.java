package com.soundify.api.soundifyapi.controller;

import com.soundify.api.soundifyapi.dto.UserDTO;
import com.soundify.api.soundifyapi.model.Playlist;
import com.soundify.api.soundifyapi.model.User;
import com.soundify.api.soundifyapi.repository.UserRepository;
import com.soundify.api.soundifyapi.service.PlaylistService;
import com.soundify.api.soundifyapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/playlist")
public class PlaylistController {

    @Autowired
    PlaylistService playlistService;
    @Autowired
    UserRepository userRepository;


    @PostMapping("/createplaylist")
    public ResponseEntity addPlaylist(@RequestBody Playlist playlist, Authentication authentication ){
        return ResponseEntity.ok(playlistService.addPlaylist(playlist, authentication));
    }

    public void updatePlaylist(){ }

    @GetMapping("/getall")
    public ResponseEntity<List<Playlist>> getAllPlaylist(){
       return ResponseEntity.ok(playlistService.getAllPlaylists());
    }



    public void getPlaylist(){ }

    @PostMapping("/deleteplaylist/:id")
    public void deletePlaylist(){

    }

}
