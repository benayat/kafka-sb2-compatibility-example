package com.benaya.tracing.kafkasb2simple.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@Slf4j
public class TestController {


    private final RestTemplate restTemplate;

    @GetMapping("/test-sb2")
    public String test(@RequestHeader Map<String,String> headers) {
        log.info("in sb2 app, headers: {}", headers.toString());
        return restTemplate.getForObject("/test", String.class);
    }
    @GetMapping("/test")
    public String testFromApi(@RequestHeader Map<String,String> headers) {
        log.info("in sb2 app endpoint testFromApi, headers: {}", headers.toString());
        return "test";
    }


}
