package com.github.ethany.kafkatwitch.kafka;

import com.github.ethany.kafkatwitch.elasticsearch.document.TwitchMessage;
import com.github.ethany.kafkatwitch.elasticsearch.service.TwitchMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
@RequiredArgsConstructor
class Consumer {

    private static final Logger LOGGER = Logger.getLogger(Consumer.class.getName());

    private final TwitchMessageService twitchMessageService;

    @KafkaListener(topics = "twitch", groupId = "consumer_group_id")
    public void consumeMessage(String message) {
        LOGGER.info(message);


        TwitchMessage twitchMessage = TwitchMessage.builder().build();
        twitchMessageService.save(null);


    }
}
