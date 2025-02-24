package com.kata.kata_cinema_mngr.services.email;

import com.kata.kata_cinema_mngr.AwsConfig;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.ses.SesClient;
import software.amazon.awssdk.services.ses.model.*;

@Service
public class EmailServiceImpl implements EmailService {

    private final SesClient sesClient;

    public EmailServiceImpl(AwsConfig awsConfig) {
        this.sesClient = SesClient.builder()
                .region(Region.of(awsConfig.getRegion()))
                .credentialsProvider(StaticCredentialsProvider.create(
                        AwsBasicCredentials.create(awsConfig.getAccessKey(), awsConfig.getSecretKey())
                )).build();
    }

    @Override
    public void sendEmail(String emailTo, String subject, String body) {
        SendEmailRequest request = SendEmailRequest.builder()
                .destination(Destination.builder().toAddresses(emailTo).build())
                .message(Message.builder()
                        .subject(Content.builder().data(subject).build())
                        .body(Body.builder().text(Content.builder().data(body).build()).build())
                        .build())
                .source("cinemabanboger@gmail.com")
                .build();

        sesClient.sendEmail(request);
    }

}
