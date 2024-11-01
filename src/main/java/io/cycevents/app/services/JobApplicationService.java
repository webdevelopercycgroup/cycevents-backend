package io.cycevents.app.services;

import io.cycevents.app.dto.ApiResponse;
import io.cycevents.app.dto.JobApplicationDto;
import io.cycevents.app.models.JobApplication;

public interface JobApplicationService {
    public ApiResponse applyJob(JobApplication jobApplication);
}
