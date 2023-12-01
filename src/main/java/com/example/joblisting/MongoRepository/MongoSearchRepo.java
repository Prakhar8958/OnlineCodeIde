package com.example.joblisting.MongoRepository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.joblisting.MongoEntity.mongoEntity;
@Repository
public interface MongoSearchRepo 
{
  List<mongoEntity> searchByText(String text);
}
