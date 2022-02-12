package com.soundify.api.soundifyapi.repository;

import com.soundify.api.soundifyapi.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String>{
    Optional<User> findByUsername(String name);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
}
