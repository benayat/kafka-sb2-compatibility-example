package com.benaya.tracing.kafkasb2simple.controller;

import com.benaya.tracing.kafkasb2simple.service.MessageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutionException;


@RestController
@RequiredArgsConstructor
@Slf4j
public class Sb2ToSb3KafkaController {

    private final MessageService messageService;

    @GetMapping("/sb2tosb3Get")
    public String sb2ToSb3() throws ExecutionException, InterruptedException {
        ListenableFuture<SendResult<String,String>> messageSent = messageService.sendMessage("from sb2 to sb3");
        messageSent.get().getProducerRecord().headers().forEach(header -> log.info("header: key: {}, and value: {}", header.key(), new String(header.value(), StandardCharsets.UTF_8)));
        return messageSent.get().toString();
    }
    @PutMapping("/sb2tosb3Kafka")
    public void sb2ToSb3Kafka() {
        messageService.sendMessage("from sb2 to sb3");
    }
}
