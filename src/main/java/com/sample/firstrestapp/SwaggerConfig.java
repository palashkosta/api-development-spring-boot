package com.sample.firstrestapp;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

    private static final Contact DEFAULT_CONTACT = new Contact("PALASH KOSTA", "", "developer.palashkosta@gmail.com");

    public static final ApiInfo DEFAULT_APIINFO = new ApiInfo("spring Boot Documentation", "API using Spring Boot Documentation", "1.0", "urn:tos",
            DEFAULT_CONTACT, "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0", new ArrayList<>());

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.OAS_30).apiInfo(DEFAULT_APIINFO);
    }
}