package com.example.lamodamonitor.mail;

import com.example.lamodamonitor.model.MonitorResponseDto;
import freemarker.cache.FileTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerConfigurationFactoryBean;

import java.io.File;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class DispatchService {

    private final ConfigurationMail configurationMail;

    private final Configuration configuration;

    public void sendMessage(String mail, MonitorResponseDto responseDto) {
        StringBuffer response = new StringBuffer()
                .append(responseDto.price())
                .append(responseDto.attributes())
                .append(responseDto.title())
                .append(responseDto.sku());

        try {
            Session session = configurationMail.configuration();

            session.setDebug(true);

            MimeMessage message = new MimeMessage(session);

            message.setFrom(new InternetAddress("donsdesmages@gmail.com"));
            message.addRecipient(MimeMessage.RecipientType.TO, new InternetAddress(mail));
            message.setSubject("Тема письма:");
            message.setText("Данные о продукте : " + response);

            Transport.send(message);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
