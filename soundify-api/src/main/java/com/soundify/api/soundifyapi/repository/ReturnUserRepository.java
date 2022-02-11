package com.soundify.api.soundifyapi.repository;

import com.soundify.api.soundifyapi.model.ReturnUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReturnUserRepository extends MongoRepository<ReturnUser, String> {
}
