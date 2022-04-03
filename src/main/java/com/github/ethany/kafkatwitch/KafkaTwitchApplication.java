package com.github.ethany.kafkatwitch;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.*;

@SpringBootApplication
public class KafkaTwitchApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaTwitchApplication.class, args);
    }
}
