package com.soundify.api.soundifyapi.repository;

import com.soundify.api.soundifyapi.model.Album;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AlbumRepository extends MongoRepository<Album, String> {
}
