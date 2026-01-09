package com.Hirist.JobListing.Repository;

import com.Hirist.JobListing.Models.JobPost;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SearchRepo {

    List<JobPost> searchByText(String text);
}
