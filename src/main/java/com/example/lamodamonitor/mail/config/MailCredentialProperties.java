package com.example.lamodamonitor.mail.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("email")
public record MailCredentialProperties(
        String userNameEmail,

        String userPasswordEmail
)
{
}