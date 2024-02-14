package com.example.firstjobapp.job.impl;
import com.example.firstjobapp.job.Job;
import com.example.firstjobapp.job.JobService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
    public boolean deleteJob(Long id) {
        boolean removed = jobs.removeIf( job -> job.getId().equals(id) );
        return removed;
    }

    @Override
    public boolean updateJob(Long id, Job newJob) {
        newJob.setId(id);   // override newJob id with id requested in jobs/{id}
        Job job = this.getJobById(id);

        if (job != null)
            return job.updateFrom(newJob); // true / false
        else // no such job with id found.
            return false;
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
