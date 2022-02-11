package com.soundify.api.soundifyapi.service;

import com.soundify.api.soundifyapi.model.Playlist;
import com.soundify.api.soundifyapi.model.User;
import com.soundify.api.soundifyapi.repository.PlaylistRepository;
import com.soundify.api.soundifyapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public void addPlaylist(Playlist playlist){
        playlistRepository.insert(playlist);
    }

    public void updatePlaylist( Playlist playlist){
        Playlist savedPlaylist = playlistRepository.findById(playlist.get_id()).orElseThrow(() -> new RuntimeException(
                String.format("Cannot find playlist by ID %s" , playlist.get_id())));
        savedPlaylist.setSongs(playlist.getSongs());
        playlistRepository.save(playlist);

    }

    public List<Playlist> getAllPlaylists(){
        return playlistRepository.findAll();
    }

    public void getPlaylist(){ }

    public void deletePlaylist(){ }
}
