package com.soundify.api.soundifyapi.repository;

import com.soundify.api.soundifyapi.model.Song;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface SongRepository extends MongoRepository<Song, String> {

    @Override
    <S extends Song> S save(S entity);

    @Override
    Optional<Song> findById(String s);

    long count();

    @Override
    void delete(Song entity);

    @Override
    boolean existsById(String s);
}
