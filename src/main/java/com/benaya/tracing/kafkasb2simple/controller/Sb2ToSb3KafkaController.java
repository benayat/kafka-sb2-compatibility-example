package com.benaya.tracing.kafkasb2simple.controller;

import com.benaya.tracing.kafkasb2simple.service.MessageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequiredArgsConstructor
@Slf4j
public class Sb2ToSb3KafkaController {

    private final RestTemplate restTemplate;
    private final MessageService messageService;

    @GetMapping("/sb2tosb3Get")
    public String sb2ToSb3() {
        ResponseEntity<String> response = restTemplate.getForEntity("/test", String.class);
        log.info("response headers: {}", response.getHeaders());
        return response.getBody();
    }
    @PutMapping("/sb2tosb3Kafka")
    public void sb2ToSb3Kafka() {
        messageService.sendMessage("from sb2 to sb3");
    }
}
