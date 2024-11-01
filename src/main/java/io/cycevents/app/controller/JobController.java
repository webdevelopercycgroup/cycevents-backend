package io.cycevents.app.controller;

import io.cycevents.app.dto.ApiResponse;
import io.cycevents.app.models.Job;
import io.cycevents.app.services.impl.JobServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/job")
@CrossOrigin("*")
public class JobController {
    private final JobServiceImpl service;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse createJob(@RequestBody Job job){
        return service.createJob(job);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Job> allJobs(){
        return service.getAllJobs();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Job getJobById(@PathVariable int id){
        return service.getJobById(id);
    }

}
