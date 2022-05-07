package com.github.ethany.kafkatwitch.kafka.util;

import lombok.Builder;
import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.logging.Logger;

@RequiredArgsConstructor
@Builder
public class CreateSocketOutputStream {
    private final Logger logger;
    private OutputStream outputStream;
    private SocketOutputStreamDto streamDto;

    public SocketOutputStreamDto createSocketOutputStream() {
        try (Socket socket = new Socket("irc.chat.twitch.tv", 6667)) {
            outputStream = socket.getOutputStream();
            outputStream.write(("PASS " + "oauth:kpz9iq7hk78g6ck8bycx5r3clg9vf9" + "\n").getBytes(StandardCharsets.UTF_8));
            outputStream.write(("NICK " + "davi21xxi" + "\n").getBytes(StandardCharsets.UTF_8));
            streamDto = SocketOutputStreamDto.builder().socket(socket).outputStream(outputStream).build();
        } catch (IOException e) {
            logger.info(e.getMessage());
        }
        return streamDto;
    }

}
