package io.cycevents.app.services;

import io.cycevents.app.dto.ApiResponse;
import io.cycevents.app.models.Job;

import java.util.List;

public interface JobService {
    public ApiResponse createJob(Job job);
    public List<Job> getAllJobs();
    public Job getJobById(int id);
}
