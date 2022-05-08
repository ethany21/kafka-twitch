package com.github.ethany.kafkatwitch.kafka.util;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.kafka.core.KafkaTemplate;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.logging.Logger;

@RequiredArgsConstructor
@Builder
public class TwitchIrcConnection implements Runnable {
    private final List<String> channels;
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final String topic;
    private final Logger logger;

    private final SocketOutputStreamDto streamDto;

    public void run() {
        try {
            for (String channel : channels) {
                streamDto.getOutputStream().write(("JOIN " + channel + "\n").getBytes(StandardCharsets.UTF_8));
            }
            readMessageFromOutputStream();
        } catch (IOException e) {
            logger.info(e.getMessage());
        } finally {
            try {
                streamDto.getSocket().close();
                streamDto.getOutputStream().close();
            } catch (IOException e) {
                logger.info(e.getMessage());
            }

        }
    }

    public void kafkaOrIrcMultiplexer(@NotNull String line) throws IOException {
        if (line.split(" ")[0].equals("PING")) {
            streamDto.getOutputStream().write(("PONG\n").getBytes(StandardCharsets.UTF_8));
        } else {
            String key = line.split(" ")[2];
            kafkaTemplate.send(topic, key, line);
        }
    }

    public void readMessageFromOutputStream() throws IOException {
        String line;
        while ((line = new BufferedReader(new InputStreamReader(streamDto.getSocket().getInputStream(), StandardCharsets.UTF_8)).readLine()) != null) {
            catchUnexpectedMessage(line);
        }
    }

    public void catchUnexpectedMessage(String line) throws IOException {
        try {
            kafkaOrIrcMultiplexer(line);
        } catch (ArrayIndexOutOfBoundsException e) {
            logger.info("I Caught exception " + e.getMessage() + " which is : " + line);
        }
    }

}
