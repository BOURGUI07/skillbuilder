package com.example.kakfaproducerexample.publisher;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaMessagePublisher {
    private final KafkaTemplate<String, Object> template;

    public void sendMessage(String topic, Object message) {
        template.send(topic, message);
    }
}
