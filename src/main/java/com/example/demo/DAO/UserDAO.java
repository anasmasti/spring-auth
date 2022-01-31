package com.example.demo.DAO;

import com.example.demo.model.AppUser;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends MongoRepository<AppUser, String> {
    
}
