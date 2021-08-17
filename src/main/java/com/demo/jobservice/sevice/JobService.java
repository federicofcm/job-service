package com.demo.jobservice.sevice;

import com.demo.jobservice.controller.queryparameter.JobQueryParameters;
import com.demo.jobservice.dao.external.JobRepository;
import com.demo.jobservice.model.Job;
import com.demo.jobservice.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;
import java.util.List;

@Service
public class JobService {

    private final SearchService searchService;

    private final JobRepository jobRepository;

    @Autowired
    public JobService(SearchService searchService, JobRepository jobRepository) {
        this.searchService = searchService;
        this.jobRepository = jobRepository;
    }

    public List<Job> findJobByQPs(JobQueryParameters queryParameters) {
        List<User> users = jobRepository.find();
        List<Job> jobs = jobRepository.findByQPs(queryParameters);
        return jobs;
    }
}
