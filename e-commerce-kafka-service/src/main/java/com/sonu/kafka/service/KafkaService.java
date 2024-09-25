package com.sonu.kafka.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {

    @KafkaListener(topics = {"my-topic"}, groupId = "my-group")
    public void consumer(String message) {
        System.out.println("Consumer--Message--> " + message);
    }

}
