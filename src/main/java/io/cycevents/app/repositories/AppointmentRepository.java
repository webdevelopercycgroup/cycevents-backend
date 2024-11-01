package io.cycevents.app.repositories;

import io.cycevents.app.models.Appointment;
import io.cycevents.app.services.AppointmentService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment,Integer> {
}
