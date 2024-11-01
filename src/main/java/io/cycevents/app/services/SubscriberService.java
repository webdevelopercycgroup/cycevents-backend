package io.cycevents.app.services;

import io.cycevents.app.dto.ApiResponse;

public interface SubscriberService {
    public ApiResponse subscribe(String email);
    public boolean checkSubscription(String email);
}
