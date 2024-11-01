package io.cycevents.app.repositories;

import io.cycevents.app.models.Subscribe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubscriberRepository extends JpaRepository<Subscribe,String> {
    public boolean existsByEmail(String email);
}
