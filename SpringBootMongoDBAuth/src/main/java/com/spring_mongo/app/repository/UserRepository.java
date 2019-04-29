package com.spring_mongo.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.spring_mongo.app.document.Users;

public interface UserRepository extends MongoRepository<Users, Integer> {
}
