package io.cycevents.app.services;

import io.cycevents.app.dto.ApiResponse;
import io.cycevents.app.models.Appointment;

public interface AppointmentService {
    public ApiResponse makeAppointment(Appointment appointment);
}
