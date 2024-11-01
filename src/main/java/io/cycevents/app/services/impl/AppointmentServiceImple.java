package io.cycevents.app.services.impl;

import io.cycevents.app.dto.ApiResponse;
import io.cycevents.app.exception.DuplicatesFoundException;
import io.cycevents.app.models.Appointment;
import io.cycevents.app.repositories.AppointmentRepository;
import io.cycevents.app.services.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImple implements AppointmentService {

    private final AppointmentRepository repository;
    private final MailService mailService;

    @Override
    public ApiResponse makeAppointment(Appointment appointment) {

        try{
            SimpleMailMessage message=new SimpleMailMessage();
            message.setFrom("jhantubala626@gmail.com");
            message.setTo("businesshead@cycgroup.in");
            message.setSubject("New Contact Form Submission");
            message.setText("Dear Admin,\n\n" +
                    "You have received a new Appointment Request from your Website cycevents.in . Below are the details:\n\n" +
                    "Name: " + appointment.getName() + "\n" +
                    "Email: " + appointment.getEmail() + "\n" +
                    "Phone Number: " + appointment.getPhone() + "\n\n" +
                    "Date:\n" + appointment.getData() + "\n\n" +
                    "Time:\n" + appointment.getTime() + "\n\n" +
                    "City:\n" + appointment.getCity() + "\n\n" +
                    "cycevents.in");
            boolean status=mailService.sendMail(message);
            if(status){
                repository.save(appointment);
            }

        }catch (Exception ex){
            throw new DuplicatesFoundException("Something went wrong!");
        }


        return ApiResponse.builder()
                .msg("Booked an appointment")
                .status(true)
                .build();
    }
}
