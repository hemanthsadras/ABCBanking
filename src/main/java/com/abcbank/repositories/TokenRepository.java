package com.abcbank.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.abcbank.models.Token;

public interface TokenRepository extends MongoRepository<Token,String> {

}
