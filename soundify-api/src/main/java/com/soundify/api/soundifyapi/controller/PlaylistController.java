package com.soundify.api.soundifyapi.controller;

import com.soundify.api.soundifyapi.dto.DeleteIdDTO;
import com.soundify.api.soundifyapi.dto.DeleteSongFromListDTO;
import com.soundify.api.soundifyapi.model.Playlist;
import com.soundify.api.soundifyapi.model.Song;
import com.soundify.api.soundifyapi.service.PlaylistService;
import com.soundify.api.soundifyapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
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

    //create a playlist
    @PostMapping("/createplaylist")
    public ResponseEntity addPlaylist(@RequestBody Playlist playlist, Authentication authentication ){
        return ResponseEntity.ok(playlistService.addPlaylist(playlist, authentication));
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

    //Get playlist with playlistID
    @GetMapping("/{id}")
    public ResponseEntity<Playlist> getPlaylistById(@PathVariable String id){
        return ResponseEntity.ok(playlistService.getPlaylistById(id));
    }

    @DeleteMapping("deleteplaylist/{id}")
    @ResponseBody
    public ResponseEntity<DeleteIdDTO> deletePlaylist(@PathVariable String id) {
        try {
            playlistService.deletePlaylist(id);
            return ResponseEntity.ok(new DeleteIdDTO(id));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{playlistId}/{songId}")
    public ResponseEntity<DeleteSongFromListDTO> deleteSongFromPlaylist(@PathVariable String playlistId,
                                                    @PathVariable String songId) {
        try {
            playlistService.deleteSongFromPlaylist(playlistId ,songId);
            return ResponseEntity.ok(new DeleteSongFromListDTO(songId));
        } catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
