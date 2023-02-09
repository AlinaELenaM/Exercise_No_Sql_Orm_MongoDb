package com.develhope.nosqlormmongodb.repositories;

import com.develhope.nosqlormmongodb.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
