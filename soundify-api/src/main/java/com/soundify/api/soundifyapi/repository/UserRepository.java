package com.soundify.api.soundifyapi.repository;

import com.soundify.api.soundifyapi.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String>{

}
