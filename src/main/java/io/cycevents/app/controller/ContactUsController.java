package io.cycevents.app.controller;

import io.cycevents.app.dto.ApiResponse;
import io.cycevents.app.models.ContactUs;
import io.cycevents.app.services.ContactUsService;
import io.cycevents.app.services.impl.ContactUsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
@RequestMapping("/api/v1/contact")
public class ContactUsController {
    private final ContactUsServiceImpl service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse createContact(@RequestBody ContactUs contactUs){
        return service.postCOtactUs(contactUs);
    }
}
