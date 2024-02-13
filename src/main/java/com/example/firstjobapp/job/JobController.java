package com.example.firstjobapp.job;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class JobController {

    private JobService jobService;

    public JobController(JobService jobService) {
        // At runtime, SB will inject an impl of 'JobService' interface  here.
        this.jobService = jobService;

        // Init a couple of dummy jobs in our db
        Job job1 = new Job( null, "Best Job", "Just relax", (long) 1000, (long) 2000, "Hawaii" );
        Job job2 = new Job( null, "Worst Job", "Work Hard", (long) 0, (long) 20, "Timbuktu" );
        this.jobService.createJob(job1);
        this.jobService.createJob(job2);

    }

    @GetMapping("/jobs")
    public List<Job> findAll(){
        return jobService.findAll();
    }


    // Send POST with a body json as { "id": ... "title": ... "description": .... }
    @PostMapping("/jobs")
    public ResponseEntity<String> createJob(@RequestBody Job job) {
        String resp = jobService.createJob(job);
        if (resp != null)
            return new ResponseEntity<>(resp, HttpStatus.OK);
        else
            return new ResponseEntity<>("Failed Creating Job", HttpStatus.BAD_REQUEST);

    }

    @GetMapping("/jobs/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id){
        Job job = jobService.getJobById(id);
        if (job != null)
            return ResponseEntity.ok(job); // alt. to new ResponseEntity<>(job, HttpStatus.OK)
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
}
