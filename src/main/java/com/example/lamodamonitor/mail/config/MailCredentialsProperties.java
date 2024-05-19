package com.example.lamodamonitor.mail.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("spring.mail")
public record MailCredentialsProperties(
        String host,

        String port,

        Ssl ssl,

        Auth auth
)
{
    public record Ssl(

            Enable enable
    ) {
        public record Enable(
                String value
        ){

        }
    }
    public record Auth(
            String value
    ) {}
}