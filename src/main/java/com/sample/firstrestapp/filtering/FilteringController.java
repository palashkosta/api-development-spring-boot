package com.sample.firstrestapp.filtering;

import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilteringController {
    
    @GetMapping("/filtering-sample")
    public Sample retrieveSample() {
        return new Sample("one", "two", " three"); //@JsonIgnore in the Sample Object
    }

    @GetMapping("/filtering-sample-list")
    public List<Sample> retrieveSampleList() {
        return Arrays.asList(new Sample("one", "two", " three"), new Sample("nine", "ten", " eleven"));
    }

    @GetMapping("/filtering-sample-dn")
    public MappingJacksonValue etriveDynamicSample() {
        Sample sample = new Sample("value1", "value2", "value3");

        SimpleBeanPropertyFilter dynamicFilter = SimpleBeanPropertyFilter.filterOutAllExcept("value1", "value2");
        FilterProvider filterProvider = new SimpleFilterProvider().addFilter("SampleFilter", dynamicFilter);

        MappingJacksonValue mapping = new MappingJacksonValue(sample);
        mapping.setFilters(filterProvider);

        return mapping;
    }
}
