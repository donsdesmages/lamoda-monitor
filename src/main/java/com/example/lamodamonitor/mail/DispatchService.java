package com.example.lamodamonitor.mail;

import com.example.lamodamonitor.mail.config.MailCredentialProperties;
import com.example.lamodamonitor.model.MonitorResponseDto;
import freemarker.cache.FileTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import static com.example.lamodamonitor.util.ConstantUrl.URL_HTML;

@Slf4j
@Service
@RequiredArgsConstructor
public class DispatchService {

    private final ConfigurationMail configurationMail;

    private final Configuration configuration;

    private final MailCredentialProperties mailCredentialProperties;

    public void sendMessage(String mail, MonitorResponseDto responseDto) {
        try {
            Session session = configurationMail.configuration();
            session.setDebug(true);

            MimeMessage message = new MimeMessage(session);

            message.setFrom(new InternetAddress(mailCredentialProperties.userNameEmail()));
            message.addRecipient(MimeMessage.RecipientType.TO, new InternetAddress(mail));
            message.setSubject("Тема письма:");

            FileTemplateLoader templateLoader = new FileTemplateLoader(new File(URL_HTML));

            configuration.setTemplateLoader(templateLoader);

            Template template = configuration.getTemplate("response.ftl");

            log.info("lamoda-response: " + responseDto.price());

            Map<String, Object> lamodaResponse = new HashMap<>();
            lamodaResponse.put("title", responseDto.title());
            lamodaResponse.put("sku" , responseDto.sku());
            lamodaResponse.put("price", responseDto.price());
            lamodaResponse.put("sizes", responseDto.sizes().size());
            lamodaResponse.put("seo_title", responseDto.seo_title());

            StringWriter writer = new StringWriter();

            template.process(lamodaResponse, writer);

            message.setContent("Data about of product: "
                    + writer.toString(), "text/html");

            Transport.send(message);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
