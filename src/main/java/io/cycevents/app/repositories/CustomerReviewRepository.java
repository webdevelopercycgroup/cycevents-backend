package io.cycevents.app.repositories;

import io.cycevents.app.models.CustomerReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerReviewRepository extends JpaRepository<CustomerReview,Integer> {

}
