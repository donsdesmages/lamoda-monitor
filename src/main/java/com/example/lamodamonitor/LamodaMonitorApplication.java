package com.example.lamodamonitor;

import com.example.lamodamonitor.mail.config.MailCredential;
import com.example.lamodamonitor.mail.config.MailCredentialProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
@EnableConfigurationProperties({MailCredentialProperties.class, MailCredential.class})
public class LamodaMonitorApplication {

	public static void main(String[] args) {
		SpringApplication.run(LamodaMonitorApplication.class, args);
	}

}

