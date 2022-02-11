package com.soundify.api.soundifyapi.repository;

import com.soundify.api.soundifyapi.model.Playlist;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface PlaylistRepository extends MongoRepository<Playlist, String> {

}
