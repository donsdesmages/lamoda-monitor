package com.example.lamodamonitor.mail;

import jakarta.mail.Authenticator;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import lombok.RequiredArgsConstructor;
import com.example.lamodamonitor.mail.config.MailCredentialsProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Component
@Configuration
@RequiredArgsConstructor
public class ConfigurationMail {

    private final MailCredentialsProperties mailCredentialsProperties;

    public Session configuration() {
        Properties properties = new Properties();

        properties.put("mail.smtp.host", mailCredentialsProperties.host());
        properties.put("mail.smtp.port", mailCredentialsProperties.port());
        properties.put("mail.smtp.ssl.enable", mailCredentialsProperties.ssl().enable().value());
        properties.put("mail.smtp.auth", mailCredentialsProperties.auth().value());

        return Session.getInstance(properties, new Authenticator() {

            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("donsdesmages@gmail.com", "igrujhicweokbyze");
            }
        });
    }
}
