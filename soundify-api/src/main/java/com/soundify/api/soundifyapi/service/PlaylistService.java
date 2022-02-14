package com.soundify.api.soundifyapi.service;

import com.soundify.api.soundifyapi.model.Playlist;
import com.soundify.api.soundifyapi.repository.PlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaylistService {

    @Autowired
    private final PlaylistRepository playlistRepository;

    public PlaylistService(PlaylistRepository playlistRepository) {
        this.playlistRepository= playlistRepository;
    }

    public Playlist addPlaylist(Playlist playlist){

        return playlistRepository.insert(playlist);
    }

    public void updatePlaylist(){ }

    public List<Playlist> getAllPlaylists(){
        return playlistRepository.findAll();
    }

    public void getPlaylist(){ }

    public void deletePlaylist(){ }
}
