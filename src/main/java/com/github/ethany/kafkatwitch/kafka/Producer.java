package com.github.ethany.kafkatwitch.kafka;


import com.github.ethany.kafkatwitch.kafka.util.CreateSocketOutputStream;
import com.github.ethany.kafkatwitch.kafka.util.TwitchIrcConnection;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Component
@RequiredArgsConstructor
class Producer {

    private static final String TOPIC = "twitch";
    private static final Logger LOGGER = Logger.getLogger(Producer.class.getName());
    @Autowired
    private final KafkaTemplate<String, String> kafkaTemplate;

    @EventListener(ApplicationStartedEvent.class)
    public void twitch_channels() {

        List<String> channels_01 = new ArrayList<>();
        channels_01.add("#leehunnyeo");
        channels_01.add("#s1032204");

        List<String> channels_02 = new ArrayList<>();
        channels_02.add("#jinu6734");
        channels_02.add("#nanayango3o");

        List<String> channels_03 = new ArrayList<>();
        channels_03.add("#woohankyung");
        channels_03.add("#hatsalsal");

        List<List<String>> channels = new ArrayList<>();
        channels.add(channels_01);
        channels.add(channels_02);
        channels.add(channels_03);

        for (List<String> list: channels){
            new Thread(TwitchIrcConnection
                    .builder()
                    .channels(list)
                    .kafkaTemplate(kafkaTemplate)
                    .topic(TOPIC)
                    .logger(LOGGER)
                    .streamDto(CreateSocketOutputStream
                            .builder()
                            .logger(LOGGER)
                            .build()
                            .createSocketOutputStream())
                    .build()).start();
        }
    }
}
