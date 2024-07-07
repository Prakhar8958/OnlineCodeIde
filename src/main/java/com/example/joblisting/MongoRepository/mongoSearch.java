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
public class mongoSearch implements MongoSearchRepo {

	@Autowired
	MongoClient client;

	@Autowired
	MongoConverter converter;

	@Override
	public List<mongoEntity> searchByText(String text) {

		final List<mongoEntity> posts = new ArrayList<>();

		MongoDatabase database = client.getDatabase("demo"); // Ensure this matches your database name
		MongoCollection<Document> collection = database.getCollection("demohelper");

		AggregateIterable<Document> result = collection.aggregate(Arrays.asList(
				new Document("$match", new Document("$or",
						Arrays.asList(new Document("desc", new Document("$regex", text).append("$options", "i")),
								new Document("profile", new Document("$regex", text).append("$options", "i")),
								new Document("skills", new Document("$regex", text).append("$options", "i"))))),
				new Document("$sort", new Document("experience", -1L)), new Document("$limit", 6L)));

		result.forEach(doc -> posts.add(converter.read(mongoEntity.class, doc)));

		return posts;
	}

}
