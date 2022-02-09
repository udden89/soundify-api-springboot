package com.soundify.api.soundifyapi.repository;

import com.soundify.api.soundifyapi.model.Song;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SongRepository extends MongoRepository<Song, String> {
}
