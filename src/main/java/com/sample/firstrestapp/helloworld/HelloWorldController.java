package com.sample.firstrestapp.helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @Autowired
    private MessageSource messageSource;

    //@GetMapping("/hello-world")
    @GetMapping(path="/hello-world")
    public String helloWorld() {
        return "Hello World!";
    }

    @GetMapping("/hello-world-bean")
    public HelloWorld helloWorldBean() {
        return new HelloWorld("First spring boot app");
    }

    @GetMapping("/hello-world-bean/{name}")
    public HelloWorld helloWorldNamePathVariable(@PathVariable String name) {
        return new HelloWorld(String.format("Welcome, %s", name));
    }

    // @GetMapping("/hello-world-internationalized")
    // public 
    // String helloWorlInternationalized(@RequestHeader(name = "Accept-Language", required = false) 
    // Locale locale)
    // 

    @GetMapping("/hello-world-internationalized")
    public String helloWorlInternationalized() {
        return messageSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());
    }

}
