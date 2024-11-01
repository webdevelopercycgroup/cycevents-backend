package io.cycevents.app.controller;

import io.cycevents.app.dto.ApiResponse;
import io.cycevents.app.models.Appointment;
import io.cycevents.app.services.impl.AppointmentServiceImple;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/appointment")
@RequiredArgsConstructor
@CrossOrigin("*")
public class AppointmentController {
    private final AppointmentServiceImple service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse createAppointment(@RequestBody Appointment appointment){
        return service.makeAppointment(appointment);
    }

}
