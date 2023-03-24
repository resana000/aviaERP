package com.example.demo.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@Profile("dockerized")
public class KafkaConsumer {

    private static String TOPIC = "topic";

    @KafkaListener(topics = "topic", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(String message){
        log.info(String.format("consume message = %s", message));
    }
}
