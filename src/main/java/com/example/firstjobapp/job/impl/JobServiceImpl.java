package com.example.firstjobapp.job.impl;
import com.example.firstjobapp.job.Job;
import com.example.firstjobapp.job.JobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

// Use @Service annotation to identify this as a service implementation
@Service
public class JobServiceImpl implements JobService {

    private List<Job> jobs = new ArrayList<Job>();  // Simulate a DB of Jobs

    @Override
    public List<Job> findAll() {
        return jobs;
    }

    @Override
    public String createJob(Job job) {
        jobs.add(job);
        return "Job Added Successfully";
    }

    @Override
    public String deleteJob() {
        return null;
    }
}