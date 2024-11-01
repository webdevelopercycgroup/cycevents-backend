package io.cycevents.app.repositories;

import io.cycevents.app.models.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository extends JpaRepository<Job,Integer> {
    public List<Job> findAllByOrderByPostDateDesc();
}
