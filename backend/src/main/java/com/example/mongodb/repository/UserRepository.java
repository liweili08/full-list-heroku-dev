package com.example.mongodb.repository;

import com.example.mongodb.model.UserMongo;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<UserMongo, String> {

    Optional<UserMongo> findByUsername(String username);
}
