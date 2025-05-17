package com.weiz.notificationservice.event;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class EventConsumer {

    @KafkaListener(topics = "test", containerFactory = "KafkaListenerContainerFactory")
    public void listen(String message) {
        log.info("Received message: {}", message);
    }
}
