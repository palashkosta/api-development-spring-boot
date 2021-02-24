package com.sample.firstrestapp;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

@SpringBootApplication
public class FirstRestAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstRestAppApplication.class, args);
	}

	// Internationalization-I18n -- start
	@Bean
	public LocaleResolver localeResolver() {
		AcceptHeaderLocaleResolver sessionLocaleResolver = new AcceptHeaderLocaleResolver();
		sessionLocaleResolver.setDefaultLocale(Locale.US);
		return sessionLocaleResolver;
	}


	@Bean
	public ResourceBundleMessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("messages");
		return messageSource;
	}
	// CAN ALSO DONE THE SAME THING BY SETTING APPLICATION PROPERTIES - spring.messages.basename="messages"
	// I18n -- end

}
