package com.kata.kata_cinema_mngr.controller;

import com.kata.kata_cinema_mngr.model.EmailModel;
import com.kata.kata_cinema_mngr.services.email.EmailService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
public class EmailController {

    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/send")
    public ResponseEntity<String> sendEmail(@RequestBody EmailModel emailModel) {
        emailService.sendEmail(emailModel.getEmailTo(), emailModel.getSubject(), emailModel.getBody());
        return ResponseEntity.ok("email sent successfully");
    }

}
