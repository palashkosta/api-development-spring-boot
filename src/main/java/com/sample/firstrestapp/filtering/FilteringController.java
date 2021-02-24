package com.sample.firstrestapp.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilteringController {
    
    @GetMapping("/filtering-sample")
    public Sample retrieveSample() {
        return new Sample("one", "two", " three");
    }

    @GetMapping("/filtering-sample-list")
    public List<Sample> retrieveSampleList() {
        return Arrays.asList(new Sample("one", "two", " three"), new Sample("nine", "ten", " eleven"));
    }
}
