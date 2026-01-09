package com.Hirist.JobListing.Repository;

import com.Hirist.JobListing.Models.JobPost;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class SerachRepoImpl implements SearchRepo{

    @Autowired
    MongoClient mongoClient;

    @Autowired
    MongoConverter mongoConverter;


    @Override
    public List<JobPost> searchByText(String text) {

        final List<JobPost> jobPosts = new ArrayList<>();

        MongoDatabase database = mongoClient.getDatabase("Hirist");
        MongoCollection<Document> collection = database.getCollection("JobPost");

        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search",
                        new Document("text",
                        new Document("query", text)
                                        .append("path", Arrays.asList("techs", "desc", "profile"))
                                        .append("matchCriteria", "any"))),
                        new Document("$sort",
                        new Document("exp", -1L)),
                        new Document("$limit", 3L)));

        result.forEach(document -> jobPosts.add(mongoConverter.read(JobPost.class, document)));

        return jobPosts;
    }
}
