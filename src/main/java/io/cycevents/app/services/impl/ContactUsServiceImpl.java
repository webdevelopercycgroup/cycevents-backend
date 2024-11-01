package io.cycevents.app.services.impl;

import io.cycevents.app.dto.ApiResponse;
import io.cycevents.app.exception.DuplicatesFoundException;
import io.cycevents.app.models.ContactUs;
import io.cycevents.app.repositories.ContactUsRepository;
import io.cycevents.app.services.ContactUsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ContactUsServiceImpl implements ContactUsService {
    private final ContactUsRepository repository;
    private final MailService mailService;

    @Override
    public ApiResponse postCOtactUs(ContactUs contactUs) {
        try{
            log.info("Ok");
            SimpleMailMessage message=new SimpleMailMessage();
            message.setFrom("jhantubala626@gmail.com");
            message.setTo("businesshead@cycgroup.in");
            message.setSubject("New Contact Form Submission");
            message.setText("Dear Admin,\n\n" +
                    "You have received a new message from your website contact form. Below are the details:\n\n" +
                    "Name: " + contactUs.getFirstName()+" "+contactUs.getLastName() + "\n" +
                    "Email: " + contactUs.getEmail() + "\n" +
                    "Phone Number: " + contactUs.getPhone() + "\n\n" +
                    "Message:\n" + contactUs.getMessage() + "\n\n" +
                    "cycevents.in");
            mailService.sendMail(message);
            repository.save(contactUs);
        }catch (Exception e){
            e.printStackTrace();
            throw new DuplicatesFoundException("Something went wrong");
        }
        return ApiResponse.builder()
                .msg("Successfully Submitted")
                .status(true)
                .build();
    }
}
