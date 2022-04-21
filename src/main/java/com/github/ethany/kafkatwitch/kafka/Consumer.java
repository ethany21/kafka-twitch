package com.github.ethany.kafkatwitch.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
class Consumer {

    @KafkaListener(topics = "twitch", groupId = "consumer_group_id")
    public void consumeMessage(String message){
        System.out.println("recieved message is" + message);

    }
}
