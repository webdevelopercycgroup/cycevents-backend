package io.cycevents.app.controller;

import io.cycevents.app.dto.ApiResponse;
import io.cycevents.app.services.impl.SubscriberServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/subscribe")
@RequiredArgsConstructor
@CrossOrigin("*")
public class SubscribeCntroller {
    private final SubscriberServiceImpl service;

    @PostMapping
    public ResponseEntity<ApiResponse> subscribe(
            @RequestParam(name = "email") String email
    ){
        return new ResponseEntity<>(service.subscribe(email), HttpStatus.CREATED);
    }

}
