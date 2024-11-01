package io.cycevents.app.services.impl;

import io.cycevents.app.dto.ApiResponse;
import io.cycevents.app.dto.JobApplicationDto;
import io.cycevents.app.exception.DuplicatesFoundException;
import io.cycevents.app.models.JobApplication;
import io.cycevents.app.repositories.JobApplicationRepository;
import io.cycevents.app.services.JobApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class JobApplicationServiceImpl implements JobApplicationService {
    private final JobApplicationRepository repository;
    private final MailService mailService;



    @Override
    public ApiResponse applyJob(JobApplication jobApplication) {
        try {
            repository.save(jobApplication);

            SimpleMailMessage message=new SimpleMailMessage();
            message.setFrom("jhantubala626@gmail.com");
            message.setTo("businesshead@cycgroup.in");
            message.setSubject("New Job Application Submission");
            // Construct the email body
            String emailBody = "Dear Admin,\n\n" +
                    "You have received a new job application. Below are the details:\n\n" +
                    "Name: " + jobApplication.getName() + "\n" +
                    "Email: " + jobApplication.getEmail() + "\n" +
                    "Contact Number: " + jobApplication.getContactNumber() + "\n" +
                    "Education Qualification: " + jobApplication.getEducationQualification() + "\n" +
                    "Professional Qualification: " + jobApplication.getProfessionalQualification() + "\n" +
                    "Year of Experience: " + jobApplication.getYearOfExperience() + "\n" +
                    "CV: " + (jobApplication.getCv() != null ? jobApplication.getCv() : "No CV provided") + "\n\n" +
                    "Thank you,\n" +
                    "cycevents.in";

            message.setText(emailBody);
            mailService.sendMail(message);
            return ApiResponse.builder()
                    .msg("Job Applied Successfully")
                    .status(true)
                    .build();
        }catch (Exception ex){
            ex.printStackTrace();
            throw new DuplicatesFoundException(ex.getMessage());
        }
    }

}
