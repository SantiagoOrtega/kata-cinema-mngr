package com.kata.kata_cinema_mngr.services.email;

public interface EmailService {

    void sendEmail(String emailTo, String subject, String body);

}
