package io.cycevents.app.services.impl;

import io.cycevents.app.dto.ApiResponse;
import io.cycevents.app.models.CustomerReview;
import io.cycevents.app.repositories.CustomerReviewRepository;
import io.cycevents.app.services.CustomerReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerReviewServiceImpl implements CustomerReviewService {
    private final CustomerReviewRepository repository;

    @Override
    public ApiResponse createReview(CustomerReview customerReview) {
        repository.save(customerReview);
        return ApiResponse.builder()
                .msg("Review Post Successfully")
                .status(true)
                .build();
    }

    @Override
    public List<CustomerReview> getAllReviews() {
        List<CustomerReview> customerReviews=repository.findAll();
        return customerReviews;
    }
}
