package io.cycevents.app.controller;

import io.cycevents.app.dto.ApiResponse;
import io.cycevents.app.models.CustomerReview;
import io.cycevents.app.services.CustomerReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/review")
@RequiredArgsConstructor
@CrossOrigin("*")
public class CustomerReviewsController {
    private final CustomerReviewService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse createPOst(@RequestBody CustomerReview customerReview){
        return service.createReview(customerReview);
    }

    @GetMapping
    public ResponseEntity<List<CustomerReview>> allREviews(){
        return ResponseEntity.ok(service.getAllReviews());
    }

}
