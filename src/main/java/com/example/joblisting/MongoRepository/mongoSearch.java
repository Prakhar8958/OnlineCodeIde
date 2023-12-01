package com.example.joblisting.MongoRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;

import com.example.joblisting.MongoEntity.mongoEntity;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@Component
public class mongoSearch implements MongoSearchRepo{

	@Autowired
	MongoClient client;
	
	@Autowired
	MongoConverter converter;
	
	@Override
	public List<mongoEntity> searchByText(String text) 
	{
	final List<mongoEntity> posts=new ArrayList<>();
		
	/*	
	MongoClient mongoClient = new MongoClient(
		    new MongoClientURI(
		        "mongodb://localhost:27017/"
		    )
		);
	*/
		MongoDatabase database = client.getDatabase("employee");
		MongoCollection<Document> collection = database.getCollection("emp");
		AggregateIterable<Document> result = collection.aggregate(Arrays.asList(
				/* this search option only allows in atlas
				new Document("$search",
				new Document("text",
				new Document("query",text)
				.append("path", Arrays.asList("desc","profile","skills")))),
				*/
				new Document("$sort", 
		        new Document("exp", 1L)), 
		        new Document("$limit", 5L)));
		
		result.forEach(doc->posts.add(converter.read(mongoEntity.class, doc)));
		
		return posts;
	}

}
