package com.github.ethany.kafkatwitch;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class KafkaTwitchApplication {


    @Bean
    NewTopic kafkaTwitch(){
        return new NewTopic("twitch", 3, (short) 3);
    }

    public static void main(String[] args) {
        SpringApplication.run(KafkaTwitchApplication.class, args);
    }
}
