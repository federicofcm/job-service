package com.demo.jobservice.controller;

import com.demo.jobservice.controller.queryparameter.JobQueryParameters;
import com.demo.jobservice.dto.JobDto;
import com.demo.jobservice.mapper.JobMapper;
import com.demo.jobservice.sevice.JobService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@Slf4j
public class JobController {

    private final JobService jobService;

    private final JobMapper jobMapper;

    @Autowired
    public JobController(JobService jobService, JobMapper jobMapper) {
        this.jobService = jobService;
        this.jobMapper = jobMapper;
    }

    @GetMapping("/jobs")
    public ResponseEntity<List<JobDto>> getJobs(@Valid JobQueryParameters queryParameters) {
        log.info("GET: /jobs");

        List<JobDto> jobList = jobMapper.entityToDtoList(jobService.findJobByQPs(queryParameters));

        return ResponseEntity.ok(jobList);
    }
}
