package com.Hirist.JobListing.Repository;

import com.Hirist.JobListing.Models.JobPost;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JobRepo extends MongoRepository<JobPost, Long> {
}
