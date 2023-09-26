package com.benaya.tracing.kafkasb2simple.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class TopicsConfig {
    @Bean
    public NewTopic sb2InputTopic() {
        return TopicBuilder
                .name("sb2InputTopic")
                .build();
    }
    @Bean
    public NewTopic sb3InputTopic() {
        return TopicBuilder
                .name("sb3InputTopic")
                .build();
    }
}
