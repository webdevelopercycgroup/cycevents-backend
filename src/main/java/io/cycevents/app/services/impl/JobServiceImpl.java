package io.cycevents.app.services.impl;

import io.cycevents.app.dto.ApiResponse;
import io.cycevents.app.exception.ResourceNotFoundException;
import io.cycevents.app.models.Job;
import io.cycevents.app.repositories.JobRepository;
import io.cycevents.app.services.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobServiceImpl implements JobService {
    private final JobRepository repository;
    @Override
    public ApiResponse createJob(Job job) {
        repository.save(job);
        return ApiResponse.builder()
                .msg("Job Created Successfully")
                .status(true)
                .build();
    }

    @Override
    public List<Job> getAllJobs() {
        List<Job> jobs=repository.findAllByOrderByPostDateDesc();
        return jobs;
    }

    @Override
    public Job getJobById(int id) {
        Job job=repository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Invalid Job"));
        return job;
    }
}
