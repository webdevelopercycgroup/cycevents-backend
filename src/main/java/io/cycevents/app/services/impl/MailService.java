package io.cycevents.app.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailService {
    private final JavaMailSender mailSender;
    public boolean sendMail(SimpleMailMessage message){
        try{
            mailSender.send(message);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
