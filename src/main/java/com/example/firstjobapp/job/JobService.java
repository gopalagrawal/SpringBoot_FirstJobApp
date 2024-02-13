package com.example.firstjobapp.job;
import org.springframework.http.ResponseEntity;

import java.util.List;

// Note the use of "interface" rather than class for loose coupling w/ controller.
// The implementation of this interface is in job/impl/JobServiceImpl.java
public interface JobService {
    abstract List<Job> findAll();
    abstract String createJob(Job job);

    abstract Job getJobById(Long id);
    abstract String deleteJob();
}
