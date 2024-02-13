package com.example.firstjobapp.job;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;


@RestController
public class JobController {

    private JobService jobService;

    public JobController(JobService jobService) {
        // At runtime, SB will inject an impl of 'JobService' interface  here.
        this.jobService = jobService;

        // Init one job in our db
        Job job = new Job( (long)10, "Best Job", "Just relax", (long) 1000, (long) 2000, "Timbuktu" );
        this.jobService.createJob(job);
    }

    @GetMapping("/jobs")
    public List<Job> findAll(){
        return jobService.findAll();
    }


    // Send POST with a body json as { "id": ... "title": ... "description": .... }
    @PostMapping("/jobs")
    public String createJob(@RequestBody Job job) {
        return jobService.createJob(job);
    }
}
