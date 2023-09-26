//package com.benaya.tracing.kafkasb2simple.consumer;
//
//import org.apache.kafka.clients.consumer.ConsumerInterceptor;
//import org.apache.kafka.clients.consumer.ConsumerRecords;
//import org.apache.kafka.clients.consumer.OffsetAndMetadata;
//import org.apache.kafka.common.TopicPartition;
//
//import java.util.Map;
//
//public class Interceptor<V, K> implements ConsumerInterceptor<V, K> {
//    @Override
//    public ConsumerRecords<V, K> onConsume(ConsumerRecords<V, K> consumerRecords) {
//        return null;
//    }
//
//    @Override
//    public void onCommit(Map<TopicPartition, OffsetAndMetadata> map) {
//
//    }
//
//    @Override
//    public void close() {
//
//    }
//
//    @Override
//    public void configure(Map<String, ?> map) {
//
//    }
//}
