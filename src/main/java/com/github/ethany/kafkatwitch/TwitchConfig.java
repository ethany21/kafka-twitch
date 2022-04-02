package com.github.ethany.kafkatwitch;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("twitch")
@Data
public class TwitchConfig {
    private String server;
    private String username;
    private int port;
    private String token;
}
