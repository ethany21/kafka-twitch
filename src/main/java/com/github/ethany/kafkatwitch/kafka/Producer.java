package com.github.ethany.kafkatwitch.kafka;


import com.github.ethany.kafkatwitch.kafka.util.CreateSocketOutputStream;
import com.github.ethany.kafkatwitch.kafka.util.TwitchIrcConnection;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.io.IOException;
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
        List<String> channels = new ArrayList<>();
        channels.add("#kimdoe");
        channels.add("#jungtaejune");
        channels.add("#2chamcham2");
        channels.add("#obm1025");
        channels.add("#rooftopcat99");
        channels.add("#tranth");
        channels.add("#dkwl025");

        channels.add("#sooflower");
        channels.add("#luna_ddd");
        channels.add("#eclipia");
        channels.add("#e_saem");
        channels.add("#agueppo");
        channels.add("#dda_ju");
        channels.add("#hanryang1125");

        channels.add("#handongsuk");
        channels.add("#tmxk319");
        channels.add("#woowakgood");
        channels.add("#lilpaaaaaa");
        channels.add("#vo_ine");
        channels.add("#gosegugosegu");
        channels.add("#maoruya");

        channels.add("#109ace");
        channels.add("#looksam");
        channels.add("#ao_o5");
        channels.add("#95pingman");
        channels.add("#kumikomii");
        channels.add("#kuiki771");

        channels.add("#esl_dota2");
        channels.add("#asmongold");
        channels.add("#kato_junichi0817");
        channels.add("#loltyler1");
        channels.add("#dota2mc");
        channels.add("#thisisnotgeorgenotfound");

        channels.add("#just_ns");
        channels.add("#woohankyung");
        channels.add("#ddahyoni");
        channels.add("#d_obby");
        channels.add("#stylishnoob4");
        channels.add("#fps_shaka");

        for (String channel : channels){
            new Thread(TwitchIrcConnection
                    .builder()
                    .channel(channel)
                    .kafkaTemplate(kafkaTemplate)
                    .topic(TOPIC)
                    .logger(LOGGER)
                    .build())
                    .start();
        }
    }
}
