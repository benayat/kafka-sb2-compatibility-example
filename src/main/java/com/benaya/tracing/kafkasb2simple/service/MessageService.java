package com.benaya.tracing.kafkasb2simple.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.concurrent.CompletableFuture;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class MessageService {
    private final KafkaTemplate<String, String> kafkaTemplate;

    public ListenableFuture<SendResult<String,String>> sendMessage(String msg) {
        return kafkaTemplate.send("sb3InputTopic", msg);
    }

    @KafkaListener(topics = {"sb2InputTopic"}, groupId = "group1", autoStartup = "true")
    public void listen(String message) {
        log.info("Received Message in sb3: " + message);
        System.out.println("Received Message with listener: " + message);
    }

}
