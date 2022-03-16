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
import java.util.stream.Collectors;

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
        return new UserDTO(user1.get_id(), user1.getUsername(), user1.getPlaylists());
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

    public void deleteSongFromPlaylist(String playlistId, String songId){
        var selectedPlaylist = playlistRepository.findById(playlistId).get();

        var songList = selectedPlaylist.getSongs()
                .stream()
                .filter(song -> !song.getVideoId()
                        .equals(songId))
                .collect(Collectors.toList());

        selectedPlaylist.setSongs(songList);
        playlistRepository.save(selectedPlaylist);

    }
}
