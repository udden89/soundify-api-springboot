package com.soundify.api.soundifyapi.repository;

import com.soundify.api.soundifyapi.model.Song;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SongRepository extends MongoRepository<Song, String> {
}
