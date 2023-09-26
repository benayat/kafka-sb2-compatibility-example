package com.benaya.tracing.kafkasb2simple.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

@RequiredArgsConstructor
@Slf4j
@Service
public class MessageService {
    private final KafkaTemplate<String, String> kafkaTemplate;

    public ListenableFuture<SendResult<String,String>> sendMessage(String msg) {
        ListenableFuture<SendResult<String, String>> sentFuture = kafkaTemplate.send("sb3InputTopic", msg);
        sentFuture.addCallback(
                result -> {
                    assert result != null;
                    log.info("Message [{}] delivered with metadata {}", msg, result.getRecordMetadata());
                    log.info("in sender method, headers are: {}", result.getProducerRecord().headers().toString());
                },
                ex -> log.error("Unable to deliver message [{}]. {}", msg, ex.getMessage())

        );
        return sentFuture;
    }

    @KafkaListener(topics = {"sb2InputTopic"}, groupId = "group1", autoStartup = "true")
    public void listen(@Payload ConsumerRecord<String, String> consumerRecord, @Headers MessageHeaders messageHeaders ) {
        log.info("Received Message in sb2 with payload: {}", consumerRecord.value());
        log.info("all record: {}", consumerRecord.toString());
        messageHeaders.forEach((key, value) -> log.info("from headers param - header: key: {}, and value: {}", key, value));
        consumerRecord.headers().forEach(header -> log.info("from consumer-record - header: key: {}, and value: {}", header.key(), new String(header.value())));
    }

}
