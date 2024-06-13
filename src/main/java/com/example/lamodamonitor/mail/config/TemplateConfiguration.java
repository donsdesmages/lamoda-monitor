package com.example.lamodamonitor.mail.config;

import com.example.lamodamonitor.model.MonitorResponseDto;
import freemarker.cache.FileTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import static com.example.lamodamonitor.util.ConstantUrl.URL_HTML;

@Slf4j
@Component
@RequiredArgsConstructor
public class TemplateConfiguration {

    private final Configuration configuration;

    public StringWriter template(MonitorResponseDto responseDto) throws IOException, TemplateException {
        try {
            FileTemplateLoader templateLoader = new FileTemplateLoader(new File(URL_HTML));

            configuration.setTemplateLoader(templateLoader);

        } catch (Exception e) {
            e.printStackTrace();
        }

        Map<String, Object> lamodaResponse = new HashMap<>();

        lamodaResponse.put("title", responseDto.title());
        lamodaResponse.put("sku" , responseDto.sku());
        lamodaResponse.put("price", responseDto.price());
        lamodaResponse.put("sizes", responseDto.sizes().size());
        lamodaResponse.put("seo_title", responseDto.seo_title());

        log.info("lamoda-response: " + responseDto.price());

        Template template = configuration.getTemplate("response.ftl");

        StringWriter writer = new StringWriter();

        template.process(lamodaResponse, writer);

        return writer;
    }
}
