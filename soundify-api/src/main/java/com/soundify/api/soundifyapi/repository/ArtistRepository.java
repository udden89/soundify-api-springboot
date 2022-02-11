package com.soundify.api.soundifyapi.repository;

import com.soundify.api.soundifyapi.model.Artist;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistRepository extends MongoRepository<Artist, String> {

}




