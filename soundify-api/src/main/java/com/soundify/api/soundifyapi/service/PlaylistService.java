package com.soundify.api.soundifyapi.service;

import com.soundify.api.soundifyapi.dto.UserDTO;
import com.soundify.api.soundifyapi.model.Playlist;
import com.soundify.api.soundifyapi.model.Song;
import com.soundify.api.soundifyapi.model.User;
import com.soundify.api.soundifyapi.repository.PlaylistRepository;
import com.soundify.api.soundifyapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    private final UserService userService;

    public PlaylistService(PlaylistRepository playlistRepository , UserService userService) {
        this.playlistRepository= playlistRepository;
        this.userService = userService;
    }

    public UserDTO addPlaylist(Playlist playlist, Authentication authentication){
        Optional<User> user = userRepository.findByUsername(authentication.getName());
        var newPlaylist = playlistRepository.insert(playlist);
        user.get().addPlaylist(newPlaylist);
        User user1 = userRepository.save(user.get());
        UserDTO userDTO = new UserDTO(user1.get_id(), user1.getUsername(), user1.getPlaylists());
        return userDTO;
    }

    //update playlist (add a song)
    public Playlist updatePlaylist(String id, Song song){
        Playlist savedPlaylist = null;
        Optional <Playlist>  chosenPlaylist = playlistRepository.findById(id);

        if( chosenPlaylist.isPresent()){
            chosenPlaylist.get().addSong(song);
            savedPlaylist =  playlistRepository.save(chosenPlaylist.get());
        }
        return savedPlaylist;
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
