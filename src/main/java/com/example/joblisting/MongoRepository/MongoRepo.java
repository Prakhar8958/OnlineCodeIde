package com.example.joblisting.MongoRepository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.joblisting.MongoEntity.mongoEntity;
@Repository
public interface MongoRepo extends MongoRepository<mongoEntity,String>
{

}
