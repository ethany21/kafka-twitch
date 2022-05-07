package com.github.ethany.kafkatwitch.kafka.util;

import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.logging.Logger;

@AllArgsConstructor
public class CreateSocketConnection implements Runnable {

    private List<String> channels;
    private KafkaTemplate<String, String> kafkaTemplate;
    private String topic;
    private Logger logger;

    public void run() {
        try {
            try (Socket socket = new Socket("irc.chat.twitch.tv", 6667)) {
                OutputStream outputStream = socket.getOutputStream();
                outputStream.write(("PASS " + "oauth:kpz9iq7hk78g6ck8bycx5r3clg9vf9" + "\n").getBytes(StandardCharsets.UTF_8));
                outputStream.write(("NICK " + "davi21xxi" + "\n").getBytes(StandardCharsets.UTF_8));
                for (String channel : channels) {
                    outputStream.write(("JOIN " + channel + "\n").getBytes(StandardCharsets.UTF_8));
                }

                String line;

                while ((line = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8)).readLine()) != null) {
                    try {
                        if (line.split(" ")[0].equals(":PING")) {
                            outputStream.write(("PONG\n").getBytes(StandardCharsets.UTF_8));
                        } else {
                            String key = line.split(" ")[2];
                            kafkaTemplate.send(topic, key, line);
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                        logger.info("I Caught exception " + e.getMessage());
                    }
                }
            }
        } catch (IOException e) {
            logger.info(e.getMessage());
        }
    }
}
