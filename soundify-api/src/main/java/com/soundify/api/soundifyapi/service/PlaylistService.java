package com.soundify.api.soundifyapi.service;

import com.soundify.api.soundifyapi.model.Playlist;
import com.soundify.api.soundifyapi.model.Song;
import com.soundify.api.soundifyapi.model.User;
import com.soundify.api.soundifyapi.repository.PlaylistRepository;
import com.soundify.api.soundifyapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class PlaylistService {

    @Autowired
    private final PlaylistRepository playlistRepository;
    private final UserService userService;

    public PlaylistService(PlaylistRepository playlistRepository , UserService userService) {
        this.playlistRepository= playlistRepository;
        this.userService = userService;
    }

    //create playlist
    public void addPlaylist(Playlist playlist){
        playlistRepository.insert(playlist);
    }

    //update playlist (add a song)
    public Playlist updatePlaylist(String id, Song song){
        var playlist = playlistRepository.findById(id).get();
        System.out.println(playlist);
        var songList = playlist.getSongs();
        songList.add(song);
        System.out.println("------------");
        System.out.println(songList);
        System.out.println("11111111");
        System.out.println(playlist);
        return playlistRepository.save(playlist);
    }

    //get all playlists that exists in the collection
    public List<Playlist> getAllPlaylists(){
        return playlistRepository.findAll();
    }

    //Get a specific playlist by ID
    public Playlist getPlaylistById(String id){
        return playlistRepository.findById(id).orElseThrow(() -> new RuntimeException(
                String.format("Cannot find playlist by name %s", id)
        ));
    }
    //Delete a playlist by ID
    public void deletePlaylist(String id){
         playlistRepository.deleteById(id);
    }
}
