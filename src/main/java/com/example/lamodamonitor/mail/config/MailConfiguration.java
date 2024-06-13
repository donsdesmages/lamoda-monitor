package com.example.lamodamonitor.mail.config;

import com.example.lamodamonitor.mail.config.MailCredential;
import com.example.lamodamonitor.mail.config.MailCredentialProperties;
import jakarta.mail.Authenticator;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Component
@Configuration
@RequiredArgsConstructor
public class MailConfiguration {

    private final MailCredential mailCredentiaL;

    private final MailCredentialProperties mailCredentialProperties;

    public Session configuration() {
        Properties properties = new Properties();

        properties.put("mail.smtp.host", mailCredentiaL.host());
        properties.put("mail.smtp.port", mailCredentiaL.port());
        properties.put("mail.smtp.ssl.enable", mailCredentiaL.ssl().enable().value());
        properties.put("mail.smtp.auth", mailCredentiaL.auth().value());

        return Session.getInstance(properties, new Authenticator() {

            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(
                        mailCredentialProperties.userNameEmail(),
                        mailCredentialProperties.userPasswordEmail());
            }
        });
    }
}
