package com.soundify.api.soundifyapi.repository;

import com.soundify.api.soundifyapi.model.Album;
import com.soundify.api.soundifyapi.model.Song;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AlbumRepository extends MongoRepository<Album, String> {

    @Override
    <S extends Album> S save(S entity);

    @Override
    Optional<Album> findById(String s);

    long count();

    @Override
    void delete(Album entity);

    @Override
    boolean existsById(String s);
}
