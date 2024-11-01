package io.cycevents.app.controller;

import io.cycevents.app.dto.ApiResponse;
import io.cycevents.app.models.JobApplication;
import io.cycevents.app.services.impl.JobApplicationServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/job-application")
@RequiredArgsConstructor
@CrossOrigin("*")
public class JobApplicationController {
    private final JobApplicationServiceImpl service;


    @PostMapping
    public ApiResponse applyJob(@RequestBody JobApplication jobApplication){
        return service.applyJob(jobApplication);
    }

}
