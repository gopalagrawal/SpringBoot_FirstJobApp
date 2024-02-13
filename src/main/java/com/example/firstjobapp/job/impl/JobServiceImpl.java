package com.example.firstjobapp.job.impl;
import com.example.firstjobapp.job.Job;
import com.example.firstjobapp.job.JobService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

// Use @Service annotation to identify this as a service implementation
@Service
public class JobServiceImpl implements JobService {

    private List<Job> jobs = new ArrayList<Job>();  // Simulate a DB of Jobs
    private Long nextId = 1L;  // Init for auto-generated job id's.

    @Override
    public List<Job> findAll() {
        return jobs;
    }

    @Override
    public String createJob(Job job) {
        job.setId(nextId++);
        jobs.add(job);
        return "Job Added Successfully"; // or return null
    }

    @Override
    public String deleteJob() {
        return null;
    }

    @Override
    public Job getJobById(Long id){
        for(Job job : jobs){
            if (job.getId().equals(id))
                return job;
        }
        return null;
    }


}
