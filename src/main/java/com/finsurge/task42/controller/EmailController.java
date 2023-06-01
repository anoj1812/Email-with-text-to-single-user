package com.finsurge.task42.controller;

import com.finsurge.task42.entity.Email;
import com.finsurge.task42.service.EmailService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.AddressException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class EmailController {
    @Autowired
    private EmailService emailService;
    @PostMapping(value = "/sendemail")
    public String sendEmail(@RequestBody Email email) throws AddressException, MessagingException, IOException {
        emailService.saveEmail(email);
        emailService.sendMail();
        return "Email sent " ;
    }
}

