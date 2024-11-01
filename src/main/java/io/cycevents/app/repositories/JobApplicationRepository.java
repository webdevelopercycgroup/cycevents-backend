package io.cycevents.app.repositories;

import io.cycevents.app.models.JobApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobApplicationRepository extends JpaRepository<JobApplication,Long> {

}
