package com.soundify.api.soundifyapi.repository;

import com.soundify.api.soundifyapi.model.Album;
import com.soundify.api.soundifyapi.model.Artist;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ArtistRepository extends MongoRepository<Artist, String> {

    @Override
    <S extends Artist> S save(S entity);

    @Override
    Optional<Artist> findById(String s);

    long count();

    @Override
    void delete(Artist entity);

    @Override
    boolean existsById(String s);
}




