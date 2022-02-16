package com.soundify.api.soundifyapi.service;

import com.soundify.api.soundifyapi.model.Album;
import com.soundify.api.soundifyapi.model.Artist;
import com.soundify.api.soundifyapi.model.Playlist;
import com.soundify.api.soundifyapi.model.Song;
import com.soundify.api.soundifyapi.repository.AlbumRepository;
import com.soundify.api.soundifyapi.repository.ArtistRepository;
import com.soundify.api.soundifyapi.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MusicService {

    @Autowired
    private final SongRepository songRepository;
    private final AlbumRepository albumRepository;
    private final ArtistRepository artistRepository;


    public MusicService(SongRepository songRepository, AlbumRepository albumRepository, ArtistRepository artistRepository) {
        this.songRepository = songRepository;
        this.albumRepository = albumRepository;
        this.artistRepository = artistRepository;
    }

    public void saveSong(Song song){
        songRepository.save(song);
    }

    public void deleteSong(Song song){
        songRepository.delete(song);
    }

    public void saveAlbum(Album album){
        albumRepository.save(album);
    }

    public void saveArtist(Artist artist) { artistRepository.save(artist); }

    public void getSong(String id) { songRepository.findById(id); }

    public void getArtist(String id) { artistRepository.findById(id); }

    public void getAlbum(String id) { albumRepository.findById(id); }

}
