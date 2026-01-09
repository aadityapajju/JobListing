package com.Hirist.JobListing.Controller;


import com.Hirist.JobListing.Repository.JobRepo;
import com.Hirist.JobListing.Models.JobPost;
import com.Hirist.JobListing.Repository.SearchRepo;
import io.swagger.v3.oas.annotations.Hidden;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@Component
public class JobPostController {

    @Autowired
    private JobRepo jobRepo;

    @Autowired
    private SearchRepo searchRepo;


    @Hidden
    @RequestMapping(value = "/")
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }

    @GetMapping("/jobPosts")
    public List<JobPost> getAllJobs(){
        return jobRepo.findAll();
    }

    @GetMapping("/posts/{text}")
    public List<JobPost> search(@PathVariable String text){
        return searchRepo.searchByText(text);
    }

    @PostMapping("/posts")
    public JobPost postJob(@RequestBody JobPost jobPost){
        return jobRepo.save(jobPost);
    }
}