package com.github.ethany.kafkatwitch.kafka;

import com.github.ethany.kafkatwitch.elasticsearch.document.TwitchMessage;
import com.github.ethany.kafkatwitch.elasticsearch.service.TwitchMessageService;
import com.github.ethany.kafkatwitch.kafka.util.ParseMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
@RequiredArgsConstructor
class Consumer {

    private static final Logger LOGGER = Logger.getLogger(Consumer.class.getName());

    private final TwitchMessageService twitchMessageService;

    @KafkaListener(topics = "twitch", concurrency = "3", groupId = "elasticsearch_consumer")
    public void consumeMessage(String message) {

        try{
            twitchMessageService.save(TwitchMessage.builder()
                    .streamer(ParseMessage.getStreamer(message))
                    .viewer(ParseMessage.getViewer(message))
                    .message(ParseMessage.getMessage(message))
                    .build());
        }

        catch (ArrayIndexOutOfBoundsException e){
            LOGGER.info(message + ": caused Error");
        }

    }
}
