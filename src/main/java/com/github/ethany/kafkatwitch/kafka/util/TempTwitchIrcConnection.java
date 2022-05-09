package com.github.ethany.kafkatwitch.kafka.util;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.logging.Logger;

@RequiredArgsConstructor
@Builder
public class TempTwitchIrcConnection implements Runnable{

    private final String channel;
    private final Logger logger;
    private final SocketOutputStreamDto streamDto;

    public void run() {
        try {
            streamDto.getOutputStream().write(("JOIN " + channel + "\n").getBytes(StandardCharsets.UTF_8));
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
            System.out.println(key);
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
