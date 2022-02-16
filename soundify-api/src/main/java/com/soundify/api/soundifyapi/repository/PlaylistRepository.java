package com.soundify.api.soundifyapi.repository;

import com.soundify.api.soundifyapi.model.Playlist;
import com.soundify.api.soundifyapi.model.Song;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PlaylistRepository extends MongoRepository<Playlist, String> {


}
