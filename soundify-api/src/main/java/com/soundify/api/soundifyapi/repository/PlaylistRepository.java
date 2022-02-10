package com.soundify.api.soundifyapi.repository;

import com.soundify.api.soundifyapi.model.Playlist;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PlaylistRepository extends MongoRepository<Playlist, String> {
}
