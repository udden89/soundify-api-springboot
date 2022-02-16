package com.soundify.api.soundifyapi.service;

import com.soundify.api.soundifyapi.dto.UserDTO;
import com.soundify.api.soundifyapi.model.Playlist;
import com.soundify.api.soundifyapi.model.User;
import com.soundify.api.soundifyapi.repository.PlaylistRepository;
import com.soundify.api.soundifyapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PlaylistService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    private final PlaylistRepository playlistRepository;

    public PlaylistService(PlaylistRepository playlistRepository) {
        this.playlistRepository= playlistRepository;
    }

    public UserDTO addPlaylist(Playlist playlist, Authentication authentication){
        Optional<User> user = userRepository.findByUsername(authentication.getName());
        var newPlaylist = playlistRepository.insert(playlist);
        user.get().addPlaylist(newPlaylist);
        User user1 = userRepository.save(user.get());
        UserDTO userDTO = new UserDTO(user1.get_id(), user1.getUsername(), user1.getPlaylists());
        return userDTO;
    }

    public void updatePlaylist(){ }

    public List<Playlist> getAllPlaylists(){
        return playlistRepository.findAll();
    }

    public void getPlaylist(){ }

    public void deletePlaylist(){ }
}
