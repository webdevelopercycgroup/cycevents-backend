package io.cycevents.app.services;

import io.cycevents.app.dto.ApiResponse;
import io.cycevents.app.models.ContactUs;

public interface ContactUsService {
    public ApiResponse postCOtactUs(ContactUs contactUs);
}
