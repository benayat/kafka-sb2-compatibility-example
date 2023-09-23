//package com.benaya.tracing.kafkasb2simple.config;
//
//import io.opentelemetry.exporter.otlp.http.trace.OtlpHttpSpanExporter;
//import io.opentelemetry.exporter.otlp.trace.OtlpGrpcSpanExporter;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class OtlpConfig {
//    @Bean
//    OtlpHttpSpanExporter otlpHttpSpanExporter(@Value("${tracing.url}") String url) {
//        return OtlpHttpSpanExporter.builder()
//                .setEndpoint(url)
//                .build();
//    }
//    @Bean
//    public OtlpGrpcSpanExporter otlpHttpSpanExporter(@Value("${tracing.url}") String url) {
//        return OtlpGrpcSpanExporter.builder().setEndpoint(url).build();
//    }
//}