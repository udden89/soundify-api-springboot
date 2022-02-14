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




    @PostMapping("/add")
    public ResponseEntity addPlaylist(@RequestBody Playlist playlist, Authentication authentication){
        Optional<User> user = userRepository.findByUsername(authentication.getName());
        var newPlaylist = playlistService.addPlaylist(playlist);
        user.get().addPlaylist(newPlaylist);
        User user1 = userRepository.save(user.get());
        UserDTO userDTO = new UserDTO(user1.get_id(), user1.getUsername(), user1.getPlaylists());
        return ResponseEntity.status(HttpStatus.CREATED).body(userDTO);
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
