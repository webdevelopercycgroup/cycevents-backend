package io.cycevents.app.services.impl;

import io.cycevents.app.dto.ApiResponse;
import io.cycevents.app.models.Subscribe;
import io.cycevents.app.repositories.SubscriberRepository;
import io.cycevents.app.services.SubscriberService;
import io.cycevents.app.exception.DuplicatesFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SubscriberServiceImpl implements SubscriberService {

    private final SubscriberRepository repository;

    @Override
    public ApiResponse subscribe(String email) {
        if(checkSubscription(email)){
            throw new DuplicatesFoundException("Already you have subscribed!");
        }
        String id= UUID.randomUUID().toString();
        Subscribe subscribe= Subscribe.builder()
                .id(id)
                .email(email)
                .build();
        repository.save(subscribe);
        return ApiResponse.builder()
                .msg("Subscribed Successfully!")
                .status(true)
                .build();
    }

    @Override
    public boolean checkSubscription(String email) {
        return repository.existsByEmail(email);
    }
}
