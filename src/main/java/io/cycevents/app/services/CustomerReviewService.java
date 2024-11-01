package io.cycevents.app.services;


import io.cycevents.app.dto.ApiResponse;
import io.cycevents.app.models.CustomerReview;

import java.util.List;

public interface CustomerReviewService {
    public ApiResponse createReview(CustomerReview customerReview);
    public List<CustomerReview> getAllReviews();
}
